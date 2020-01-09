package id.mustofa.atm.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import id.mustofa.atm.command.LoginCommand
import id.mustofa.atm.command.base.Command

@Module
abstract class LoginCommandModule {

    @Binds
    @IntoMap
    @StringKey("login")
    abstract fun loginCommand(command: LoginCommand): Command
}