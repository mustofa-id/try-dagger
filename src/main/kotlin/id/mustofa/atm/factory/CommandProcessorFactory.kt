package id.mustofa.atm.factory

import dagger.Component
import id.mustofa.atm.module.HelloWorldModule
import id.mustofa.atm.module.LoginCommandModule
import id.mustofa.atm.module.SystemOutModule
import id.mustofa.atm.router.UserCommandsRouter
import id.mustofa.atm.util.CommandProcessor
import javax.inject.Singleton

/**
 * CommandRouterFactory is a normal factory type for CommandRouters.
 * Its implementation would call new CommandRouter() instead of our main method doing it.
 * But instead of us writing the implementation of CommandRouterFactory,
 * we can annotate it with @Component to have Dagger generate an implementation
 * for us: DaggerCommandRouterFactory.
 *
 * refactor: CommandRouterFactory to CommandProcessorFactory
 * CommandProcessorFactory is CommandProcessor factory that contains a stack of CommandRouters.
 */
@Singleton
@Component(
    modules = [
        HelloWorldModule::class,
        LoginCommandModule::class,
        UserCommandsRouter.InstallationModule::class,
        SystemOutModule::class
    ]
)
interface CommandProcessorFactory {

    // CommandProcessor constructor should annotated with @Inject
    fun processor(): CommandProcessor
}