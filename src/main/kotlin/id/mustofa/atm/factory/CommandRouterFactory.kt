package id.mustofa.atm.factory

import dagger.Component
import id.mustofa.atm.module.HelloWorldModule
import id.mustofa.atm.router.CommandRouter

/**
 * CommandRouterFactory is a normal factory type for CommandRouters.
 * Its implementation would call new CommandRouter() instead of our main method doing it.
 * But instead of us writing the implementation of CommandRouterFactory,
 * we can annotate it with @Component to have Dagger generate an implementation
 * for us: DaggerCommandRouterFactory.
 */
@Component(modules = [HelloWorldModule::class])
interface CommandRouterFactory {

    // CommandRouter constructor should annotated with @Inject
    fun route(): CommandRouter
}