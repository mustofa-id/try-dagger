package id.mustofa.atm.command.base

import id.mustofa.atm.command.base.Command.Result
import id.mustofa.atm.util.invalid

abstract class SingleArgCommand : Command {

    final override fun handleInput(input: List<String>): Result {
        return if (input.size == 1) handleArg(input[0]) else Result.invalid
    }

    abstract fun handleArg(arg: String): Result
}