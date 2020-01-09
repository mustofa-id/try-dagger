package id.mustofa.atm.util

import id.mustofa.atm.command.base.Outputter

class TextOutputter : Outputter {

    override fun output(output: String) {
        println(output)
    }
}