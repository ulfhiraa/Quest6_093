package com.example.pam_meet8.ui.viewmodel

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
        _krsState.update { stateMK -> stateMK.copy(namaMK = mkPilihan) }
    }
}