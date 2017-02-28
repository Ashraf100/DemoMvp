package com.ace.burning.demomvp.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Drac Android on 2/27/2017.
 */

public interface ApiResponse {

    @GET("php/showEvent.php")
    Call<JSONResponse> getJSON();
}
