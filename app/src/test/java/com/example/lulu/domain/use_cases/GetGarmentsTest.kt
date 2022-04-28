package com.example.lulu.domain.use_cases

import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.repo.FakeGarmentsRepo
import com.example.lulu.domain.util.GarmentOrder
import com.example.lulu.domain.util.OrderType
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetGarmentsTest {

    private lateinit var getGarments: GetGarments
    private lateinit var fakeRepo: FakeGarmentsRepo

    // create a fakerepo
    // initiaize some objs
    @Before
    fun setUp(){
        fakeRepo = FakeGarmentsRepo()
        getGarments = GetGarments(fakeRepo)
        var count = 0
        val garmentsToInsert = mutableListOf<Garment>()
        ('a'..'z').forEachIndexed { index, c ->
            count = index
            garmentsToInsert.add(
                Garment(
                    name = "HTW",
                    description = "HTWHTWHTWHTW",
                    timestamp = 1651183010757+count,
                    color = 2,
                    ii = "cloud group"
                )
            )
            count++
        }
        garmentsToInsert.shuffle()
        runBlocking {
            garmentsToInsert.forEach { fakeRepo.insertGarment(it) }
        }

    }

    @Test
    fun `OrderGarmentsByNameAscendingCorrectOrder`() = runBlocking {
        val garments = getGarments(GarmentOrder.Name(OrderType.Ascending)).first()
        for(i in 0..garments.size - 2){
            assertThat(garments[i].name).isLessThan(garments[i+1].name)
        }
    }

    @Test
    fun `OrderGarmentsByNameDescendingCorrectOrder`() = runBlocking {
        val garments = getGarments(GarmentOrder.Name(OrderType.Descending)).first()
        for(i in 0..garments.size - 2){
            assertThat(garments[i].name).isGreaterThan(garments[i+1].name)
        }
    }

    @Test
    fun `OrderGarmentsByDateAscendingCorrectOrder`() = runBlocking {
        val garments = getGarments(GarmentOrder.Date(OrderType.Ascending)).first()
        for(i in 0..garments.size - 2){
            assertThat(garments[i].timestamp).isLessThan(garments[i+1].timestamp)
        }
    }

    @Test
    fun `OrderGarmentsByDateDescendingCorrectOrder`() = runBlocking {
        val garments = getGarments(GarmentOrder.Date(OrderType.Descending)).first()
        for(i in 0..garments.size - 2){
            assertThat(garments[i].timestamp).isGreaterThan(garments[i+1].timestamp)
        }
    }

    @Test
    fun `OrderGarmentsByColorAscendingCorrectOrder`() = runBlocking {
        val garments = getGarments(GarmentOrder.Color(OrderType.Ascending)).first()
        for(i in 0..garments.size - 2){
            assertThat(garments[i].color).isLessThan(garments[i+1].color)
        }
    }

    @Test
    fun `OrderGarmentsByColorDescendingCorrectOrder`() = runBlocking {
        val garments = getGarments(GarmentOrder.Color(OrderType.Descending)).first()
        for(i in 0..garments.size - 2){
            assertThat(garments[i].color).isGreaterThan(garments[i+1].color)
        }
    }
}