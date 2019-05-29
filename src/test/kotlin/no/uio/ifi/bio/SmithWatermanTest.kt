package no.uio.ifi.bio

import org.junit.Test
import kotlin.test.assertEquals

const val EXPECTED_RESULT = "CLUSTAL W MSA from BioJava\n" +
        "\n" +
        "P69905    LSPADKTNVKAAWGKVGAHAGEYGAEALERMFLSFPTTKTYFPHF-DLS-----HGSAQV  56\n" +
        "          |.| .|. | | ||||  .  | | ||| |. . .| |. .|  | |||      |. .|\n" +
        "P68871    LTPEEKSAVTALWGKV--NVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKV  61\n" +
        "\n" +
        "P69905    KGHGKKVADALTNAVAHVDDMPNALSALSDLHAHKLRVDPVNFKLLSHCLLVTLAAHLPA 116\n" +
        "          | |||||  | .. .||.|..    . ||.||  || ||| ||.|| . |.  || |   \n" +
        "P68871    KAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGK 121\n" +
        "\n" +
        "P69905    EFTPAVHASLDKFLASVSTVLTSKY 141\n" +
        "          |||| |.|.  | .| |.  |  ||\n" +
        "P68871    EFTPPVQAAYQKVVAGVANALAHKY 146\n"


class SmithWatermanTest {

    @Test
    fun testGetAlignment() {
        val alignment = getAlignment("P69905", "P68871")
        LOGGER.info("alignment:\n{}", alignment)
        assertEquals(EXPECTED_RESULT, alignment)
    }

}
