package id.mustofa.atm.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import id.mustofa.atm.command.DepositCommand
import id.mustofa.atm.command.LogoutCommand
import id.mustofa.atm.command.WithdrawCommand
import id.mustofa.atm.command.base.Command

@Module
abstract class UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract fun depositCommand(command: DepositCommand): Command

    @Binds
    @IntoMap
    @StringKey("withdraw")
    abstract fun withdrawCommand(command: WithdrawCommand): Command

    @Binds
    @IntoMap
    @StringKey("logout")
    abstract fun logoutCommand(command: LogoutCommand): Command
}