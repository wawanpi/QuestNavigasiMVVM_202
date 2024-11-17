package com.example.pertemuan7.ui.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



//bisa menyusun UI dan dipanggil oleh fungsi lain untuk membentuk tampilan.
@Composable
fun FormulirView(modifier: Modifier = Modifier,
                 pilihanJk: List<String>,
                 onClikButton: (MutableList<String>) -> Unit

){
    // var (variable dan bisa di ubah)
    //menyimpan data yang di inputkan
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }
    var listData : MutableList<String> = mutableListOf(nama,jenisK, alamat)

    Column(modifier = Modifier
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Biodata" ,
            fontWeight = FontWeight.Bold ,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding (20.dp))
        TextField(
            value = nama, // isi dari textfield ini masuk ke variable nama
            onValueChange = {nama = it}, //Callback untuk memperbarui nilai nama setiap kali pengguna mengetik.
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Nama")
            },
            placeholder = {
                Text("Masukan Nama Anda!")
            }
        )
        Row {
            pilihanJk.forEach{selectedJK ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Email")
            },
            placeholder = {
                Text("Masukan Email Anda!")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = noHp,
            onValueChange = {noHp = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Nomor HP")
            },
            placeholder = {
                Text("Masukan Nomor HP Anda!")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Alamat")
            },
            placeholder = {
                Text("Masukan Alamat Anda!")
            }
        )
        Button(onClick = {
            onClikButton(listData)
        } , modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Simpan")

        }

        }
    }

