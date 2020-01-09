package id.mustofa.atm.model

import id.mustofa.atm.model.base.Command
import id.mustofa.atm.model.base.Command.Result
import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.util.Database
import id.mustofa.atm.util.inputCompleted
import id.mustofa.atm.util.invalid
import javax.inject.Inject

class LogoutCommand @Inject constructor (
    private val account: Database.Account,
    private val outputter: Outputter
) : Command {

    override fun handleInput(input: List<String>): Result {
        if (input.isNotEmpty()) {
            return Result.invalid
        }

        outputter.output("Logged out: ${account.username}")
        return Result.inputCompleted
    }
}