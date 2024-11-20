package com.example.pam_meet8.ui.screen

import android.os.strictmode.UntaggedSocketViolation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pam_meet8.R
import com.example.pam_meet8.model.Mahasiswa
import com.example.pam_meet8.model.RencanaStudy

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
){
    var chosenDropdown by remember {
        mutableStateOf(
            ""
        )
    }
    var checked by remember { mutableStateOf(false) }
    var pilihanKelas by remember {
        mutableStateOf("")
    }
    var listData: MutableList<String> = mutableListOf(chosenDropdown, pilihanKelas) // menampilkan data pilihan kelas
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth() // agar row menjadi selebar layar
                .padding(16.dp), // jarak 16dp diseluruh sisi Row
            verticalAlignment = Alignment.CenterVertically // mengatur agar row berada ditengah
        ){
            Image( // komponen gambar
                painter = painterResource(id = R.drawable.umy), // sumber gambar dari res drawable.umy
                contentDescription = "", // deskripsi konten null
                modifier = Modifier
                    .clip(shape = CircleShape) // membuat gambar menjadi lingkaran
                    .size(50.dp) // ukuran gambar 50dp
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
        }
    }
}