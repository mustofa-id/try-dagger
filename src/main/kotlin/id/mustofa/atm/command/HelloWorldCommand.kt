package id.mustofa.atm.command

import id.mustofa.atm.command.Command.Status
import javax.inject.Inject

class HelloWorldCommand @Inject constructor() : Command {

    override fun key() = "hello"

    override fun handleInput(input: List<String>): Status {
        return if (input.isEmpty()) {
            Status.INVALID
        } else {
            println("world!")
            Status.HANDLED
        }
    }
}