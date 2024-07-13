package com.example.domain.usecases.impl

import com.example.domain.repositories.NumberRepository
import com.example.domain.usecases.api.IncrementValueUseCase
import javax.inject.Inject

internal class IncrementValueUseCaseImpl @Inject constructor(
    private val numberRepository: NumberRepository,
): IncrementValueUseCase {

    override suspend fun invoke() {
        numberRepository.incrementValue()
    }
}