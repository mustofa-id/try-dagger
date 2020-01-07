package id.mustofa.atm.module

import dagger.Binds
import dagger.Module
import id.mustofa.atm.model.HelloWorldCommand
import id.mustofa.atm.model.base.Command

@Module
abstract class HelloWorldModule {

    @Binds
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}