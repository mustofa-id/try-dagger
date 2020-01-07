package id.mustofa.atm.router

import id.mustofa.atm.command.Command
import id.mustofa.atm.command.Command.Status

class CommandRouter {

    private val commands = emptyMap<String, Command>()

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