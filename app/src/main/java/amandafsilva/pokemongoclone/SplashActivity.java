package amandafsilva.pokemongoclone;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    MediaPlayer opening_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Toca a música de abertura no fundo
        opening_music = MediaPlayer.create(this, R.raw.abertura2);
        opening_music.setLooping(true);
        opening_music.setVolume(100,100);
        opening_music.start();

        // Barra de progresso
        ImageView progBar = (ImageView) findViewById(R.id.progBar);
        AnimationDrawable anim = (AnimationDrawable) progBar.getDrawable();
        anim.start();

        // Redireciona para a tela de login após 2 segundos
        Thread timerThread = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        timerThread.start();
    }
}
