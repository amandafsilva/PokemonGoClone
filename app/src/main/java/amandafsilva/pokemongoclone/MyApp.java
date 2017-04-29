package amandafsilva.pokemongoclone;

import android.app.Application;
import android.content.Context;

/**
 * Created by TULIO on 4/27/2017.
 */

public class MyApp extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApp.context = getApplicationContext();
    }
    public static Context getAppContext() {
        // Método usado para recuperar o context do app
        // de qualquer parte do programa
        return MyApp.context;
    }
}
