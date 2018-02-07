package com.lennytech.utils.Network;


import com.lennytech.utils.Network.NetworkBeans.IsActiveAppRequest;
import com.lennytech.utils.Network.NetworkBeans.IsActiveAppResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by mikybraun on 2017-11-07.
 */

public interface RetrofitInterface {

    @POST("AdminApi")
    Call<IsActiveAppResponse> isAppActive(@Body IsActiveAppRequest body, @HeaderMap HashMap<String, String> map);


}
