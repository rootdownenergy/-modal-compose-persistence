package com.example.lulu.domain.use_cases

import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.repo.FakeGarmentsRepo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AddGarmentTest {

    private lateinit var addGarment: AddGarment

    // we need a private val reposiitory: NoteRepository
    private lateinit var fakeRepo: FakeGarmentsRepo

    @Before
    fun setup(){
        fakeRepo = FakeGarmentsRepo()
    }

    //test that the title is not blank
    @ExperimentalCoroutinesApi
    @Test
    fun `IsGarmentNameBlank`() = runTest {
        val data = Garment(name = "HTW", description = "", timestamp = System.currentTimeMillis(), color = 2)
        assertThat(data.name).isNotEmpty()
    }
    @ExperimentalCoroutinesApi
    @Test
    fun `IsGarmentDescriptionBlank`() = runTest {
        val data = Garment(name = "", description = "HTWHTWHTWHTW", timestamp = System.currentTimeMillis(), color = 2)
        assertThat(data.description).isNotEmpty()
    }
    @ExperimentalCoroutinesApi
    @Test
    fun `IfGarmentNameAndDescriptionNotBlankInsert`() = runTest {
        val data = Garment(garnmentId = 1,name = "HTW", description = "HTWHTWHTWHTW", timestamp = System.currentTimeMillis(), color = 2)
        if(data.description.isNotEmpty() && data.name.isNotEmpty())
        {
            fakeRepo.insertGarment(data)

        }
        assertThat(data).isIn(fakeRepo.modLs)
    }
}