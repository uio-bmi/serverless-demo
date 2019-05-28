package no.uio.ifi.bio

import org.junit.Test
import kotlin.test.assertEquals

val EXPECTED_RESULT = """
CLUSTAL W MSA from BioJava

P69905    MV-LSPADKTNVKAAWGKVGAHAGEYGAEALERMFLSFPTTKTYFPHF-DLS-----HGS  53
          || |.| .|. | | ||||  .  | | ||| |. . .| |. .|  | |||      |.
P68871    MVHLTPEEKSAVTALWGKV--NVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGN  58

P69905    AQVKGHGKKVADALTNAVAHVDDMPNALSALSDLHAHKLRVDPVNFKLLSHCLLVTLAAH 113
           .|| |||||  | .. .||.|..    . ||.||  || ||| ||.|| . |.  || |
P68871    PKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHH 118

P69905    LPAEFTPAVHASLDKFLASVSTVLTSKY 141
             |||| |.|.  | .| |.  |  ||
P68871    FGKEFTPPVQAAYQKVVAGVANALAHKY 146

""".trimIndent()


class SmithWatermanTest {

    @Test
    fun testGetAlignment() {
        val alignment = getAlignment("P69905", "P68871")
        LOGGER.info("alignment:\n{}", alignment)
        assertEquals(EXPECTED_RESULT, alignment)
    }

}
