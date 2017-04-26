package amandafsilva.pokemongoclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        EditText username = (EditText) findViewById(R.id.editText_Usuario);
        EditText senha = (EditText) findViewById(R.id.editText_Senha);

        if(username.getText().toString().equals("admin") && senha.getText().toString().equals("admin")) {
            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void cadastraUsuario(View view) {
        Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
        startActivity(intent);
    }

}
