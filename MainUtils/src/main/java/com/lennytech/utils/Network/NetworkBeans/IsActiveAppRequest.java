package com.lennytech.utils.Network.NetworkBeans;

/**
 * Created by mikybraun on 2017-11-07.
 */

public class IsActiveAppRequest {
    public String action = "0";
    public String appName;

    public IsActiveAppRequest(String appName){
        this.appName = appName;
    }
}
