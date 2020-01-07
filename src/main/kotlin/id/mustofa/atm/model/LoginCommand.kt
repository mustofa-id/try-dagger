package id.mustofa.atm.model

import id.mustofa.atm.model.base.Command.Status
import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.model.base.SingleArgCommand
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val outputter: Outputter
) : SingleArgCommand() {

    override fun key() = "login"

    override fun handleArg(arg: String): Status {
        outputter.output("$arg is logged in.")
        return Status.HANDLED
    }
}