package com.example.domain.di

import com.example.domain.repositories.NumberRepository

interface DataProvider {

    fun getNumberRepository(): NumberRepository
}