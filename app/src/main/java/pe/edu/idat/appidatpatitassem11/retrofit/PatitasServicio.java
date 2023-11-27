package pe.edu.idat.appidatpatitassem11.retrofit;

import java.util.List;

import pe.edu.idat.appidatpatitassem11.retrofit.request.LoginRequest;
import pe.edu.idat.appidatpatitassem11.retrofit.request.RegistroRequest;
import pe.edu.idat.appidatpatitassem11.retrofit.response.LoginResponse;
import pe.edu.idat.appidatpatitassem11.retrofit.response.MascotaResponse;
import pe.edu.idat.appidatpatitassem11.retrofit.response.RegistroResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PatitasServicio {
    @POST("login.php")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @PUT("persona.php")
    Call<RegistroResponse> registro(@Body RegistroRequest registroRequest);

    @GET("mascotaperdida.php")
    Call<List<MascotaResponse>> listarMascotas();
}
