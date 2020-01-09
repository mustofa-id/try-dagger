package id.mustofa.atm.router

import id.mustofa.atm.model.base.Command
import id.mustofa.atm.model.base.Command.Result
import id.mustofa.atm.model.base.Command.Status
import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.util.invalid
import javax.inject.Inject

/**
 * CommandRouter can collect multiple Commands and route input strings
 * to them based on the first word in the input
 *
 * The @Inject annotation indicates to Dagger that when we ask for a
 * CommandRouter, Dagger should call new CommandRouter().
 */
class CommandRouter @Inject constructor(
    private val commands: Map<String, @JvmSuppressWildcards Command>,
    private val outputter: Outputter
) {

    fun route(input: String): Result {
        val inputs = split(input)
        if (inputs.isEmpty()) {
            return invalidCommand(input)
        }

        val key = inputs.first()
        val command = commands[key] ?: return invalidCommand(input)

        val result = command.handleInput(inputs.subList(1, inputs.size))
        if (result.status == Status.INVALID) {
            outputter.output("$key: Invalid arguments")
        }
        return result
    }

    private fun invalidCommand(input: String): Result {
        outputter.output("Couldn't understand $input. Please try again.")
        return Result.invalid
    }

    private fun split(input: String): List<String> {
        return input.split(Regex("\\s+")).dropLastWhile { it.isBlank() }
    }
}