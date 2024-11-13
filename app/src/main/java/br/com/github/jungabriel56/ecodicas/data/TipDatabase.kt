package br.com.github.jungabriel56.ecodicas.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.github.jungabriel56.ecodicas.model.Tip

@Database(entities = [Tip::class], version = 1)
abstract class TipDatabase : RoomDatabase() {


    abstract fun tipsDao(): TipsDao
}