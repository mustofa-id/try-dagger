package id.mustofa.atm.model

import id.mustofa.atm.model.base.Command.Result
import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.model.base.SingleArgCommand
import id.mustofa.atm.router.Database
import id.mustofa.atm.router.UserCommandsRouter
import id.mustofa.atm.util.enterNestedCommandSet
import javax.inject.Inject

class LoginCommand @Inject constructor(
    private val database: Database,
    private val outputter: Outputter,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory
) : SingleArgCommand() {

    override fun key() = "login"

    override fun handleArg(arg: String): Result {
        val account = database.getAccount(arg)
        outputter.output("${account.username} is logged in with balance: ${account.balance}.")
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router())
    }
}