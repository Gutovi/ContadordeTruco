package gutovi.contadordetruco;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    final FloatingActionButton fabNuevoJuego = findViewById(R.id.fabAgregarJuego);
    TextView lblNoHayJuegos = findViewById(R.id.lblNoHayJuego);
    Space spcBottom = findViewById(R.id.spcBottomSpace);

    LinearLayout lytJuego = findViewById(R.id.lytJuego);

    TextView lblNombres1 = findViewById(R.id.lblJug1);
    TextView lblNombres2 = findViewById(R.id.lblJug2);
    TextView lblPtos1 = findViewById(R.id.lblPuntos1);
    TextView lblPtos2 = findViewById(R.id.lblPuntos2);
    TextView lblChicos1 = findViewById(R.id.lblChicos1);
    TextView lblChicos2 = findViewById(R.id.lblChicos2);
    Integer intPtosEnJuego;
    Integer intPtos1 = 0;
    Integer intPtos2 = 0;
    Integer intChicos1 = 0;
    Integer intChicos2 = 0;

    final Button btnEnvido = findViewById(R.id.btnEnvido);
    final Button btnRealEnvido = findViewById(R.id.btnRealEnvido);
    final Button btnFaltaEnvido = findViewById(R.id.btnFaltaEnvido);

    final Button btnFlor = findViewById(R.id.btnFlor);
    final Button btnContraFlor = findViewById(R.id.btnContraFlor);
    final Button btnContraFlorAlResto = findViewById(R.id.btnContraFlorAlResto);

    final Button btnTruco = findViewById(R.id.btnTruco);
    final Button btnRetruco = findViewById(R.id.btnRetruco);
    final Button btnValeCuatro = findViewById(R.id.btnValeCuatro);

    final Button btnVanAlMazo = findViewById(R.id.btnVanAlMazo);

    final  Button btnGanar1 = findViewById(R.id.btnGanaRonda1);
    final Button btnGanar2 = findViewById(R.id.btnGanaRonda2);

    TextView lblGanar1 = findViewById(R.id.lblResultado1);
    TextView lblGanar2 = findViewById(R.id.lblResultado2);


    if (getIntent().getExtras() != null){
        lblNoHayJuegos.setVisibility(View.GONE);
        spcBottom.setVisibility(View.GONE);
        fabNuevoJuego.setRotation(45);
        lytJuego.setVisibility(View.VISIBLE);
        lblNombres1.setText(getIntent().getStringExtra("E1J1")+
                getIntent().getStringExtra("E1J2")+
                getIntent().getStringExtra("E1J3"));
        lblNombres2.setText(getIntent().getStringExtra("E2J1")+
                getIntent().getStringExtra("E2J2")+
                getIntent().getStringExtra("E2J3"));

        lblPtos1.setText("Tantos:\n"+intPtos1);
        lblPtos2.setText("Tantos:\n"+intPtos2);
        lblChicos1.setText("Chicos:\n"+intChicos1);
        lblChicos2.setText("Chicos:\n"+intChicos2);

    }else{
        lblNoHayJuegos.setVisibility(View.VISIBLE);
        spcBottom.setVisibility(View.VISIBLE);
        fabNuevoJuego.setRotation(0);
        lytJuego.setVisibility(View.GONE);
    }



        fabNuevoJuego.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                Intent abrirOpciones = new Intent (MainActivity.this, OpcionesDelJuego.class);
                startActivity ( abrirOpciones );
            }
        });

        btnEnvido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
