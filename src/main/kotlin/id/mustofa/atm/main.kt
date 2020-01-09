@file:JvmName("CommandLineAtm")

package id.mustofa.atm

import id.mustofa.atm.factory.DaggerCommandProcessorFactory
import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)

    val commandProcessorFactory = DaggerCommandProcessorFactory.create()
    val commandProcessor = commandProcessorFactory.processor()

    while (scanner.hasNextLine()) {
        val input = scanner.nextLine()
        if (input == "/exit") {
            break
        }
        commandProcessor.process(input)
    }
}