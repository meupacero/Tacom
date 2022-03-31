package tacom.com.br.enviroment;

import android.app.Application;

import tacom.com.br.inject.component.AppComponent;


import tacom.com.br.inject.component.DaggerAppComponent;
import tacom.com.br.inject.modulo.AppModulo;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModulo(new AppModulo(this))
                .build();
    }

    public static AppComponent getComponent(){
        return appComponent;
    }
}