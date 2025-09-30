package com.example.namecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.mahful.namecard.ui.theme.NamecardTheme
import com.mahful.namecard.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NamecardTheme {
                // Surface yang mengisi layar — set background sesuai gambar (mint/pale green)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFEAF7EE) // ubah kalau mau shade lain
                ) {
                    NameCardScreen(
                        name = "Mahful YF",
                        title = "Android Developer Extraordinaire",
                        phone = "+062856782834",
                        handle = "@AndroidDev",
                        email = "mahfulyf@android.com"
                    )
                }
            }
        }
    }
}

@Composable
fun NameCardScreen(
    name: String,
    title: String,
    phone: String,
    handle: String,
    email: String,
    modifier: Modifier = Modifier
) {
    // Column yang membagi layar: konten tengah (logo + nama) dan konten bawah (kontak)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Bagian atas: beri spacing agar logo dan teks tampak di tengah area atas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 200.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Kotak  berisi logo
            Surface(
                shape = RoundedCornerShape(6.dp),
                tonalElevation = 4.dp,
                color = Color(0xFF023B36), // dark teal background inside kotak
                modifier = Modifier.size(120.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.android),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .padding(16.dp)
                            .size(95.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Nama (besar, center)
            Text(
                text = name,
                fontSize = 34.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF143A35) // warna teks gelap
            )

            // Subtitle (lebih kecil, hijau)
            Text(
                text = title,
                fontSize = 18.sp,
                color = Color(0xFF0F7A66),
                modifier = Modifier.padding(top = 5.dp)
            )
        }

        //  Bawah: kontak — diletakkan di bawah dengan padding bottom
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 75.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactRow(icon = Icons.Filled.Call, text = phone)
            Spacer(modifier = Modifier.height(8.dp))
            ContactRow(icon = Icons.Filled.Share, text = handle)
            Spacer(modifier = Modifier.height(8.dp))
            ContactRow(icon = Icons.Filled.Email, text = email)
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "konten",
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, fontSize = 15.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun NameCardPreview() {
    NamecardTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFD2E8D4)) {
            NameCardScreen(
                name = "Mahful YF",
                title = "Android Developer Extraordinaire",
                phone = "+062856782834",
                handle = "@AndroidDev",
                email = "mahfulyf@android.com"
            )
        }
    }
}