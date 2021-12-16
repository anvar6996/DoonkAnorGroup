package uz.anorgroup.doonkanorgroup.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.VerifyRequest
import uz.anorgroup.doonkanorgroup.data.responce.VerifyResponse


interface VerifyScreenUseCase {
    fun sendSmsVeryfy(request: VerifyRequest): Flow<Result<VerifyResponse>>
}