package com.example.feature.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.core.AppComponentProvider
import com.example.core.base.BaseFragment
import com.example.core.base.ViewModelFactory
import com.example.feature.mainscreen.databinding.FragmentMainScreenBinding
import com.example.feature.mainscreen.di.MainScreenComponent
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.reflect.KClass

class MainScreenFragment : BaseFragment<FragmentMainScreenBinding, MainScreenViewModel>() {

    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override val viewModelClass: KClass<out ViewModel> = MainScreenViewModel::class

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainScreenBinding =
        FragmentMainScreenBinding.inflate(inflater, container, false)

    override fun inject(appComponentProvider: AppComponentProvider) {
        MainScreenComponent.create(appComponentProvider).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.increaseButton.setOnClickListener { viewModel.increaseNumber() }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getCurrentNumberStream().collect { state ->
                when (state) {
                    is MainScreenViewModel.State.Content -> binding.numberTextView.text = state.number
                    is MainScreenViewModel.State.Undefined -> binding.numberTextView.text = "Something went wrong"
                }

            }
        }
    }

    companion object {

        fun newInstance() = MainScreenFragment()
    }
}