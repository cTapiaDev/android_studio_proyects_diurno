package cl.bootcamp.pruebacertificacionejemplo.di

import cl.bootcamp.pruebacertificacionejemplo.repository.WalletRepository
import cl.bootcamp.pruebacertificacionejemplo.repository.WalletRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun walletRepository(walletRepositoryImp: WalletRepositoryImp): WalletRepository
}