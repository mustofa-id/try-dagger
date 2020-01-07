package id.mustofa.atm.model

import id.mustofa.atm.model.base.Command
import id.mustofa.atm.model.base.Command.Status
import id.mustofa.atm.model.base.Outputter
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(
    private val outputter: Outputter
) : Command {

    override fun key() = "hello"

    override fun handleInput(input: List<String>): Status {
        return if (input.isEmpty()) {
            Status.INVALID
        } else {
            outputter.output("world!")
            Status.HANDLED
        }
    }
}