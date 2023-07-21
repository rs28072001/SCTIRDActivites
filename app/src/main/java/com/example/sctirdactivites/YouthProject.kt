import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sctirdactivites.CardItem
import com.example.sctirdactivites.R
import com.example.sctirdactivites.onItemClick

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun YouthPage() {
    Scaffold {
        Column {
            // Other content

            DistrictCardsFlowchartSCFtest()


            // Other content
        }
    }
}


@Composable
fun TitleCardSCF(title: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ,
        shape = RoundedCornerShape(40.dp),
        colors = CardDefaults.cardColors(Color(0xFFFFEEEE)),
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
                letterSpacing = 4.sp,
                textAlign = TextAlign.Center

            )
        }
    }
}

@Composable
fun DistrictCardsFlowchartSCFtest() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .drawFlowchartLine()
    ) {
        TitleCardSCF(title = "SCF Sports Academy")
        Row(
            modifier = Modifier
                .padding(top = 50.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            DistrictCard(districtName = "Hisar District") {
                // Click action for District A
                // Implement your logic here
                // For example: navigate to a different screen, show a dialog, etc.
            }
            DistrictCard(districtName = "Jind District") {
                // Click action for District A
                // Implement your logic here
                // For example: navigate to a different screen, show a dialog, etc.
            }
            DistrictCard(districtName = "Bhiwani District") {
                // Click action for District A
                // Implement your logic here
                // For example: navigate to a different screen, show a dialog, etc.
            }

        }
    }
}

@Composable
fun DistrictCard(districtName: String,onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(122.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(Color(0xFFE1D1FF)),
        elevation  = CardDefaults.cardElevation(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = districtName,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

private fun Modifier.drawFlowchartLine(): Modifier = this.drawBehind {
    drawLine(
        color = Color.Gray,
        start = Offset(size.width / 2, 78f),
        end = Offset(size.width / 2, (size.height*0.8).toFloat()),
        strokeWidth = 7f,
    )
    drawLine(
        color = Color.Gray,
        start = Offset((size.width/6.8).toFloat(), (size.height * 0.9 / 2).toFloat()),
        end = Offset((size.width*0.8).toFloat(), (size.height * 0.9 / 2).toFloat()),
        strokeWidth = 7f,
    )
    drawLine(
        color = Color.Gray,
        start = Offset((size.width*0.15).toFloat(), (size.height * 0.9 / 2).toFloat()),
        end = Offset((size.width*0.15).toFloat(), (size.height*0.8).toFloat()),
        strokeWidth = 7f,
    )
    drawLine(
        color = Color.Gray,
        start = Offset((size.width*0.8).toFloat(), (size.height * 0.9 / 2).toFloat()),
        end = Offset((size.width*0.8).toFloat(), (size.height*0.8).toFloat()),
        strokeWidth = 7f,
    )

}

@Composable
fun MyUI() {
    val randomText = stringResource(id = R.string.random_text)

    // remember the state of the card
    var expanded by remember {
        mutableStateOf(false) // initial value
    }

    // last index of the first line
    var lastIndex = 0

    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(50f)
        ,
        shape = RoundedCornerShape(size = 18.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable {
                    expanded = !expanded // toggle the state
                }
                .padding(all = 8.dp)
        ) {
            // first line
            Text(
                text = randomText,
                maxLines = 1,
                overflow = if (expanded) TextOverflow.Clip else TextOverflow.Ellipsis,
                onTextLayout = { textLayoutResult ->
                    // get the last index
                    lastIndex = textLayoutResult.getLineEnd(
                        lineIndex = 0,
                        visibleEnd = true
                    )
                }
            )

            // animate the text
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                // remaining text
                Text(
                    text = randomText.substring(lastIndex + 1), // display the remaining text
                    maxLines = Int.MAX_VALUE // display the whole text
                )
            }
        }
    }
}




@Composable
fun DistrictCardWithExpandable(districtName: String) {
    val randomText = stringResource(id = R.string.random_text)

    // remember the state of the card
    var expanded by remember {
        mutableStateOf(false) // initial value
    }

    // last index of the first line
    var lastIndex = 0

    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(50f),
        shape = RoundedCornerShape(size = 18.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable {
                    expanded = !expanded // toggle the state
                }
                .padding(all = 8.dp)
        ) {
            // first line (district name)
            Text(
                text = districtName,
                maxLines = 1,
                overflow = if (expanded) TextOverflow.Clip else TextOverflow.Ellipsis,
                onTextLayout = { textLayoutResult ->
                    // get the last index
                    lastIndex = textLayoutResult.getLineEnd(
                        lineIndex = 0,
                        visibleEnd = true
                    )
                }
            )

            // animate the text
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                // remaining text (expandable card content)
                Text(
                    text = randomText, // For demonstration, you can customize this content as needed
                    maxLines = Int.MAX_VALUE // display the whole text
                )
            }
        }
    }
}