package com.example.pam_meet8.ui.viewmodel

import androidx.compose.material3.surfaceColorAtElevation
import androidx.lifecycle.ViewModel
import com.example.pam_meet8.model.RencanaStudy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel : ViewModel(){ // class turunan dari View Model
    private val _krsState = MutableStateFlow(RencanaStudy())
    val krsStateUi: StateFlow<RencanaStudy> = _krsState.asStateFlow() // data bersifat Read-Only

    fun setMataKuliah(mkPilihan: String){
        _krsState.update { stateMK -> stateMK.copy(mataKuliah = mkPilihan) }
    // update untuk mengubah nilai MK yang ada di _krsState
    // _krsState.update memastikan bahwa perubahan nilai namaMK disalurkan ke _krsState
    // copy untuk membuat salinan dari objek RencanaStudy dan mengganti nilai namaMK dengan mkPilihan yang diberikan
    }
    // fungsi setMataKuliah untuk memperbarui nama MK dalam RencanaStudy dengan nilai yang diberikan mkPilihan

    fun setKelas(kelasPIlihan: String){
        _krsState.update { stateKelas -> stateKelas.copy(kelas = kelasPIlihan) }
    } // fungsi untuk memperbarui pilihan kelas

    fun saveDataKRS(ls: MutableList<String>){
        _krsState.update { status -> status.copy(
            mataKuliah = ls[0],
            kelas = ls[1]
        )
        }
    } // fungsi untuk menyimpan data MK dan Kelas pada rencana study
}