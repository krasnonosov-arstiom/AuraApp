package com.example.domain.usecases.impl

import com.example.domain.repositories.NumberRepository
import com.example.domain.usecases.api.WriteNumberValueUseCase
import javax.inject.Inject

internal class WriteNumberValueUseCaseImpl @Inject constructor(
    private val numberRepository: NumberRepository,
): WriteNumberValueUseCase {

    override suspend fun invoke(value: Int) {
        numberRepository.writeValue(value)
    }
}