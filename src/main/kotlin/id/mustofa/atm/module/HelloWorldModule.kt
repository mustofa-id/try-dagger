package id.mustofa.atm.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import id.mustofa.atm.model.HelloWorldCommand
import id.mustofa.atm.model.base.Command

@Module
abstract class HelloWorldModule {

    @Binds
    @IntoMap
    @StringKey("hello")
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}