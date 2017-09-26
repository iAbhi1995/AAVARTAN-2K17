package com.technocracy.app.aavartan.Event.Model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.technocracy.app.aavartan.Event.Api.EventApi;
import com.technocracy.app.aavartan.Event.EventCallback;
import com.technocracy.app.aavartan.Event.Model.Data.EventData;
import com.technocracy.app.aavartan.helper.App;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitEventProvider implements EventProvider {

    private final Retrofit retrofit;
    private EventApi api;

    public RetrofitEventProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(App.Base_Url).
                addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
    }

    @Override
    public void getFunEvent(final EventCallback callback) {
        api = retrofit.create(EventApi.class);
        retrofit2.Call<EventData> call = api.getFunEvent();
        call.enqueue(new retrofit2.Callback<EventData>() {
            @Override
            public void onResponse(retrofit2.Call<EventData> call, retrofit2.Response<EventData> response) {
                Log.d("abhi", response.body() + "" + "");
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<EventData> call, Throwable t) {
                callback.onFailure();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getManagerialEvent(final EventCallback callback) {
        api = retrofit.create(EventApi.class);
        retrofit2.Call<EventData> call = api.getManagerialEvent();
        call.enqueue(new retrofit2.Callback<EventData>() {
            @Override
            public void onResponse(retrofit2.Call<EventData> call, retrofit2.Response<EventData> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<EventData> call, Throwable t) {
                callback.onFailure();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getTechEvent(final EventCallback callback) {
        api = retrofit.create(EventApi.class);
        retrofit2.Call<EventData> call = api.getTechEvent();
        call.enqueue(new retrofit2.Callback<EventData>() {
            @Override
            public void onResponse(retrofit2.Call<EventData> call, retrofit2.Response<EventData> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<EventData> call, Throwable t) {
                callback.onFailure();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getRoboEvent(final EventCallback callback) {
        api = retrofit.create(EventApi.class);
        retrofit2.Call<EventData> call = api.getRoboEvent();
        call.enqueue(new retrofit2.Callback<EventData>() {
            @Override
            public void onResponse(retrofit2.Call<EventData> call, retrofit2.Response<EventData> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<EventData> call, Throwable t) {
                callback.onFailure();
                t.printStackTrace();
            }
        });
    }
}