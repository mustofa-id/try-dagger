package id.mustofa.atm.model

import id.mustofa.atm.model.base.Outputter

class TextOutputter : Outputter {

    override fun output(output: String) {
        println(output)
    }
}