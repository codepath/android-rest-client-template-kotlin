package com.codepath.apps.restclienttemplate.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SampleModelDao {

    // @Query annotation requires knowing SQL syntax
    // See http://www.sqltutorial.org/
    @Query("SELECT * FROM SampleModel WHERE id = :id")
    fun byId(id: Long): SampleModel?

    @Query("SELECT * FROM SampleModel ORDER BY ID DESC LIMIT 300")
    fun recentItems(): List<SampleModel?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertModel(vararg sampleModels: SampleModel?)
}