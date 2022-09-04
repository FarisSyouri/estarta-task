package com.estarta.task.presentation.details

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
class ItemDetailsViewModel @Inject constructor() : BaseViewModel() {



}