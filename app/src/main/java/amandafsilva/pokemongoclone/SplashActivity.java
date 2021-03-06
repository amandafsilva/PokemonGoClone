package amandafsilva.pokemongoclone;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    MediaPlayer opening_music;
    public PokemonGoCloneDB bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Toca a música de abertura no fundo
        opening_music = MediaPlayer.create(this, R.raw.abertura2);
        opening_music.setLooping(true);
        opening_music.setVolume(100,100);
        opening_music.start();

        bd = new PokemonGoCloneDB();

        final Cursor c = bd.buscar("usuario", new String[]{"temSessao"}, "temSessao = 'sim'", "");

        // Barra de progresso
        ImageView progBar = (ImageView) findViewById(R.id.progBar);
        AnimationDrawable anim = (AnimationDrawable) progBar.getDrawable();
        anim.start();

        // Redireciona para a tela de login após 2 segundos
        Thread timerThread = new Thread(){
            public void run(){
                try {
                    if(Conectado()){
                        sleep(2000);
                        if (c.getCount() == 0) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else {
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            public void run() {
                                Toast t = Toast.makeText(getApplicationContext(), "Sem conexão com a Internet.", Toast.LENGTH_LONG);
                                t.show();
                            }
                        });
                        sleep(4000);
                        finish();
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        timerThread.start();
    }

    public boolean Conectado() {
        //Verifica a se o dispositivo esta conectado com a internet
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bd.fechar();
    }
}
