package amandafsilva.pokemongoclone;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CadastroActivity extends AppCompatActivity {

    public PokemonGoCloneDB bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        bd = new PokemonGoCloneDB();

        /* Define a barra de tarefas */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.seta_voltar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cadastrar");
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

    public void cadastrar(View view) {
        EditText edtNome = (EditText) findViewById(R.id.editText_Nome);
        EditText edtUsuario = (EditText) findViewById(R.id.editText_Usuario);
        EditText edtSenha = (EditText) findViewById(R.id.editText_Senha);
        EditText edtConfSenha = (EditText) findViewById(R.id.editText_ConfirmacaoSenha);
        RadioGroup rdGenero = (RadioGroup) findViewById(R.id.radioGroup);
        String genero = ((RadioButton) findViewById(rdGenero.getCheckedRadioButtonId())).getText().toString();

        Cursor c;

        // Reseta os erros
        edtNome.setError(null);
        edtSenha.setError(null);
        edtUsuario.setError(null);
        edtConfSenha.setError(null);

        // Passa os valores do EditText pra String e guarda
        String nome = edtNome.getText().toString();
        String nomeUsuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        String confSenha = edtConfSenha.getText().toString();

        boolean cancelar = false;
        View focusView = null;

        c = bd.buscar("usuario", new String[]{"login"}, "login = '" + nomeUsuario + "'", "");

        // Checa se algum dos campos está vazio
        if (TextUtils.isEmpty(senha)) {
            edtSenha.setError(getString(R.string.erro_campo_obrigatório));
            focusView = edtSenha;
            cancelar = true;
        } else if (!senhaValida(senha)) {
            edtSenha.setError(getString(R.string.erro_senha_invalida));
            focusView = edtSenha;
            cancelar = true;
        }
        if (TextUtils.isEmpty(nome)) {
            edtNome.setError(getString(R.string.erro_campo_obrigatório));
            focusView = edtNome;
            cancelar = true;
        }
        if (TextUtils.isEmpty(nomeUsuario)) {
            edtUsuario.setError(getString(R.string.erro_campo_obrigatório));
            focusView = edtUsuario;
            cancelar = true;
        } else if (c.getCount() != 0){
            edtUsuario.setError(getString(R.string.erro_usuario_existente));
            focusView = edtUsuario;
            cancelar = true;
        }
        if (TextUtils.isEmpty(confSenha)) {
            edtConfSenha.setError(getString(R.string.erro_campo_obrigatório));
            focusView = edtConfSenha;
            cancelar = true;
        }
        if (!senha.equals(confSenha)) {
            edtConfSenha.setError(getString(R.string.erro_senhas_iguais));
            focusView = edtConfSenha;
            cancelar = true;
        }

        if (cancelar) {
            // Houve erro no preenchimento dos campos
            // Não prosseguir com o login e focar nos campos inválidos
            focusView.requestFocus();
        } else {
            // Pega data e hora atuais
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String strData = sdf.format(cal.getTime());

            // Coloca os valores no BD
            ContentValues valores = new ContentValues();
            valores.put("login", nomeUsuario);
            valores.put("senha", senha);
            valores.put("nome", nome);
            valores.put("sexo", genero);
            if(genero.equals("Feminino"))
                valores.put("foto", "R.drawable.female_profile");
            else
                valores.put("foto", "R.drawable.male_profile");
            valores.put("dtCadastro", strData);
            valores.put("temSessao", "nao");

            bd.inserir("usuario", valores);

            finish();
        }
    }

    private boolean senhaValida(String senha) {
        return senha.length() >= 6;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bd.fechar();
    }
}