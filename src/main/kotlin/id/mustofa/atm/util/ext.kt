package id.mustofa.atm.util

import id.mustofa.atm.model.base.Command
import id.mustofa.atm.model.base.Command.Status
import id.mustofa.atm.router.CommandRouter
import java.util.*

val Command.Result.Companion.invalid
    get() = Command.Result(Status.INVALID, Optional.empty())

val Command.Result.Companion.handled
    get() = Command.Result(Status.HANDLED, Optional.empty())

val Command.Result.Companion.inputCompleted
    get() = Command.Result(Status.INPUT_COMPLETED, Optional.empty())

fun Command.Result.Companion.enterNestedCommandSet(nestedCommandRouter: CommandRouter): Command.Result {
    return Command.Result(Status.HANDLED, Optional.of(nestedCommandRouter))
}