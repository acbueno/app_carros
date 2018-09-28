package br.com.livroandroid.carros;

import android.app.Application;
import android.util.Log;

/**
 * Created by ander on 27/09/2018.
 */

public class CarrosApplication extends Application {

    private static final String TAG = "CarrosApplication";
    private static CarrosApplication instance = null;

    public static CarrosApplication getInstance(){
        return instance;// Singleton
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(TAG, "CarrosApplication.onCreate()");
        //Salva a instancia para termos acesso como Singleton
        instance = this;

    }

    public void onTerminate(){
        super.onTerminate();
        Log.d(TAG, "CarrosApplication.onTerminate()");
    }




}
