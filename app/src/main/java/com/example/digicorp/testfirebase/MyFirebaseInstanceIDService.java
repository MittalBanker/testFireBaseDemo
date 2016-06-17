package com.example.digicorp.testfirebase;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by digicorp on 17/06/16.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseIIDService";
    SharedPreferences sharedpreferences;
    public static final String Token = "Tokenkey";
    @Override


    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refrenceToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token:"+refrenceToken);
        sendRegistrationToServer(refrenceToken);

    }
    public void sendRegistrationToServer(String refrenceToken){

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Token, refrenceToken);
        editor.commit();
    }
}
