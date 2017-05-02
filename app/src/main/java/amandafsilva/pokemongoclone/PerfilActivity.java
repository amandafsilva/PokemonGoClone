package amandafsilva.pokemongoclone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PerfilActivity extends AppCompatActivity {

    public PokemonGoCloneDB bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        bd = new PokemonGoCloneDB();

        Cursor c = bd.buscar("usuario", new String[]{"login", "senha", "nome", "sexo", "foto",
                "dtCadastro", "temSessao"}, "temSessao = 'sim'", "");

        c.moveToPosition(0);
        int idL = c.getColumnIndex("login");
        int idD = c.getColumnIndex("dtCadastro");
        String aux = "login = '" + c.getString(idL) + "'";

        Cursor d = bd.buscar("pokemonusuario", new String[] {"idPokemon"}, aux, "");
        String numPokemon = d.getCount() + "";

        // Troca os TextView pelos dados do usuário
        TextView nomeUsuario = (TextView) findViewById(R.id.textView_TituloPerfil);
        TextView inicioAvent = (TextView) findViewById(R.id.textView_DataInicio);
        TextView numCap = (TextView) findViewById(R.id.textView_QtdePokemon);
        ImageView fotoP = (ImageView) findViewById(R.id.imageView_FotoPerfil);

        nomeUsuario.setText(c.getString(idL));
        inicioAvent.setText(c.getString(idD));
        numCap.setText(numPokemon);

        // Define a barra de tarefas
        Toolbar toolbar = (Toolbar) findViewById(R.id.pToolbar);
        toolbar.setNavigationIcon(R.drawable.seta_voltar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Perfil do Usuário");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /* Implementa a seta de voltar à tela anterior na barra de tarefas */
        int id = item.getItemId();

        if(id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void logout(View view) {
        ContentValues valores = new ContentValues();
        valores.put("temSessao", "nao");

        bd.atualizar("usuario", valores, "temSessao = 'sim'");
        bd.fechar();

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bd.fechar();
    }
}
