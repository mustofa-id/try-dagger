package id.mustofa.atm.model

import id.mustofa.atm.model.base.Command
import id.mustofa.atm.model.base.Command.Result
import id.mustofa.atm.model.base.Outputter
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