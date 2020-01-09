package id.mustofa.atm.util

import id.mustofa.atm.module.AmountsModule.MaximumWithdrawal
import id.mustofa.atm.util.WithdrawLimiter.PerSession
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Scope

@PerSession
class WithdrawLimiter @Inject constructor(
    @MaximumWithdrawal val maximumWithdrawal: BigDecimal
) {

    var remainingWithdrawalLimit = maximumWithdrawal
        private set

    fun recordDeposit(amount: BigDecimal) {
        remainingWithdrawalLimit += amount
    }

    fun recordWithdrawal(amount: BigDecimal) {
        remainingWithdrawalLimit -= amount
    }

    @Scope
    @MustBeDocumented
    @Retention(AnnotationRetention.RUNTIME)
    annotation class PerSession
}