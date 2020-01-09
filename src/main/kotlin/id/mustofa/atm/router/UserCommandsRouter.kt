package id.mustofa.atm.router

import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import id.mustofa.atm.module.UserCommandsModule
import id.mustofa.atm.util.Database.Account
import id.mustofa.atm.util.WithdrawLimiter.PerSession

@PerSession
@Subcomponent(modules = [UserCommandsModule::class])
interface UserCommandsRouter {

    fun router(): CommandRouter

    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance account: Account): UserCommandsRouter
    }

    @Module(subcomponents = [UserCommandsRouter::class])
    interface InstallationModule
}