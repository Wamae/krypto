package ke.co.svs.mykrypto.di

import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetails
import ke.co.svs.mykrypto.domain.repositories.CryptoRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module {
    single  <BaseListRepository<Crypto>>{ CryptoRepositoryImpl(get(),get(),get(),get(named("io"))) }
}