package no.uio.ifi

import org.biojava.nbio.alignment.Alignments
import org.biojava.nbio.alignment.Alignments.PairwiseSequenceAlignerType
import org.biojava.nbio.alignment.SimpleGapPenalty
import org.biojava.nbio.core.alignment.matrices.SubstitutionMatrixHelper
import org.biojava.nbio.core.sequence.ProteinSequence
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound
import org.biojava.nbio.core.sequence.io.FastaReaderHelper
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import java.net.URL

val LOGGER: Logger = getLogger("no.uio.ifi")

fun getAlignment(uniProteinId1: String, uniProteinId2: String): String? {

    val sequence1 = getSequenceById(uniProteinId1)
    val sequence2 = getSequenceById(uniProteinId2)

    LOGGER.info("sequence1: {}", sequence1)
    LOGGER.info("sequence2: {}", sequence2)

    val matrix = SubstitutionMatrixHelper.getBlosum65()

    val penalty = SimpleGapPenalty()

    val gop = 8
    val extend = 1
    penalty.openPenalty = gop
    penalty.extensionPenalty = extend


    val smithWaterman = Alignments.getPairwiseAligner<ProteinSequence, AminoAcidCompound>(
        sequence1,
        sequence2,
        PairwiseSequenceAlignerType.LOCAL,
        penalty,
        matrix
    )

    return smithWaterman.pair.toString(60)
}

fun getSequenceById(uniProteinId: String): ProteinSequence? {
    val url = "http://www.ebi.ac.uk/Tools/dbfetch/dbfetch?db=uniprotkb&id=$uniProteinId&format=fasta&style=raw&Retrieve=Retrieve"
    LOGGER.info("url: {}", url)
    val uniProteinFasta = URL(url)
    return FastaReaderHelper.readFastaProteinSequence(uniProteinFasta.openStream())[uniProteinId]
}
