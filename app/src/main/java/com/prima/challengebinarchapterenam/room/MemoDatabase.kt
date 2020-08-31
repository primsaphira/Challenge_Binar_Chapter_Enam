package com.prima.challengebinarchapterenam.room

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(Memo::class), version = 1)
abstract class MemoDatabase : RoomDatabase() {

    abstract fun memoDAO() : MemoDAO

    companion object {
        private var INSTANCE: MemoDatabase? = null

        fun getInstance(context: Context): MemoDatabase? {
            if (INSTANCE == null) {
                synchronized(MemoDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MemoDatabase::class.java, "memo.db")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}