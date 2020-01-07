package id.mustofa.atm.model

import id.mustofa.atm.model.base.Command.Status
import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.model.base.SingleArgCommand
import id.mustofa.atm.router.Database
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val database: Database,
    private val outputter: Outputter
) : SingleArgCommand() {

    override fun key() = "login"

    override fun handleArg(arg: String): Status {
        val account = database.getAccount(arg)
        outputter.output("${account.username} is logged in with balance: ${account.balance}.")
        return Status.HANDLED
    }
}