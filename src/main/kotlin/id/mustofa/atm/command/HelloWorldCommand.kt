package id.mustofa.atm.command

import id.mustofa.atm.command.base.Command
import id.mustofa.atm.command.base.Command.Result
import id.mustofa.atm.command.base.Outputter
import id.mustofa.atm.util.handled
import id.mustofa.atm.util.invalid
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(
    private val outputter: Outputter
) : Command {

    override fun handleInput(input: List<String>): Result {
        return if (input.isNotEmpty()) {
            Result.invalid
        } else {
            outputter.output("world!")
            Result.handled
        }
    }
}