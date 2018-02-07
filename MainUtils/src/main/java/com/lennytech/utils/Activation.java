package com.lennytech.utils;

import android.content.Context;

import com.lennytech.utils.Network.NetworkManager;

/**
 * Created by mikybraun on 2018-02-07.
 */

public class Activation {

    public static void activate(Context context,String appId, ActivationListener listener){
        NetworkManager.getInstance(context).isAppActive(listener,appId);
    }
}
