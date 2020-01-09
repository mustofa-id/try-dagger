package id.mustofa.atm.module

import dagger.Module
import dagger.Provides
import java.math.BigDecimal
import javax.inject.Qualifier

// To differentiate between different things of the same Java type in a case like this,
// we use qualifiers. A qualifier is an annotation that can be used to give Dagger
// information it can use to distinguish between instances of the same type.
// Qualifiers are annotations that are themselves annotated with @Qualifier.
@Module
class AmountsModule {

    @Provides
    @MinimumBalance
    fun minimumBalance(): BigDecimal = BigDecimal.ZERO

    @Provides
    @MaximumWithdrawal
    fun maximumWithdrawal() = BigDecimal(1000)

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class MinimumBalance

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class MaximumWithdrawal
}