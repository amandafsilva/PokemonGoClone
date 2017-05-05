package amandafsilva.pokemongoclone;

import android.content.Intent;
import android.database.Cursor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    public LocationManager lm;
    public Criteria criteria;
    public String provider;
    public int TEMPO_REQUISICAO_LATLONG = 5000;
    public int DISTANCIA_MIN_METROS = 0;

    BitmapDescriptor marcador;

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

        // Cria o marcador feminino
        marcador = BitmapDescriptorFactory.fromResource(R.drawable.female);

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
            marcador = BitmapDescriptorFactory.fromResource(R.drawable.male);
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
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18));

        MarkerOptions markerOptions = new MarkerOptions().position(sydney)
                .icon(marcador);

        map.addMarker(markerOptions);
    }

    @Override
    public void onLocationChanged(Location location) {

    }
}
