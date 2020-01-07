@file:JvmName("CommandLineAtm")

package id.mustofa.atm

import id.mustofa.atm.router.CommandRouter
import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)
    val commandRouter = CommandRouter()

    while (scanner.hasNextLine()) {
        val input = scanner.nextLine()
        if (input == "/exit") {
            break
        }
        commandRouter.route(input)
    }
}