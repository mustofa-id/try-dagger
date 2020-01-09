package id.mustofa.atm.model

import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.router.Database
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val account: Database.Account,
    private val outputter: Outputter
) : BigDecimalCommand(outputter) {

    override fun key() = "deposit"

    override fun handleAmount(amount: BigDecimal) {
        account.deposit(amount)
        outputter.output("${account.username} now has: ${account.balance}")
    }
}