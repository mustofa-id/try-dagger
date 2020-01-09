package id.mustofa.atm.command

import id.mustofa.atm.command.base.Command
import id.mustofa.atm.command.base.Command.Result
import id.mustofa.atm.command.base.Outputter
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