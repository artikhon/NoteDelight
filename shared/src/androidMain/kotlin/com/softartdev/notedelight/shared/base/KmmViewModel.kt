package com.softartdev.notedelight.shared.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.viewModelScope as extViewModelScope

actual open class KmmViewModel actual constructor() : ViewModel() {

    actual val viewModelScope: CoroutineScope
        get() = extViewModelScope

    public actual override fun onCleared() = super.onCleared()
}