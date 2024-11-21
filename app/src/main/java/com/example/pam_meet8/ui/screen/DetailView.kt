package com.example.pam_meet8.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_meet8.model.Mahasiswa
import com.example.pam_meet8.model.RencanaStudy

@Composable
fun DetailView(
    modifier: Modifier = Modifier,
    mahasiswaUiState: Mahasiswa,
    krsStateUi: RencanaStudy,
    onBackButtonClicked: () -> Unit
) {
    // Data Mahasiswa
    val dataMhs = listOf(
        Pair("Nama", mahasiswaUiState.nama),
        Pair("NIM", mahasiswaUiState.nim),
        Pair("Email", mahasiswaUiState.email)
    )

    // Data Rencana Studi
    val dataRencana = listOf(
        Pair("Mata Kuliah", krsStateUi.mataKuliah),
        Pair("Kelas", krsStateUi.kelas)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Menambahkan jarak antar elemen
    ) {
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Detail Mahasiswa",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        // Menampilkan Data Mahasiswa
        dataMhs.forEach { item ->
            CardSection(judulParam = item.first, isiParam = item.second)
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Detail Rencana Studi",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        // Menampilkan Data Rencana Studi
        dataRencana.forEach { item ->
            CardSection(judulParam = item.first, isiParam = item.second)
        }

        // Tombol Kembali di tengah
        ElevatedButton(
            onClick = { onBackButtonClicked() },
            modifier = Modifier.fillMaxWidth() // Tombol akan mengisi lebar layar
        ) {
            Text("Kembali")
        }
    }
}


@Composable
fun CardSection(judulParam: String, isiParam: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = judulParam, fontWeight = FontWeight.Bold, modifier = Modifier.weight(2f))
        Text(text = ":", modifier = Modifier.weight(1f))
        Text(text = isiParam, modifier = Modifier.weight(3f))
    }
}

