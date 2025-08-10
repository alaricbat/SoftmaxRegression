package com.advance.jobfix.presentation.ui.page.home

import com.advance.jobfix.presentation.ui.common.ErrorMessage

sealed interface HomeUiState {

    val isLoading: Boolean
    val errorMessage: List<ErrorMessage>

}