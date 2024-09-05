package cl.bootcamp.claseroom.repository

import cl.bootcamp.claseroom.model.Cronos
import cl.bootcamp.claseroom.room.CronosDataBaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CronosRepository @Inject constructor(private val cronosDataBaseDao: CronosDataBaseDao) {

    suspend fun addCrono(crono: Cronos) = cronosDataBaseDao.insert(crono)
    suspend fun updateCrono(crono: Cronos) = cronosDataBaseDao.update(crono)
    suspend fun deleteCrono(crono: Cronos) = cronosDataBaseDao.delete(crono)
    fun getAllCronos(): Flow<List<Cronos>> = cronosDataBaseDao.getCronos().flowOn(Dispatchers.IO).conflate()
    fun getCronosById(id: Long): Flow<Cronos> = cronosDataBaseDao.getCronosById(id).flowOn(Dispatchers.IO).conflate()
}