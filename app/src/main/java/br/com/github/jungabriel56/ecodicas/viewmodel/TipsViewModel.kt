package br.com.github.jungabriel56.ecodicas.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.github.jungabriel56.ecodicas.model.Tip
import androidx.room.Room
import br.com.github.jungabriel56.ecodicas.data.TipDatabase
import br.com.github.jungabriel56.ecodicas.data.TipsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TipsViewModel {

    class TipsViewModel(application: Application) : AndroidViewModel(application) {

        private val itemDao: TipsDao
        val itemsLiveData: LiveData<List<Tip>>

        init {
            val database = Room.databaseBuilder(
                getApplication(),
                TipDatabase::class.java,
                "items_database"
            ).build()

            itemDao = database.tipsDao()

            itemsLiveData = itemDao.getAll()
        }


        fun addTip(tip: String) {

            viewModelScope.launch(Dispatchers.IO) {
               // val newTip = Tip(title = tip)
               // itemDao.insert(newTip)
            }
        }

        fun removeTip(tip: Tip) {

            viewModelScope.launch(Dispatchers.IO) {
                itemDao.delete(tip)

            }
        }}}