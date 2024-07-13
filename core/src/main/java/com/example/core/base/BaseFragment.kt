package com.example.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.core.AppComponentHolder
import com.example.core.AppComponentProvider
import kotlin.reflect.KClass

abstract class BaseFragment<B : ViewBinding, VM : ViewModel> : Fragment() {

    abstract val viewModelFactory: ViewModelFactory

    abstract val viewModelClass: KClass<out ViewModel>

    private var _binding: B? = null
    val binding: B
        get() = checkNotNull(_binding) {
            "Binding hasn't been initialized"
        }

    private var _viewModel: VM? = null
    val viewModel: VM
        get() = checkNotNull(_viewModel) {
            "ViewModel hasn't been initialized"
        }

    private var isProgressLayout = false

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun inject(appComponentProvider: AppComponentProvider)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.applicationContext?.let {
            if (it is AppComponentHolder) {
                inject(it.appComponentProvider)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewModel = viewModelFactory.create(viewModelClass)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = initBinding(inflater, container)
        return binding.root
    }

    override fun onDetach() {
        _viewModel = null
        _binding = null
        super.onDetach()
    }
}