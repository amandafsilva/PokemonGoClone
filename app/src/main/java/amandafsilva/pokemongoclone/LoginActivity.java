package amandafsilva.pokemongoclone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    public PokemonGoCloneDB bd;

    EditText edtUsername;
    EditText edtSenha;
    TextView erroLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bd = new PokemonGoCloneDB();

        edtUsername = (EditText) findViewById(R.id.editText_Usuario);
        edtSenha = (EditText) findViewById(R.id.editText_Senha);
        erroLogin = (TextView) findViewById(R.id.textView_Erro);
    }

    public void login(View view) {
        // Reseta os erros
        edtUsername.setError(null);
        edtSenha.setError(null);

        // Passa os valores do EditText pra String e guarda
        String username = edtUsername.getText().toString();
        String senha = edtSenha.getText().toString();

        boolean cancelar = false;
        View focusView = null;

        // Checa se o campo Senha está vazio
        if (TextUtils.isEmpty(senha)) {
            edtSenha.setError(getString(R.string.erro_campo_obrigatório));
            focusView = edtSenha;
            cancelar = true;
        }

        // Checa se o campo Usuário está vazio
        if (TextUtils.isEmpty(username)) {
            edtUsername.setError(getString(R.string.erro_campo_obrigatório));
            focusView = edtUsername;
            cancelar = true;
        }

        if (cancelar) {
            // Houve erro no preenchimento dos campos
            // Não prosseguir com o login e focar nos campos inválidos
            focusView.requestFocus();
        } else {
            // Checa se usuário existe no banco de dados e faz validação dos dados
            Cursor c = bd.buscar("usuario", new String[]{"login", "senha", "nome", "sexo", "foto",
                                                        "dtCadastro", "temSessao"}, "login = '" + username + "'", "");

            if (c.getCount() == 0) {
                // Usuário não existe
                erroLogin.setText(R.string.erro_usuario_inexistente);
            } else {
                c.moveToPosition(0);
                int idS = c.getColumnIndex("senha");

                if (c.getString(idS).equals(senha)) {
                    // Usuário existe e senha está correta
                    ContentValues valores = new ContentValues();
                    valores.put("temSessao", "sim");

                    bd.atualizar("usuario", valores, "login = '" + username + "'");
                    bd.fechar();

                    c.close();
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Senha está incorreta
                    erroLogin.setText(R.string.erro_senha_incorreta);
                }
            }

        }
    }

    public void cadastraUsuario(View view) {
        Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bd.fechar();
    }
}
