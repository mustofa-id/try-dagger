package id.mustofa.atm.module

import dagger.Binds
import dagger.Module
import id.mustofa.atm.model.LoginCommand
import id.mustofa.atm.model.base.Command

@Module
abstract class LoginCommandModule {

    @Binds
    abstract fun loginCommand(command: LoginCommand): Command
}