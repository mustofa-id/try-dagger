package id.mustofa.atm.model

import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.module.AmountsModule.MaximumWithdrawal
import id.mustofa.atm.module.AmountsModule.MinimumBalance
import id.mustofa.atm.util.Database
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(
    private val account: Database.Account,
    private val outputter: Outputter,
    @MinimumBalance private val minimumBalance: BigDecimal,
    @MaximumWithdrawal private val maximumWithdrawal: BigDecimal
) : BigDecimalCommand(outputter) {

    override fun handleAmount(amount: BigDecimal) {
        if (amount > maximumWithdrawal) {
            outputter.output("Can't withdraw! Maximum withdraw amount reached")
            return
        }

        val newBalance = account.balance.subtract(amount)
        if (newBalance < minimumBalance) {
            outputter.output("Can't withdraw! Minimum balance reached!")
            return
        } else {
            account.withdraw(amount)
            outputter.output("Your new balance is ${account.balance}")
        }

    }
}