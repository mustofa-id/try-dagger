package id.mustofa.atm.router

import id.mustofa.atm.command.Command
import id.mustofa.atm.command.Command.Status
import id.mustofa.atm.command.HelloWorldCommand
import javax.inject.Inject

/**
 * CommandRouter can collect multiple Commands and route input strings
 * to them based on the first word in the input
 *
 * The @Inject annotation indicates to Dagger that when we ask for a
 * CommandRouter, Dagger should call new CommandRouter().
 */
class CommandRouter @Inject constructor(helloWorldCommand: HelloWorldCommand) {

    private val commands = mutableMapOf<String, Command>()

    init {
        commands[helloWorldCommand.key()] = helloWorldCommand
    }

    fun route(input: String): Status {
        val inputs = split(input)
        if (inputs.isEmpty()) {
            return invalidCommand(input)
        }

        val key = inputs.first()
        val command = commands[key] ?: return invalidCommand(input)

        val status = command.handleInput(inputs)
        if (status == Status.INVALID) {
            println("$key: Invalid arguments")
        }
        return status
    }

    private fun invalidCommand(input: String): Status {
        println("couldn't understand $input. please try again.")
        return Status.INVALID
    }

    private fun split(input: String): List<String> {
        return input.split(Regex("\\s+")).dropLastWhile { it.isBlank() }
    }
}