package id.mustofa.atm.util

import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

// @Singleton instructs Dagger to create only one instance of the type
// for each instance of the component. It can be used on the class
// declaration of a type that has an @Inject constructor, or on a
// @Binds or @Provides method.
@Singleton
class Database @Inject constructor() {

    private val accounts = mutableMapOf<String, Account>()

    fun getAccount(username: String): Account {
        return accounts.computeIfAbsent(username, Database::Account)
    }

    class Account(
        val username: String
    ) {

        var balance: BigDecimal = BigDecimal.ZERO
            private set

        fun deposit(value: BigDecimal) {
            balance += value
        }
    }
}