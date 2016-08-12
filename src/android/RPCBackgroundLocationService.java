package br.com.rodrigop.RPCBackgroundLocation;


import org.apache.cordova.*;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Passos on 05/08/16.
 */

public class RPCBackgroundLocationService extends Service {

    public List<Worker> threads = new ArrayList<Worker>();

    public WebView gWebView;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Worker w = new Worker(startId);
        w.start();

        threads.add(w);

        return(super.onStartCommand(intent, flags, startId));
    }

    class Worker extends Thread {
        public int count = 0;
        public int startId;
        public boolean ativo = true;

        public Worker(int startId) {
            this.startId = startId;
            // gWebView = new CordovaWebViewImpl();
        }

        public void run() {
            try {
                gWebView.loadUrl("assets/js/background.html");
                Log.i("Script", "Load Webview");
            }
            catch(Exception e) {
                Log.i("Script", e.getMessage());
            }
            /*while(ativo && count < 100) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count++;
                Log.i("Script", "COUNT: " + count);
            }
            stopSelf(startId);*/
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        for(int i = 0, tam = threads.size(); i < tam; i++) {
            threads.get(i).ativo = false;
        }
    }
}
