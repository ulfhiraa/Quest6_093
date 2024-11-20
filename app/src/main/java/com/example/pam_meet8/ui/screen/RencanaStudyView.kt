package com.example.pam_meet8.ui.screen

import android.os.strictmode.UntaggedSocketViolation
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.AlertDialogDefaults.textContentColor
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_meet8.R
import com.example.pam_meet8.data.MataKuliah
import com.example.pam_meet8.data.RuangKelas
import com.example.pam_meet8.model.Mahasiswa
import com.example.pam_meet8.model.RencanaStudy
import com.example.pam_meet8.ui.widget.DynamicSelectedTextField

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
) {
    var chosenDropdown by remember {
        mutableStateOf(
            ""
        )
    }
    var checked by remember { mutableStateOf(false) }
    var pilihanKelas by remember {
        mutableStateOf("")
    }
    var listData: MutableList<String> =
        mutableListOf(chosenDropdown, pilihanKelas) // menampilkan data pilihan kelas
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth() // agar row menjadi selebar layar
                .padding(16.dp), // jarak 16dp diseluruh sisi Row
            verticalAlignment = Alignment.CenterVertically // mengatur agar row berada ditengah
        ) {
            Image( // komponen gambar
                painter = painterResource(id = R.drawable.umy), // sumber gambar dari res drawable.umy
                contentDescription = "", // deskripsi konten null
                modifier = Modifier
                    .clip(shape = CircleShape) // membuat gambar menjadi lingkaran
                    .size(50.dp) // ukuran gambar 50dp
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text( // elemen text yang menampilkan nama Mahasiswa
                    text = mahasiswa.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White
                )
                Text( // elemen text yang menampilkan nim
                    text = mahasiswa.nim,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Box{
                Icon(
                    imageVector = Icons.Filled.Notifications, // ikon notifikasi
                    contentDescription = "",
                    tint = Color.White // agar ikon berwarna putih
                )
            }
        }
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape( // bentuk bulat
                        topEnd = 15.dp, //sudut kanan atas
                        topStart = 15.dp // sudut kiri atas
                    )
                )
                .fillMaxSize(),
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                Text(text = "Pilih Mata Kuliah", fontWeight = FontWeight.Bold)
                Text(
                    text = "Silakan pilih mata kuliah yang anda inginkan",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(8.dp))
                DynamicSelectedTextField( // komponen custom untuk menampilkan input teks dengan memilih nilai dari opsi yang disediakan
                    selectedValue = chosenDropdown, // selectedValue : nilai yang dipilih dari dropdown, chosenDropdown :  variabel yang menyimpan nilai yg dipilih
                    options = MataKuliah.options, // daftar opsi MK
                    label = "Mata Kuliah", // label MK
                    onValueChangeEvent = {
                        chosenDropdown = it
                    }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                HorizontalDivider() // untuk menambahkan garis pemisah horizontal antar elemen
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Pilih Kelas Belajar", fontWeight = FontWeight.Bold)
                Text(
                    text = "Silakan pilih kelas dari mata kuliah yang anda inginkan",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly // agar layout menjadi simetris dan teratur
                ){
                    RuangKelas.listKelas.forEach { data ->
                        Row (verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = pilihanKelas == data,
                                onClick = { pilihanKelas = data }
                            )
                            Text(data)
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Klausul Persetujuan Mahasiswa", fontWeight = FontWeight.Bold)
                Row (verticalAlignment = Alignment.CenterVertically){
                    Checkbox(
                        checked = checked, // status centang pada checkbox
                        onCheckedChange = {checked = it},
                        enabled = chosenDropdown.isBlank() && pilihanKelas.isNotBlank()
                    // Tombol checkbox akan diaktifkan atau dinonaktifkan sesuai dengan kondisi yang ditentukan oleh nilai chosenDropdown dan pilihanKelas.
                    )
                    Text(
                        text = "Saya menyetujui setiap pernyataan yang ada tanpa ada paksaan dari pihak manapun.",
                        fontWeight = FontWeight.Light,
                        fontSize = 10.sp
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Button(onClick = {onBackButtonClicked}) {
                        Text(text = "Kembali") // ke halaman sebelumnya
                    }
                    Button(onClick = {onSubmitButtonClicked(listData)},
                        enabled = checked){
                        Text(text = "Lanjut") // ke halaman berikutnya
                    }
                }
            }
        }
    }
}