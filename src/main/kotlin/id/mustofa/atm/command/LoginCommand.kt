package id.mustofa.atm.command

import id.mustofa.atm.command.base.Command.Result
import id.mustofa.atm.command.base.Outputter
import id.mustofa.atm.command.base.SingleArgCommand
import id.mustofa.atm.router.UserCommandsRouter
import id.mustofa.atm.util.Database
import id.mustofa.atm.util.enterNestedCommandSet
import id.mustofa.atm.util.handled
import java.util.*
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val database: Database,
    private val outputter: Outputter,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory,
    private val account: Optional<Database.Account>
) : SingleArgCommand() {

    override fun handleArg(arg: String): Result {
        if (account.isPresent) {
            outputter.output("Can't login! \"${account.get().username}\" already logged in")
            return Result.handled
        }
        val account = database.getAccount(arg)
        outputter.output("${account.username} is logged in with balance: ${account.balance}.")
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router())
    }
}