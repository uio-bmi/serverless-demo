package no.uio.ifi

import org.junit.Test
import kotlin.test.assertEquals

val EXPECTED_RESULT = """
            1                                                         60
P69905    1 MV-LSPADKTNVKAAWGKVGAHAGEYGAEALERMFLSFPTTKTYFPHF-DLS-----HGS  53
            || |.| .|. | | ||||  .  | | ||| |. . .| |. .|  | |||      |.
P68871    1 MVHLTPEEKSAVTALWGKV--NVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGN  58

            61                                                       120
P69905   54 AQVKGHGKKVADALTNAVAHVDDMPNALSALSDLHAHKLRVDPVNFKLLSHCLLVTLAAH 113
             .|| |||||  | .. .||.|..    . ||.||  || ||| ||.|| . |.  || |
P68871   59 PKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHH 118

            121                      148
P69905  114 LPAEFTPAVHASLDKFLASVSTVLTSKY 141
               |||| |.|.  | .| |.  |  ||
P68871  119 FGKEFTPPVQAAYQKVVAGVANALAHKY 146

""".trimIndent()


class SmithWatermanTest {

    @Test
    fun testGetAlignment() {
        val alignment = getAlignment("P69905", "P68871")
        LOGGER.info("alignment:\n{}", alignment)
        assertEquals(EXPECTED_RESULT, alignment)
    }

}
