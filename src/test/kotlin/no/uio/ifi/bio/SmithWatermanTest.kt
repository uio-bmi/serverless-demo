package no.uio.ifi.bio

import org.junit.Test
import kotlin.test.assertEquals

val EXPECTED_RESULT = """
CLUSTAL W MSA from BioJava

P69905    LSPADKTNVKAAWGKVGAHAGEYGAEALERMFLSFPTTKTYFPHF-DLS-----HGSAQV  56
          |.| .|. | | ||||  .  | | ||| |. . .| |. .|  | |||      |. .|
P68871    LTPEEKSAVTALWGKV--NVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKV  61

P69905    KGHGKKVADALTNAVAHVDDMPNALSALSDLHAHKLRVDPVNFKLLSHCLLVTLAAHLPA 116
          | |||||  | .. .||.|..    . ||.||  || ||| ||.|| . |.  || |
P68871    KAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGK 121

P69905    EFTPAVHASLDKFLASVSTVLTSKY 141
          |||| |.|.  | .| |.  |  ||
P68871    EFTPPVQAAYQKVVAGVANALAHKY 146

""".trimIndent()


class SmithWatermanTest {

    @Test
    fun testGetAlignment() {
        val alignment = getAlignment("P69905", "P68871")
        LOGGER.info("alignment:\n{}", alignment)
        assertEquals(EXPECTED_RESULT, alignment)
    }

}
