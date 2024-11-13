package br.com.github.jungabriel56.ecodicas.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TipViewModelFactory(private val application: Application) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TipsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TipsViewModel.TipsViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}