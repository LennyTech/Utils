package com.lennytech.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by mikybraun on 2018-02-07.
 */

public class Test extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activation.activate(this, "SOUL", new ActivationListener() {
            @Override
            public void onActivationDone(boolean active) {
                boolean y = active;
            }
        });
    }
}
