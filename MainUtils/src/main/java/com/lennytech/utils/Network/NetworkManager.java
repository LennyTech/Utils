package com.lennytech.utils.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;


import com.lennytech.utils.ActivationListener;
import com.lennytech.utils.Constants;
import com.lennytech.utils.Network.NetworkBeans.IsActiveAppRequest;
import com.lennytech.utils.Network.NetworkBeans.IsActiveAppResponse;
import com.lennytech.utils.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by mikybraun on 2017-11-07.
 */

public class NetworkManager {
    private static NetworkManager instance;
    private RetrofitInterface mConnector;
    private static Context mContext;

    public static NetworkManager getInstance(Context con) {
        if (instance == null) {
            instance = new NetworkManager();
            mContext = con;

        }
        return instance;
    }

    public void initRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(Constants.LENNYTECH_URL).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofitMain = builder.client(httpClient.build()).build();
        mConnector = retrofitMain.create(RetrofitInterface.class);
    }


    public void isAppActive(final ActivationListener listener, String appName) {
        IsActiveAppRequest object = new IsActiveAppRequest(appName);

        if (mConnector == null)
            initRetrofit();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("appId", "main");

        mConnector.isAppActive(object, headers).enqueue(new Callback<IsActiveAppResponse>() {
            @Override
            public void onResponse(Call<IsActiveAppResponse> call, Response<IsActiveAppResponse> response) {
                boolean isActive = Integer.parseInt(response.body().isActive) == 0;
                listener.onActivationDone(isActive);
            }

            @Override
            public void onFailure(Call<IsActiveAppResponse> call, Throwable t) {
                listener.onActivationDone(true);
            }
        });
    }
}


