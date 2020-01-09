package id.mustofa.atm.module

import dagger.Module
import dagger.Provides
import id.mustofa.atm.command.base.Outputter
import id.mustofa.atm.util.TextOutputter

@Module
class SystemOutModule {

    // @Provides methods are concrete methods in a module that tell Dagger that
    // when something requests an instance of the type the method returns,
    // it should call that method to get an instance. Like @Inject constructors,
    // they can have parameters: those parameters are their dependencies.
    @Provides
    fun textOutputter(): Outputter {
        return TextOutputter()
    }
}