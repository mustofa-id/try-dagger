package id.mustofa.atm.model.base

import id.mustofa.atm.router.CommandRouter
import java.util.*

interface Command {

    fun key(): String

    fun handleInput(input: List<String>): Result

    class Result(
        val status: Status,
        val nestedCommandRouter: Optional<CommandRouter>
    ) {
        companion object
    }

    enum class Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}