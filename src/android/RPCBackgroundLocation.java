package br.com.rodrigop.RPCBackgroundLocation;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

public class RPCBackgroundLocation extends CordovaPlugin {

    private final String TAG = "RPCBackgroundLocation";

    public boolean execute (String action, JSONArray args, CallbackContext callback) throws JSONException {
        Log.i("Script", action);

        if(action.equals("executar")) {
            executar("");
        }

        return false;
    }

    public void executar(String args) {
        Log.i(TAG, "Executou método 'executar'");
        startService();
    }

    private Activity getApplicationContext() {
        return cordova.getActivity();
    }


    private void startService() {
        Activity context = getApplicationContext();

        Intent intent = new Intent(context, RPCBackgroundLocationService.class);
        //intent.
        context.startService(intent);
    }

    private void stopService() {
        Activity context = getApplicationContext();

        Intent intent = new Intent(context, RPCBackgroundLocationService.class);
        context.stopService(intent);
    }
    
}
