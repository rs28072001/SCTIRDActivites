import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WomenFlowchartSCF() {
    var selectedDistrict by remember { mutableStateOf<String?>(null) }

    val districtBlocks = mapOf(
        "Hisar District" to listOf(
            "Adampur Block",
            "Women Empowerment & Life Skill Development",
            "Village Adampur -> Sewing Training Centre, Carpet Making",
            "Kabrel -> Sewing Training Centre, Organic Mashroom Jaivik Khaad Training",


            "Nalwa Block",
            "Women Empowerment & Life Skill Development",
            "Bure Bado -> Sewing Training Centre, Carpet Making",

            "Hansi Block",
            "Women Empowerment & Life Skill Development",
            "Hansi Trikona Park -> Sewing Training Centre",

            "Barwala Block",
            "Women Empowerment & Life Skill Development",
            "Village Mirzapur -> Sewing Training Centre",


            "Uklana Block",
            "Women Empowerment & Life Skill Development",
            "Bhim Rao Ambedkar Sabha, Uklana -> Village Adampur -> Sewing Training Centre, Carry Bag Making Training ",

            "Narnaud Block",
            "Women Empowerment & Life Skill Development",
            "Village Khedi Chopta -> Sewing Training Centre, Carry Bag Making Training ",


            "Hisar Urban",
            "Women Empowerment & Life Skill Development",
            "4th Floor PLA Market Hisar -> Sewing Training Centre, Carry Bag Making Training ",
        ),
        "Jind District" to listOf(
            "Uchana Block",
            "Women Empowerment & Life Skill Development",
            "Uchana -> Sewing Training Centre, Carry Bag Making Training",


            ),
        "Bhiwani District" to listOf(
            "Bawani Khera Block",
            "Women Empowerment & Life Skill Development",
            "Baliyali -> Sewing Training Centre, Carry Bag Making Training",
        )
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        WomenTitleCardSCF(title = "SCF Women Empowerment & Life Skill Development Centre")
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
                WomenBlocksList(blocks = it)
            }
        }
    }
}
@Composable
fun WomenTitleCardSCF(title: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ,
        shape = RoundedCornerShape(40.dp),
        colors = CardDefaults.cardColors(Color(0xFFFFCFE4)),
        elevation  = CardDefaults.cardElevation(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                text = title,
                style = TextStyle(
                    //fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                ),
                //letterSpacing = 4.sp,
                textAlign = TextAlign.Center

            )
        }
    }
}

@Composable
fun WomenBlocksList(blocks: List<String>) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        for (block in blocks) {
            WomenCard(blockName = block)
        }
    }
}

@Composable
fun WomenCard(blockName: String) {
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
        "Women Empowerment & Life Skill Development" -> Color(0xFFC2FDEA)
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


