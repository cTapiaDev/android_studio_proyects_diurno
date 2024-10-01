package cl.bootcamp.appintegrador.di

import cl.bootcamp.appintegrador.repository.UserRepository
import cl.bootcamp.appintegrador.repository.UserRepositoryImp
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
    abstract fun userRepository(repositoryImp: UserRepositoryImp): UserRepository
}