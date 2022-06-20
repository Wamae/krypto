package ke.co.svs.mykrypto.di

import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetails
import ke.co.svs.mykrypto.domain.model.UserCrypto
import ke.co.svs.mykrypto.domain.repositories.CryptoDetailsRepositoryImpl
import ke.co.svs.mykrypto.domain.repositories.CryptoRepositoryImpl
import ke.co.svs.mykrypto.domain.repositories.UserCryptoRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module {

    single<BaseListRepository<CryptoDetails>> {
        CryptoDetailsRepositoryImpl(get(),
            get(),
            get(),
            get(named("io")))
    }

    single<BaseListRepository<Crypto>>(named("crypto")) {
        CryptoRepositoryImpl(get(),
            get(),
            get(),
            get(named("io")))
    }

    single {
        UserCryptoRepositoryImpl(get(),
            get(),
            get(),
            get(named("io")))
    }
}