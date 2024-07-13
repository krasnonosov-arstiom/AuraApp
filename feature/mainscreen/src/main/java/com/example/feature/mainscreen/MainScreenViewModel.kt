package com.example.feature.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.api.GetSavedNumbersStreamUseCase
import com.example.domain.usecases.api.IncrementValueUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val incrementValueUseCase: IncrementValueUseCase,
    getSavedNumbersStreamUseCase: GetSavedNumbersStreamUseCase,
) : ViewModel() {

    private val currentNumberFlow = MutableStateFlow<State>(State.Undefined)

    init {
        getSavedNumbersStreamUseCase.invoke()
            .onEach { number -> currentNumberFlow.update { State.Content(number.toString()) } }
            .catch { currentNumberFlow.update { State.Undefined } }
            .launchIn(viewModelScope)
    }

    fun getCurrentNumberStream(): Flow<State> = currentNumberFlow

    fun increaseNumber() {
        viewModelScope.launch {
            incrementValueUseCase.invoke()
        }
    }

    sealed interface State {

        data object Undefined: State
        data class Content(val number: String): State
    }
}