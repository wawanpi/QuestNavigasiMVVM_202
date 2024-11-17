package com.example.pertemuan7.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pertemuan7.Model.Mahasiswa

@Composable
fun TampilMahasiswaView(
    mhs: Mahasiswa,
    navController: NavHostController

){
    Column (  modifier = Modifier.fillMaxSize()){
        Text(text = "Data Mahasiswa" ,
            fontWeight = FontWeight.Bold ,
            fontSize = 28.sp,
            modifier = Modifier
                .fillMaxWidth() // Mengisi seluruh lebar layar)
                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding (20.dp))

        TampilData(
            judul = "Nama",
            isinya = mhs.nama
        )

        TampilData(
            judul = "Nim",
            isinya = mhs.nim
        )

        TampilData(
            judul = "Jenis Kelamin",
            isinya = mhs.gender
        )

        TampilData(
            judul = "Email",
            isinya = mhs.email
        )

        TampilData(
            judul = "Nomor handphone",
            isinya = mhs.noHp
        )

        TampilData(
            judul = "Alamat",
            isinya = mhs.alamat
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Kembali")
            }
        }
    }
}
@Composable
fun TampilData(
    judul: String ,
    isinya: String,
){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul,modifier = Modifier.weight(0.8f))
        Text(" : ", modifier = Modifier.weight(0.8f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}


