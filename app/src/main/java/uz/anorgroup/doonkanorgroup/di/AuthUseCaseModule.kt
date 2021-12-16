package uz.anorgroup.doonkanorgroup.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.anorgroup.doonkanorgroup.domain.usecase.LoginScreenUseCase
import uz.anorgroup.doonkanorgroup.domain.usecase.RegisterScreenUseCase
import uz.anorgroup.doonkanorgroup.domain.usecase.VerifyScreenUseCase
import uz.anorgroup.doonkanorgroup.domain.usecase.usecaseimpl.LoginScreenUseCaseImpl
import uz.anorgroup.doonkanorgroup.domain.usecase.usecaseimpl.RegisterScreenUseCaseImpl
import uz.anorgroup.doonkanorgroup.domain.usecase.usecaseimpl.VerifyScreenUseCaseImpl


@Module
@InstallIn(ViewModelComponent::class)
interface AuthUseCaseModule {

    @Binds
    fun getRegisterUseCase(impl: RegisterScreenUseCaseImpl): RegisterScreenUseCase

    @Binds
    fun getVeryfyUseCase(impl: VerifyScreenUseCaseImpl): VerifyScreenUseCase

    @Binds
    fun getLoginUseCase(impl: LoginScreenUseCaseImpl): LoginScreenUseCase

}