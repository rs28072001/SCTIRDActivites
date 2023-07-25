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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.sctirdactivites.ui.theme.Orange


@Composable
fun BasicDetails() {
    var name by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf(Date()) } // Initialize with current date
    var phoneNumber by remember { mutableStateOf("") }
    var Aadhaar by remember { mutableStateOf("") }
    var Address by remember { mutableStateOf("") }
    var pannumber by remember { mutableStateOf("") }
    var accountnumber by remember { mutableStateOf("") }
    var ifsccode by remember { mutableStateOf("") }
    var bankname by remember { mutableStateOf("") }
    var gamename by remember { mutableStateOf("") }
    var centrename by remember { mutableStateOf("") }
    var sarpanchname by remember { mutableStateOf("") }
    var sarpanchcontact by remember { mutableStateOf("") }

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
            colors = ButtonDefaults.buttonColors(Color(0xFFF05D6A))
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

        DateofBirthPickerBasic(
            date = dateOfBirth,
            onDateChange = { dateOfBirth = it },
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
            value = pannumber,
            onValueChange = { pannumber = it },
            label = { Text("PAN Number") },
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

        Text(
            text = "-: Bank Details :-",
            style = TextStyle(fontSize = 15.sp),
            fontWeight = FontWeight.SemiBold,
            textDecoration = TextDecoration.Underline
        )

        OutlinedTextField(
            value = bankname,
            onValueChange = { bankname = it },
            label = { Text("Bank Name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            isError = isFormSubmitted && Address.isBlank()
        )

        OutlinedTextField(
            value = accountnumber,
            onValueChange = { accountnumber = it },
            label = { Text("Account Number") },
            isError = isFormSubmitted && Aadhaar.isBlank(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next)
        )

        OutlinedTextField(
            value = ifsccode,
            onValueChange = { ifsccode = it },
            label = { Text("IFSC Code") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            isError = isFormSubmitted && Address.isBlank()
        )


        Text(
            text = "-: Work Details :-",
            style = TextStyle(fontSize = 15.sp),
            fontWeight = FontWeight.SemiBold,
            textDecoration = TextDecoration.Underline
        )

        OutlinedTextField(
            value = gamename,
            onValueChange = { gamename = it },
            label = { Text("Discipline Name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            isError = isFormSubmitted && Address.isBlank()
        )

        OutlinedTextField(
            value = ifsccode,
            onValueChange = { ifsccode = it },
            label = { Text("Centre Name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            isError = isFormSubmitted && Address.isBlank()
        )

        OutlinedTextField(
            value = accountnumber,
            onValueChange = { accountnumber = it },
            label = { Text("Sarpanch Name") },
            isError = isFormSubmitted && Aadhaar.isBlank(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
        )

        OutlinedTextField(
            value = accountnumber,
            onValueChange = { accountnumber = it },
            label = { Text("Sarpanch Ph. No.") },
            isError = isFormSubmitted && Aadhaar.isBlank(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next)
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
                if (validateFormBasic(
                        name,
                        phoneNumber,
                        Aadhaar,
                        Address,
                        pannumber,
                        accountnumber,
                        ifsccode,
                        bankname

                    )
                ) {
                    // Submit the form or perform other actions here
                } else {
                    // Set isFormSubmitted to true to show validation errors
                    isFormSubmitted = true
                }
            },
            modifier = Modifier.height(50.dp).width(300.dp),
            colors = ButtonDefaults.buttonColors(Orange)) {
            Text("Submit            ", color = Color.White, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.arrowtoright),
                contentDescription = "Arrow",
                contentScale = ContentScale.FillWidth
            )}
    }
}

fun validateFormBasic(
    name: String,
    phoneNumber: String,
    Aadhaar: String,
    Address: String,
    pannumber: String,
    accountnumber: String,
    ifsccode: String,
    bankname: String

):Boolean {
    return name.isNotBlank() &&
            phoneNumber.isNotBlank() &&
            Aadhaar.isNotBlank() &&
            Address.isNotBlank() &&
            pannumber.isNotBlank() &&
            accountnumber.isNotBlank() &&
            ifsccode.isNotBlank() &&
            bankname.isNotBlank()
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DateofBirthPickerBasic(
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







