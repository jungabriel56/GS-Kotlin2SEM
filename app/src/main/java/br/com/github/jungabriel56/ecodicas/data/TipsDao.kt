package br.com.github.jungabriel56.ecodicas.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.github.jungabriel56.ecodicas.model.Tip

@Dao
interface TipsDao {

    @Query("SELECT * FROM Tip")
    fun getAll(): LiveData<List<Tip>>

    @Insert
    fun insert(tip: Tip)

    @Delete
    fun delete(tip: Tip)
}