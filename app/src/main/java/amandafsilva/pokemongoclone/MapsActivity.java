package amandafsilva.pokemongoclone;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public PokemonGoCloneDB bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.;
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        bd = new PokemonGoCloneDB();

        //Coloca o nome do usuario no abaixo do botao de perfil e imagem correspodente ao sexo
        Cursor c = bd.buscar("usuario", new String[]{"login","sexo"}, "temSessao = 'sim'", "");
        c.moveToPosition(0);
        int idL = c.getColumnIndex("login");
        int idS = c.getColumnIndex("sexo");
        TextView nomeUsuario = (TextView) findViewById(R.id.textView_mapaUsuario);
        nomeUsuario.setText(c.getString(idL));
        ImageButton btn = (ImageButton) findViewById(R.id.profilePic);
        if(c.getString(idS).equals("Masculino")) {
            btn.setImageResource(R.drawable.male_profile);
        }
    }

    public void Perfil(View view) {
        Intent intent = new Intent(getApplicationContext(), PerfilActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(-33.867, 151.206);

        //map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }
}
