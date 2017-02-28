package com.ace.burning.demomvp.View;


import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.widget.Toast;

import com.ace.burning.demomvp.Model.AllTask;
import com.ace.burning.demomvp.Model.ApiResponse;
import com.ace.burning.demomvp.Model.JSONResponse;
import com.ace.burning.demomvp.Presenter.DataPresenter;
import com.ace.burning.demomvp.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewData extends AppCompatActivity implements DataPresenter {


    private ArrayList<AllTask> data;
    private DataAdapter adapter;
    ProgressDialog progressDialog;
    @BindView(R.id.card_recycler_view) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intView();
    }

    @Override
    public void intView() {
        ButterKnife.bind(this);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJson();
    }

    @Override
    public void loadJson() {
        progressDialog = ProgressDialog.show(this, "Loading...", null);
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("http://10.10.10.116")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiResponse request = retrofit.create(ApiResponse.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {

            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getEvent()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }
            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

                Log.d("Error",t.getMessage());

            }
        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}
