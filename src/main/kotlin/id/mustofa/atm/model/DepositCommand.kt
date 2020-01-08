package id.mustofa.atm.model

import id.mustofa.atm.model.base.Command
import id.mustofa.atm.model.base.Command.Status
import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.router.Database
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(
    private val database: Database,
    private val outputter: Outputter
) : Command {

    override fun key() = "deposit"

    override fun handleInput(input: List<String>): Status {
        if (input.size != 2) {
            return Status.INVALID
        }

        val account = database.getAccount(input[0])
        account.deposit(BigDecimal(input[1]))
        outputter.output("${account.username} now has: ${account.balance}")
        return Status.HANDLED
    }
}