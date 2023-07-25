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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import coil.compose.rememberImagePainter
import com.example.sctirdactivites.ui.theme.Orange


@Composable
fun RegisterParticipant() {
    var name by remember { mutableStateOf("") }
    var dateOfProgress by remember { mutableStateOf(Date()) } // Initialize with current date
    var phoneNumber by remember { mutableStateOf("") }
    var Aadhaar by remember { mutableStateOf("") }
    var Address by remember { mutableStateOf("") }

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
        // Button to launch the image picker
        Button(
            onClick = { galleryLauncher.launch("image/*") },
            modifier = Modifier.height(100.dp).width(100.dp).clip(RoundedCornerShape(100.dp)),
            colors = ButtonDefaults.buttonColors(Color(0xFF9579FC))
        ) {
            Text("Photo", color = Color.White, fontWeight = FontWeight.Bold)

        }

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            isError = isFormSubmitted && name.isBlank(),
            label = { Text("Name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next
            )
        )

        DateofBirthPicker(
            date = dateOfProgress,
            onDateChange = { dateOfProgress = it },
            label = { Text("Date of Birth") },
        )

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Mobile Number") },
            isError = isFormSubmitted && phoneNumber.isBlank(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = Aadhaar,
            onValueChange = { Aadhaar = it },
            label = { Text("Aadhaar Number") },
            isError = isFormSubmitted && Aadhaar.isBlank(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next)

        )


        OutlinedTextField(
            value = Address,
            onValueChange = { Address = it },
            label = { Text("Address") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            isError = isFormSubmitted && Address.isBlank()
        )




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
                if (validateFormParticipant(
                        name,
                        phoneNumber,
                        Aadhaar,
                        Address

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

fun validateFormParticipant(
    name: String,
    phoneNumber: String,
    Aadhaar: String,
    Address: String,

):Boolean {
    return name.isNotBlank() &&
            phoneNumber.isNotBlank() &&
            Aadhaar.isNotBlank() &&
            Address.isNotBlank()
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DateofBirthPicker(
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







