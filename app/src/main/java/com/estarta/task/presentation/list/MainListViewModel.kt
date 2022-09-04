package com.estarta.task.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.estarta.task.domain.model.Item
import com.estarta.task.domain.usecase.BaseUseCase
import com.estarta.task.domain.usecase.GetDynamodbUseCase
import com.estarta.task.presentation.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject constructor(
    private val getDynamodbUseCase: GetDynamodbUseCase,
) : BaseViewModel() {


     val itemsList = MutableLiveData<List<Item>>()

    fun getItems() {
        showProgress()
        viewModelScope.launch(getExceptionHandler()) {
            itemsList.value =
                getDynamodbUseCase.execute(BaseUseCase.None())
            hideProgress()
        }
    }



    companion object {
//        val NULL_API_EXCEPTION = ApiException(Status(-1))
//        const val GOOGLE_SIGN_IN_CANCELLED: Int = 12500
    }
}