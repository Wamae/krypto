package ke.co.svs.mykrypto.di

import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.repositories.CryptoRepository
import ke.co.svs.mykrypto.domain.repositories.CryptoRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module {
    single  { CryptoRepositoryImpl(get(),get(),get(),get(named("io"))) }
}