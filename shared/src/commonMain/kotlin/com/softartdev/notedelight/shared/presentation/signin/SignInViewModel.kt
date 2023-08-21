package com.softartdev.notedelight.shared.presentation.signin

import com.softartdev.notedelight.shared.base.BaseViewModel
import com.softartdev.notedelight.shared.data.CryptUseCase


class SignInViewModel (
        private val cryptUseCase: CryptUseCase
) : BaseViewModel<SignInResult>() {

    override var initResult: SignInResult? = SignInResult.ShowSignInForm
    override val loadingResult: SignInResult = SignInResult.ShowProgress

    fun signIn(pass: CharSequence) = launch {
        if (pass.isNotEmpty()) {
            when (cryptUseCase.checkPassword(pass)) {
                true -> SignInResult.NavMain
                false -> SignInResult.ShowIncorrectPassError
            }
        } else SignInResult.ShowEmptyPassError
    }

    override fun errorResult(throwable: Throwable): SignInResult = SignInResult.ShowError(throwable)
}
