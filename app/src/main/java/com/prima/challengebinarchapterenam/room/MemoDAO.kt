package com.prima.challengebinarchapterenam.room

import androidx.room.*
import com.prima.challengebinarchapterenam.room.Memo

@Dao
interface MemoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(memo: Memo): Long

    @Query("SELECT * FROM Memo")
    fun read(): List<Memo>

    @Update
    fun update(memo: Memo): Int

    @Delete
    fun delete(memo: Memo): Int
}