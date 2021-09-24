package com.javajj.lushTechTest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.javajj.lushTechTest.repository.RocketRepo
import com.javajj.lushTechTest.util.LoadingState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RocketViewModel(
    private val rocketRepo: RocketRepo
) : ViewModel()
{
    /**
     * Listen for updates from the RocketRepo class
     */
    val rocketData = rocketRepo.rocketData

    /**
     * Listen for changes in the API call loading state
     */
    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
    get() = _loadingState

    /**
     * Create a coroutine scoped to this ViewModel class
     */
    private val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    /**
     * Request updated rocket data from the repo
     */
    init {
        getRocketData()
    }

    /**
     * Request the RocketRepo to update data
     */
    private fun getRocketData(){
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                rocketRepo.getMissions()
                _loadingState.value = LoadingState.LOADED
            }
            catch (exception: HttpException){
                _loadingState.value = LoadingState.logError(exception.message())
            }
        }
    }
}
