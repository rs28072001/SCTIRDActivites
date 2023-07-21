
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun DistrictCardsFlowchartSCF() {
    var selectedDistrict by remember { mutableStateOf<String?>(null) }

    val districtBlocks = mapOf(
        "Hisar District" to listOf(
            "Adampur Block",
            "Excellency Academy Center",
            "Mandi Adampur -> Athletics/Throwball",
            "Kishangarh -> Athletics",
            "Village Adampur -> Boxing",
            "Sadalpur -> Boxing",

            "Main Academy Center",
            "Dadouli -> Kabaddi",
            "Moda Khera -> Baseball",
            "Sarangpur -> Athletics",

            "Supporting Academy Center",
            "Khaasa Mahajanan ->  Football",
            "Siswal -> Kick Boxing/Wushu",
            "Jagan -> Wushu",
            "Khairampur -> Athletics",
            "Kohli -> Athletics",

            "Nalwa Block",

            "Main Academy Center",
            "Bure Bado -> Boxing",
            "Muklan -> Baseball",

            "Supporting Academy Center",
            "Sarsana -> Handball",
            "Bhiwani Rohila -> Baseball Girl",

            "Hansi Block",
            "Main Academy Center",
            "Dhamana -> Boxing",
            "Garhi -> Athletics",

            "Supporting Academy Center",
            "Thurana -> Athletics",


            "Barwala Block",
            "Main Academy Center",
            "Niyana -> Wrestling",
            "Satrod Khaas -> Handball / Boxing",

            "Supporting Academy Center",
            "Juglaan -> Football",
            "Dhansu -> Wrestling",

            "Uklana Block",
            "Main Academy Center",
            "Kirmara -> Kabaddi",
            "Gabipur -> Athletics",
            "Balak -> Athletics",
            "Prabhuwala -> Football",
            "Bheri AKbarpur -> Boxing",

            "Supporting Academy Center",
            "Agroha -> Football",
            "Kuleri -> Kabaddi",
            "Daulatpur -> Athletics",


            "Narnaud Block",
            "Main Academy Center",
            "Lahori Ragho -> Athletics",
            "Gurana -> Kabaddi",
            "Sisar -> Kho - Khoo",

            "Supporting Academy Center",
            "Masudpur -> Football",


            "Hisar Urban"
        ),
        "Jind District" to listOf(
            "Uchana Block",
            "Main Academy Center",
            "Ghaso Kala -> Kabaddi",
            "Kheri Masaniya -> Athletics"


            ),
        "Bhiwani District" to listOf(
            "Bawani Khera Block",
            "Main Academy Center",
            "Baliyali -> Boxing",
            "Kharak -> Handball"
        )
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TitleCardSCF(title = "SCF Sports Academy")
        Row(
            modifier = Modifier
                .padding(top = 50.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            DistrictCard(districtName = "Hisar District") {
                selectedDistrict = "Hisar District"
            }
            DistrictCard(districtName = "Jind District") {
                selectedDistrict = "Jind District"
            }
            DistrictCard(districtName = "Bhiwani District") {
                selectedDistrict = "Bhiwani District"
            }
        }

        // Display the blocks based on the selected district
        selectedDistrict?.let { district ->
            val blocks = districtBlocks[district]
            blocks?.let {
                DistrictBlocksList(blocks = it)
            }
        }
    }
}



@Composable
fun DistrictBlocksList(blocks: List<String>) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        for (block in blocks) {
            BlockCard(blockName = block)
        }
    }
}

@Composable
fun BlockCard(blockName: String) {
    val backgroundColor = when (blockName) {
        "Adampur Block",
        "Hansi Block",
        "Nalwa Block",
        "Barwala Block",
        "Uklana Block",
        "Narnaud Block",
        "Uchana Block",
        "Bawani Khera Block",
        "Hisar Urban" -> Color(0xFFFFAF5A)
        "Excellency Academy Center" -> Color(0xFFEFFFA4)
        "Main Academy Center" -> Color(0xFFC2FDEA)
        "Supporting Academy Center" -> Color(0xFFD5FFD3)
            // Add more cases for other block names if needed
        else -> Color(0xFFEEF3FF) // Default background color
    }

    val fontWeight = when (blockName) {
        "Adampur Block",
        "Hansi Block",
        "Nalwa Block",
        "Barwala Block",
        "Uklana Block",
        "Narnaud Block",
        "Uchana Block",
        "Bawani Khera Block",
        "Hisar Urban" -> FontWeight.Bold
        else -> FontWeight.Normal
    }
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(backgroundColor),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = blockName,
                fontWeight = fontWeight,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}


