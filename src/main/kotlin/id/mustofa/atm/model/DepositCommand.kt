package id.mustofa.atm.model

import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.util.Database
import id.mustofa.atm.util.WithdrawLimiter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val account: Database.Account,
    private val withdrawLimiter: WithdrawLimiter,
    private val outputter: Outputter
) : BigDecimalCommand(outputter) {

    override fun handleAmount(amount: BigDecimal) {
        account.deposit(amount)
        withdrawLimiter.recordDeposit(amount)
        outputter.output("${account.username} now has: ${account.balance}")
    }
}