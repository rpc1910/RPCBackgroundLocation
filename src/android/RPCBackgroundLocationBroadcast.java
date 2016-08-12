package br.com.rodrigop.RPCBackgroundLocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by rodrigo.cunha on 08/08/16.
 */

public class RPCBackgroundLocationBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Script", "onReceive");
        intent = new Intent(context, RPCBackgroundLocationService.class);
        context.startService(intent);
    }
}
