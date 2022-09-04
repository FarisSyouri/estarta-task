package com.estarta.task.presentation.utils.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.estarta.task.R
import com.estarta.task.data.network.module.Failure
import com.estarta.task.presentation.adapter.ItemsListAdapter
import com.estarta.task.presentation.utils.LoadingProgressDialog


abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    protected abstract val layoutResId: Int
    protected open val dataBindingEnabled: Boolean = true
    protected var viewDataBinding: ViewDataBinding? = null
    private var loadingProgressBar: LoadingProgressDialog? = null
    abstract val mViewModel: VM


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View?
        if (dataBindingEnabled) {
            viewDataBinding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
            view = viewDataBinding?.root
        } else {
            view = inflater.inflate(layoutResId, container, false)
        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleGeneralObservers()
    }

    private fun handleGeneralObservers() {
        mViewModel.progressLiveData?.observe(viewLifecycleOwner) {
            it?.let { handleLoading(it) }
        }
        mViewModel.failureLiveData?.observe(viewLifecycleOwner) {
            it?.let { showFailure(it) }
        }
        mViewModel.toastRes.observe(viewLifecycleOwner) {
            it?.let {
                showToast(getString(it))
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    protected inline fun <T : ViewDataBinding> bind(binding: T.() -> Unit) {
        binding(viewDataBinding as T)
        viewDataBinding?.lifecycleOwner = viewLifecycleOwner
        viewDataBinding?.executePendingBindings()
    }

    protected fun handleLoading(loadingState: Boolean) {
        if (loadingState) {
            showLoading()
        } else {
            hideLoading()
        }
    }

    protected fun showLoading() {
        if (loadingProgressBar == null) {
            loadingProgressBar = context?.let { LoadingProgressDialog(it) }
        }

        if (loadingProgressBar?.isShowing == false) {
            loadingProgressBar?.show()
        }
    }

    protected fun hideLoading() {
        loadingProgressBar?.cancel()
        loadingProgressBar?.hide()
    }

    protected fun showFailure(failure: Failure) {
        Log.d("showFailure: ", failure.message ?: "")
        when (failure) {
            is Failure.NetworkConnection -> showNetworkConnection()
            is Failure.NetworkError -> showNetworkError()
            is Failure.ServerError -> showServerError(failure.message)
            is Failure.UnknownError -> showUnknownError()
        }
    }

    protected fun showNetworkConnection() {
        showToast(getString(R.string.no_internet_connection))
    }

    protected fun showNetworkError() {
        showToast(getString(R.string.network_error))
    }

    protected fun showServerError(message: String) {
        showToast(message)
    }

    protected fun showUnknownError() {
        showToast(getString(R.string.network_error))
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun navigateToFragment(directions: NavDirections, route: Int? = null) {
        findNavController().currentDestination?.getAction(directions.actionId)
            ?.run { findNavController().navigate(directions, getNavOptions(route)) }
    }


    private fun getNavOptions(route: Int?): NavOptions {
        val navBuilder = NavOptions.Builder()

        if (route != null) {
            navBuilder.setPopUpTo(route, false)
        }
        return navBuilder.build()
    }

    override fun onDestroyView() {
        loadingProgressBar?.cancel()
        loadingProgressBar = null
        viewDataBinding = null
        super.onDestroyView()
    }

}