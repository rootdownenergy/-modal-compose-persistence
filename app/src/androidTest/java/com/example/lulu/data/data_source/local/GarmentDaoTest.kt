package com.example.lulu.data.data_source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.lulu.data.data_sources.local.AppDatabase
import com.example.lulu.data.data_sources.local.GarmentDao
import com.example.lulu.domain.model.Garment
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.lifecycle.asLiveData
import com.example.lulu.util.getOrAwaitValueTest


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class GarmentDaoTest {

    //rule
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    /*
    * ini db
    * ini dao
    * */
    private lateinit var database: AppDatabase
    private lateinit var dao: GarmentDao


    // config test
    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.getGarmentDao()
    }
    @Test
    fun insertGarnment() = runTest{
        val daoObj = Garment(garnmentId = 1, name = "HTW", description = "HTWHTWHTWHTW", timestamp = System.currentTimeMillis(), color = 2, ii = "cloud group")
        val daoObj2 = Garment(garnmentId = 2, name = "HTW2", description = "HTWHTW22221111HTWHTW2", timestamp = System.currentTimeMillis(), color = 2, ii = "1111 group")
        dao.insertGarment(daoObj)
        dao.insertGarment(daoObj2)
        val result = dao.getGarment().asLiveData().getOrAwaitValueTest()
        assertThat(result).contains(daoObj)
        assertThat(result).contains(daoObj2)
    }
    @Test
    fun deleteAGarment() = runTest {
        val daoObj = Garment(name = "HTW", description = "HTWHTWHTWHTW", timestamp = System.currentTimeMillis(), color = 2, ii = "cloud group")
        val daoObj2 = Garment(name = "HTW2", description = "HTWHTW22221111HTWHTW2", timestamp = System.currentTimeMillis(), color = 2, ii = "1111 group")
        dao.insertGarment(daoObj)
        dao.insertGarment(daoObj2)
        dao.deleteGarment(1)
        val result = dao.getGarment().asLiveData().getOrAwaitValueTest()
        assertThat(result).doesNotContain(daoObj)
    }
    @Test
    fun getGarmentById() = runTest {
        val daoObj = Garment(garnmentId = 1, name = "HTW", description = "HTWHTWHTWHTW", timestamp = System.currentTimeMillis(), color = 2, ii = "cloud group")
        val daoObj2 = Garment(garnmentId = 2, name = "HTW2", description = "HTWHTW22221111HTWHTW2", timestamp = System.currentTimeMillis(), color = 2, ii = "1111 group")
        dao.insertGarment(daoObj)
        dao.insertGarment(daoObj2)
        val result = dao.getGarmentById(daoObj.garnmentId)
        assertThat(result?.garnmentId).isEqualTo(daoObj.garnmentId)
    }
    @After
    fun teardown(){
        database.close()
    }

}