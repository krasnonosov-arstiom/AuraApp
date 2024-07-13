package com.example.domain.usecases.impl

import com.example.domain.models.BootInfoModel
import com.example.domain.repositories.NumberRepository
import com.example.domain.usecases.api.GetSavedNumbersStreamUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetSavedNumbersStreamUseCaseImpl @Inject constructor(
    private val numberRepository: NumberRepository,
): GetSavedNumbersStreamUseCase {

    override fun invoke(): Flow<BootInfoModel> = numberRepository.getSavedNumbersStream()
}