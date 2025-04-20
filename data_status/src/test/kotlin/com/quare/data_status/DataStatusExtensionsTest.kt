package com.quare.data_status

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

internal class DataStatusExtensionsTest {

    @Test
    fun `toLoadedInformation returns null for Loading state`() {
        val loadingState: DataStatus<String> = DataStatus.Loading
        assertThat(loadingState.toLoadedInformation()).isNull()
    }

    @Test
    fun `toLoadedInformation returns Loaded state for Loaded state`() {
        val loadedState: DataStatus<String> = DataStatus.Loaded("test")
        val result = loadedState.toLoadedInformation()
        assertThat(result?.data).isEqualTo("test")
    }

    @Test
    fun `toLoadedStatus wraps value in Loaded state`() {
        val value = "test"
        val result = value.toLoadedStatus()
        assertThat(result.data).isEqualTo(value)
    }

    @Test
    fun `mapToStatus transforms Loaded value`() {
        data class User(val name: String)
        val userStatus: DataStatus<User> = DataStatus.Loaded(User("John"))
        
        val nameStatus = userStatus.mapToStatus { name }
        assertThat((nameStatus as DataStatus.Loaded).data).isEqualTo("John")
    }

    @Test
    fun `mapToStatus returns Loading for Loading state`() {
        val loadingState: DataStatus<String> = DataStatus.Loading
        val result = loadingState.mapToStatus { length }
        assertThat(result).isInstanceOf(DataStatus.Loading::class.java)
    }

    @Test
    fun `toLoadedData returns null for Loading state`() {
        val loadingState: DataStatus<String> = DataStatus.Loading
        assertThat(loadingState.toLoadedData()).isNull()
    }

    @Test
    fun `toLoadedData returns data for Loaded state`() {
        val loadedState: DataStatus<String> = DataStatus.Loaded("test")
        assertThat(loadedState.toLoadedData()).isEqualTo("test")
    }

    @Test
    fun `List toLoadedData returns only loaded values`() {
        val list = listOf(
            DataStatus.Loaded("1"),
            DataStatus.Loading,
            DataStatus.Loaded("2")
        )
        assertThat(list.toLoadedData()).containsExactly("1", "2")
    }

    @Test
    fun `List toLoadedStatus wraps all values`() {
        val list = listOf("1", "2", "3")
        val result = list.toLoadedStatus()
        assertThat(result).hasSize(3)
        assertThat(result.map { it.data }).containsExactly("1", "2", "3")
    }

    @Test
    fun `isLoading returns true for Loading state`() {
        val loadingState: DataStatus<String> = DataStatus.Loading
        assertThat(loadingState.isLoading()).isTrue()
    }

    @Test
    fun `isLoading returns false for Loaded state`() {
        val loadedState: DataStatus<String> = DataStatus.Loaded("test")
        assertThat(loadedState.isLoading()).isFalse()
    }

    @Test
    fun `getLoadingData returns Loading state`() {
        val result = getLoadingData()
        assertThat(result).isEqualTo(DataStatus.Loading)
    }
} 
