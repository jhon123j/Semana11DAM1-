package pe.edu.idat.appidatpatitassem11.bd.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import pe.edu.idat.appidatpatitassem11.bd.entity.Persona;

@Dao
public interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public  void insertar(Persona persona);

    @Update
    void actualizar(Persona persona);

    @Query("DELETE FROM persona")
    void eliminar();

    @Query("SELECT * FROM persona LIMIT 1")
    LiveData<Persona> obtener();


}
