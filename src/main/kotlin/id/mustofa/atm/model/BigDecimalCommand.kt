package id.mustofa.atm.model

import id.mustofa.atm.model.base.Command
import id.mustofa.atm.model.base.Outputter
import id.mustofa.atm.model.base.SingleArgCommand
import id.mustofa.atm.util.handled
import java.math.BigDecimal

abstract class BigDecimalCommand constructor(
    private val outputter: Outputter
) : SingleArgCommand() {

    override fun handleArg(arg: String): Command.Result {
        val amount = tryParse(arg)
        when {
            amount == null -> outputter.output("$arg is not a valid number")
            amount.signum() <= 0 -> outputter.output("amount must be positive")
            else -> handleAmount(amount)
        }
        return Command.Result.handled
    }

    private fun tryParse(arg: String): BigDecimal? {
        return try {
            BigDecimal(arg)
        } catch (e: NumberFormatException) {
            null
        }
    }

    protected abstract fun handleAmount(amount: BigDecimal)
}