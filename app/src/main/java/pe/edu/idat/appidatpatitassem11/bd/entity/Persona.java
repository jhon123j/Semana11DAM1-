package pe.edu.idat.appidatpatitassem11.bd.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "persona")
public class Persona {

    @PrimaryKey
    private int id;
    private String nombres;
    private String apellidos;
    private String email;
    private String celular;
    private String usuario;
    private String password;
    private String esvoluntario;
}
