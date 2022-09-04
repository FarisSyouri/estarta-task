package com.estarta.task.presentation.utils.base

import androidx.lifecycle.ViewModel
import com.estarta.task.data.network.module.Failure
import com.estarta.task.presentation.utils.SingleLiveData
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel :
    ViewModel() {


    var progressLiveData: SingleLiveData<Boolean>? = SingleLiveData()
        private set

    var failureLiveData: SingleLiveData<Failure>? = SingleLiveData()
        private set

    var toastRes: SingleLiveData<Int> = SingleLiveData()
        private set

    fun showProgress() {
        progressLiveData?.value = true
    }

    fun hideProgress() {
        progressLiveData?.value = false
    }

    fun showFailure(failure: Failure) {
        failureLiveData?.value = failure
    }

    fun showResourceToast(res: Int) {
        toastRes.value = res
    }

    fun getExceptionHandler(): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, throwable ->
            hideProgress()
            if (throwable is Failure)
                showFailure(throwable)
            else showFailure(Failure.NetworkError)
        }
    }
}