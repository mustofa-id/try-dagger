package id.mustofa.atm.module

import dagger.Binds
import dagger.Module
import id.mustofa.atm.command.Command
import id.mustofa.atm.command.HelloWorldCommand

@Module
abstract class HelloWorldModule {

    @Binds
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}