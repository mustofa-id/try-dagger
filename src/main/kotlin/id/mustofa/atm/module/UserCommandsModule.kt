package id.mustofa.atm.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import id.mustofa.atm.model.DepositCommand
import id.mustofa.atm.model.LogoutCommand
import id.mustofa.atm.model.base.Command

@Module
abstract class UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract fun depositCommand(command: DepositCommand): Command

    @Binds
    @IntoMap
    @StringKey("logout")
    abstract fun logoutCommand(command: LogoutCommand): Command
}