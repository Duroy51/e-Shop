package com.example.e_shopstaff.dao



import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.ClientCarte
import kotlinx.coroutines.flow.Flow

@Dao
interface clientCarteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertClientCarte(item: ClientCarte)

    @Update
    suspend fun updateClientCarte(item: ClientCarte)

    @Delete
    suspend fun deleteClientCarte(item: ClientCarte)

    @Query("SELECT * from ClientCarte WHERE matr = :id")
    fun getClientCarte(id: Int): Flow<ClientCarte>

    @Query("SELECT * from ClientCarte ORDER BY nom ASC")
    fun getAllClientCarte(): Flow<List<ClientCarte>>
}