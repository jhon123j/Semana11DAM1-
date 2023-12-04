package pe.edu.idat.appidatpatitassem11.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import pe.edu.idat.appidatpatitassem11.bd.entity.Persona;
import pe.edu.idat.appidatpatitassem11.repository.PersonaRepository;

public class PersonaViewModel extends AndroidViewModel {

    private LiveData<Persona> personaLiveData;
    private PersonaRepository personaRepository;
    public PersonaViewModel(@NonNull Application application) {
        super(application);
        personaRepository = new PersonaRepository(application);
    }

    public LiveData<Persona> obtenerPersona(){
        return personaRepository.obtenerPersona();
    }

    public void insertarPersona(Persona persona){
        personaRepository.registrarPersona(persona);
    }

    public void actualizarPersona(Persona persona){
        personaRepository.actualizarPersona(persona);
    }

    public void eliminarPersona(){
        personaRepository.eliminarPersona();
    }


}
