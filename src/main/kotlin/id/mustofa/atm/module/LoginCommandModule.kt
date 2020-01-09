package id.mustofa.atm.module

import dagger.Binds
import dagger.BindsOptionalOf
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import id.mustofa.atm.command.LoginCommand
import id.mustofa.atm.command.base.Command
import id.mustofa.atm.util.Database

@Module
abstract class LoginCommandModule {

    @Binds
    @IntoMap
    @StringKey("login")
    abstract fun loginCommand(command: LoginCommand): Command

    @BindsOptionalOf
    abstract fun optionalAccount(): Database.Account
}