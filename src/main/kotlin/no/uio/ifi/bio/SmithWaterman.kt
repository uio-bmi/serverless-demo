package no.uio.ifi.bio

import org.biojava.nbio.alignment.Alignments
import org.biojava.nbio.alignment.Alignments.PairwiseSequenceAlignerType
import org.biojava.nbio.alignment.SimpleGapPenalty
import org.biojava.nbio.core.alignment.matrices.SubstitutionMatrixHelper
import org.biojava.nbio.core.alignment.template.Profile
import org.biojava.nbio.core.sequence.ProteinSequence
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound
import org.biojava.nbio.core.sequence.io.FastaReaderHelper
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import java.net.URL

val LOGGER: Logger = getLogger("no.uio.ifi")

const val DEFAULT_FORMAT = "CLUSTALW"

fun getAlignment(
    uniProteinId1: String,
    uniProteinId2: String,
    gapOpenPenalty: Int? = null,
    gapExtensionPenalty: Int? = null,
    format: String? = DEFAULT_FORMAT
): String {
    LOGGER.info("gapOpenPenalty: {}, gapExtensionPenalty: {}, format: {}", gapOpenPenalty, gapExtensionPenalty, format)

    val sequence1 = getSequenceById(uniProteinId1)
    LOGGER.info("sequence1: {}", sequence1)

    val sequence2 = getSequenceById(uniProteinId2)
    LOGGER.info("sequence2: {}", sequence2)

    val matrix = SubstitutionMatrixHelper.getBlosum65()
    val penalty = SimpleGapPenalty()
    gapOpenPenalty?.let { penalty.openPenalty = it }
    gapExtensionPenalty?.let { penalty.extensionPenalty = it }

    val smithWaterman = Alignments.getPairwiseAligner<ProteinSequence, AminoAcidCompound>(
        sequence1,
        sequence2,
        PairwiseSequenceAlignerType.LOCAL,
        penalty,
        matrix
    )

    return smithWaterman.pair.toString(Profile.StringFormat.valueOf(format ?: DEFAULT_FORMAT))
}

fun getSequenceById(uniProteinId: String): ProteinSequence? {
    val url =
        "http://www.ebi.ac.uk/Tools/dbfetch/dbfetch?db=uniprotkb&id=$uniProteinId&format=fasta&style=raw&Retrieve=Retrieve"
    LOGGER.info("url: {}", url)
    val uniProteinFasta = URL(url)
    return FastaReaderHelper.readFastaProteinSequence(uniProteinFasta.openStream())[uniProteinId]
}
