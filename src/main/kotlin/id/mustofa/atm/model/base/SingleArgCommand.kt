package id.mustofa.atm.model.base

import id.mustofa.atm.model.base.Command.Status

abstract class SingleArgCommand : Command {

    final override fun handleInput(input: List<String>): Status {
        return if (input.size == 1) handleArg(input[0]) else Status.INVALID
    }

    abstract fun handleArg(arg: String): Status
}