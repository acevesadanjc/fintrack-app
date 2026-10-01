package com.uagr.kmp.course.di

import org.koin.dsl.KoinAppDeclaration
import org.koin.plugin.module.dsl.startKoin
//import org.koin.ksp.generated.module
//import org.koin.core.context.startKoin

fun initKoin(
    config: KoinAppDeclaration? = null
) {
    startKoin<MainApp> {
        config?.invoke(this)
    }

    /*

    startKoin {
        config?.invoke(this)
        modules(
           AppModule().module
        )
    }
    */
}