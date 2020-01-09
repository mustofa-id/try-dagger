package id.mustofa.atm.router

import id.mustofa.atm.model.base.Command.Status
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandProcessor @Inject constructor(
    firstCommandRouter: CommandRouter
) {

    private val commandRouterStack: Deque<CommandRouter> = ArrayDeque()

    init {
        commandRouterStack.push(firstCommandRouter)
    }

    fun process(input: String): Status {
        val result = commandRouterStack.peek().route(input)
        if (result.status == Status.INPUT_COMPLETED) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty())
                Status.INPUT_COMPLETED else Status.HANDLED
        }

        result.nestedCommandRouter.ifPresent(commandRouterStack::push)
        return result.status
    }
}