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
fun DocumentKYC() {
    // State to store the selected images
    var aadhaarImages by remember { mutableStateOf(listOf<Uri>()) }
    // Function to launch the image picker
    val aadhaarImagesLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) {
        // Limit the number of selected images to 1
        aadhaarImages = it.take(1)}

    // State to store the selected images
    var panImages by remember { mutableStateOf(listOf<Uri>()) }
    // Function to launch the image picker
    val panLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) {
        // Limit the number of selected images to 1
        panImages = it.take(1)}

    // State to store the selected images
    var bankImages by remember { mutableStateOf(listOf<Uri>()) }
    // Function to launch the image picker
    val bankLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) {
        // Limit the number of selected images to 1
        bankImages = it.take(1)}

    // MutableState to track if the form is submitted
    var isFormSubmitted by remember { mutableStateOf(false) }

    // Define a state variable to keep track of image upload
    var isImageUploaded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Button to launch the Aadhaar Image picker
        Button(
            onClick = { aadhaarImagesLauncher.launch("image/*") },
            modifier = Modifier.width(200.dp).clip(RoundedCornerShape(50.dp)),
            colors = ButtonDefaults.buttonColors(if (isImageUploaded) Color(0xFF56E737) else Color(0xFF9579FC))
        ) {
            Text("Aadhaar Card", color = Color.White, fontWeight = FontWeight.Bold)

        }

        // Button to launch the Pan Card image picker
        Button(
            onClick = {
                panLauncher.launch("image/*")
                isImageUploaded = true },
            modifier = Modifier.width(200.dp).clip(RoundedCornerShape(50.dp)),
            colors = ButtonDefaults.buttonColors(if (isImageUploaded) Color(0xFF56E737) else Color(0xFF9579FC))
        ) {
            Text("PAN Card", color = Color.White, fontWeight = FontWeight.Bold)

        }
        // Button to launch the Bank image picker
        Button(
            onClick = { bankLauncher.launch("image/*") },
            modifier = Modifier.width(200.dp).clip(RoundedCornerShape(50.dp)),
            colors = ButtonDefaults.buttonColors(if (isImageUploaded) Color(0xFF56E737) else Color(0xFF9579FC))
        ) {
            Text("Bank Passbook", color = Color.White, fontWeight = FontWeight.Bold)
        }

        // Display selected images
        if (aadhaarImages.isNotEmpty() || panImages.isNotEmpty() || bankImages.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (imageUri in aadhaarImages) {
                    Image(
                        painter = rememberImagePainter(data = imageUri),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop,
                    )
                }
                for (imageUri in panImages) {
                    Image(
                        painter = rememberImagePainter(data = imageUri),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop,
                    )
                }
                for (imageUri in bankImages) {
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
                      },
            modifier = Modifier.height(50.dp).width(340.dp),
            colors = ButtonDefaults.buttonColors(Orange)) {
            Text("Submit   ", color = Color.White, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.arrowtoright),
                contentDescription = "Arrow",
                contentScale = ContentScale.FillWidth
            )
        }
    }
}









