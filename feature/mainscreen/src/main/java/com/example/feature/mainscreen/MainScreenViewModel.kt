package com.example.feature.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.api.GetSavedNumbersStreamUseCase
import com.example.feature.mainscreen.mappers.toMainScreenViewModelState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    getSavedNumbersStreamUseCase: GetSavedNumbersStreamUseCase,
) : ViewModel() {

    private val currentNumberFlow = MutableStateFlow<State>(State.Undefined)
    private val timeFormatter = SimpleDateFormat("DD/MM/YYYY HH:MM:SS", Locale.getDefault())

    init {
        getSavedNumbersStreamUseCase.invoke()
            .onEach { bootInfoModel ->
                currentNumberFlow.update { bootInfoModel.toMainScreenViewModelState(timeFormatter) }
            }
            .catch { currentNumberFlow.update { State.Undefined } }
            .launchIn(viewModelScope)
    }

    fun getCurrentNumberStream(): Flow<State> = currentNumberFlow

    sealed interface State {

        data object Undefined : State
        data class Content(val textValue: String) : State
    }
}