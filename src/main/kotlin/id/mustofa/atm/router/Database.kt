package id.mustofa.atm.router

import java.math.BigDecimal
import javax.inject.Inject

class Database @Inject constructor() {

    private val accounts = mutableMapOf<String, Account>()

    fun getAccount(username: String): Account {
        return accounts.computeIfAbsent(username) { Account(it) }
    }

    class Account(
        val username: String,
        val balance: BigDecimal = BigDecimal.ZERO
    )
}