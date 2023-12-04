package pe.edu.idat.appidatpatitassem11.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import pe.edu.idat.appidatpatitassem11.bd.IdatRoomDatabase;
import pe.edu.idat.appidatpatitassem11.bd.dao.PersonaDao;
import pe.edu.idat.appidatpatitassem11.bd.entity.Persona;

public class PersonaRepository {

    private PersonaDao personaDao;

    public PersonaRepository(Application application){
        IdatRoomDatabase db = IdatRoomDatabase.getDatabase(application);
        personaDao = db.personaDao();
    }

    public LiveData<Persona> obtenerPersona(){
        return personaDao.obtener();
    }

    public void registrarPersona(Persona persona){
        new registrarAsyncTask(personaDao).execute(persona);
    }

    private static class registrarAsyncTask extends AsyncTask<Persona, Void, Void>{
        private PersonaDao personaDao;
        registrarAsyncTask(PersonaDao _perosonaDao){
            _perosonaDao = _perosonaDao;
        }
        @Override
        protected Void doInBackground(Persona... personas) {
            personaDao.insertar(personas[0]);
            return null;
        }
    }

    public void actualizarPersona(Persona persona){
        new actualizarAsyncTask(personaDao).execute(persona);
    }
    private static class actualizarAsyncTask extends AsyncTask<Persona, Void, Void>{
        private PersonaDao personaDao;
        actualizarAsyncTask(PersonaDao _perosonaDao){
            _perosonaDao = _perosonaDao;
        }
        @Override
        protected Void doInBackground(Persona... personas) {
            personaDao.actualizar(personas[0]);
            return null;
        }
    }

    public void eliminarPersona(){
        new eliminarAsynctask(personaDao).execute();
    }
    private static class eliminarAsynctask extends AsyncTask<Persona, Void, Void>{
        private PersonaDao personaDao;
        eliminarAsynctask(PersonaDao _perosonaDao){
            personaDao = _perosonaDao;
        }
        @Override
        protected Void doInBackground(Persona... voids) {
            personaDao.eliminar();
            return null;
        }
    }
}
