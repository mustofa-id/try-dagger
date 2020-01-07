@file:JvmName("CommandLineAtm")

package id.mustofa.atm

import id.mustofa.atm.factory.DaggerCommandRouterFactory
import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)

    val commandRouterFactory = DaggerCommandRouterFactory.create()
    val commandRouter = commandRouterFactory.route()

    while (scanner.hasNextLine()) {
        val input = scanner.nextLine()
        if (input == "/exit") {
            break
        }
        commandRouter.route(input)
    }
}