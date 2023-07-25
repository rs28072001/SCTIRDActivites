package com.example.sctirdactivites

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.app.DatePickerDialog
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.ui.ExperimentalComposeUiApi
import java.util.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.sctirdactivites.ui.theme.Orange


@Composable
fun SendDailyReport() {
    var name by remember { mutableStateOf("") }
    var dateOfProgress by remember { mutableStateOf(Date()) } // Initialize with current date
    var place by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var achievements by remember { mutableStateOf("") }
    var trainingtype by remember { mutableStateOf("") }
    var morningSessionBoy by remember { mutableStateOf("") }
    var morningSessionGirl by remember { mutableStateOf("") }
    var eveningSessionBoy by remember { mutableStateOf("") }
    var eveningSessionGirl by remember { mutableStateOf("") }

    // State to store the selected images
    var selectedImages by remember { mutableStateOf(listOf<Uri>()) }
    // Function to launch the image picker
    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) {
        // Limit the number of selected images to 4
        selectedImages = it.take(4)}

    // MutableState to track if the form is submitted
    var isFormSubmitted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            isError = isFormSubmitted && name.isBlank(),
            label = { Text("Name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next
            )
        )

        DatePicker(
            date = dateOfProgress,
            onDateChange = { dateOfProgress = it },
            label = { Text("Date of Progress") },
        )

        OutlinedTextField(
            value = place,
            onValueChange = { place = it },
            label = { Text("Travel Place") },
            isError = isFormSubmitted && place.isBlank(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Work Progress") },
            isError = isFormSubmitted && description.isBlank(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next
            )

        )

        OutlinedTextField(
            value = achievements,
            onValueChange = { achievements = it },
            label = { Text("Any Achievement ") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = trainingtype,
            onValueChange = { trainingtype = it },
            label = { Text("Training Type") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            isError = isFormSubmitted && trainingtype.isBlank()
        )
        // Heading for Morning Session Present
        Text(
            text = "Morning Session Present",
            style = TextStyle(fontSize = 15.sp),
            fontWeight = FontWeight.SemiBold
        )

        // Boy and Girl fields for Morning Session Present
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(300.dp)
        ) {
            OutlinedTextField(
                value = morningSessionBoy,
                onValueChange = { morningSessionBoy = it },
                label = { Text("Boy") },
                isError = isFormSubmitted && morningSessionBoy.isBlank(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = morningSessionGirl,
                onValueChange = { morningSessionGirl = it },
                label = { Text("Girl") },
                isError = isFormSubmitted && morningSessionGirl.isBlank(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next),
                modifier = Modifier.weight(1f)
            )
        }
        // Heading for Evening Session Present
        Text(
            text = "Evening Session Present",
            style = TextStyle(fontSize = 15.sp),
            fontWeight = FontWeight.SemiBold
        )

        // Boy and Girl fields for Evening Session Present
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(300.dp)
        ) {
            OutlinedTextField(
                value = eveningSessionBoy,
                onValueChange = { eveningSessionBoy = it },
                label = { Text("Boy") },
                isError = isFormSubmitted && eveningSessionBoy.isBlank(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next),

                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = eveningSessionGirl,
                onValueChange = { eveningSessionGirl = it },
                label = { Text("Girl") },
                isError = isFormSubmitted && eveningSessionGirl.isBlank(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next),
                modifier = Modifier.weight(1f)
            )
        }
        // Button to launch the image picker
        Button(
            onClick = { galleryLauncher.launch("image/*") },
            modifier = Modifier.height(50.dp).width(240.dp).clip(RoundedCornerShape(25.dp)),
            colors = ButtonDefaults.buttonColors(Color(0xFF48B6E9))
        ) {
            Text("Pick Progress Images", color = Color.White, fontWeight = FontWeight.Bold)

        }

        // Display selected images
        if (selectedImages.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (imageUri in selectedImages) {
                    Image(
                        painter = rememberImagePainter(data = imageUri),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }

        Button(
            onClick = {
                // Validate the form fields before proceeding
                if (validateForm(
                        name,
                        place,
                        description,
                        trainingtype,
                        morningSessionBoy,
                        morningSessionGirl,
                        eveningSessionBoy,
                        eveningSessionGirl
                    )
                ) {
                    // Submit the form or perform other actions here
                } else {
                    // Set isFormSubmitted to true to show validation errors
                    isFormSubmitted = true
                }
            },
            modifier = Modifier.height(50.dp).width(340.dp),
            colors = ButtonDefaults.buttonColors(Orange)) {
            Text("Submit   ", color = Color.White, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.arrowtoright),
                contentDescription = "Arrow",
                contentScale = ContentScale.FillWidth
            )}
    }
}

fun validateForm(
    name: String,
    place: String,
    description: String,
    trainingtype: String,
    morningSessionBoy: String,
    morningSessionGirl: String,
    eveningSessionBoy: String,
    eveningSessionGirl: String
):Boolean {
    return name.isNotBlank() &&
            place.isNotBlank() &&
            description.isNotBlank() &&
            trainingtype.isNotBlank() &&
            morningSessionBoy.isNotBlank() &&
            morningSessionGirl.isNotBlank() &&
            eveningSessionBoy.isNotBlank() &&
            eveningSessionGirl.isNotBlank()
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DatePicker(
    date: Date,
    onDateChange: (Date) -> Unit,
    label: @Composable () -> Unit
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date),
        onValueChange = {},
        label = label,
        readOnly = true,
        trailingIcon = {
            IconButton(onClick = {
                keyboardController?.hide()
                DatePickerDialog(
                    context,
                    { _, year, month, dayOfMonth ->
                        val calendar = Calendar.getInstance()
                        calendar.set(year, month, dayOfMonth)
                        onDateChange(calendar.time)
                    },
                    date.year + 1900, date.month, date.date
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Select Date"
                )
            }
        }
    )


}







@Composable
fun App() {
    MaterialTheme {
        Surface(color = Color.White) {
            SendDailyReport()
        }
    }
}

@Preview
@Composable
fun PreviewApp() {
    App()
}