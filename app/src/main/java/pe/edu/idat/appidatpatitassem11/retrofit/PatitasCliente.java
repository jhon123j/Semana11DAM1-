package pe.edu.idat.appidatpatitassem11.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatitasCliente {
    private static final String Base_URL = "http://www.kreapps.biz/patitas/";
    private  PatitasServicio patitasServicio;

    public PatitasCliente() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        patitasServicio = retrofit.create(PatitasServicio.class);
    }

    public PatitasServicio getInstance(){
        return patitasServicio;
    }
}
