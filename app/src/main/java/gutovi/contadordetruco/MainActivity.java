package gutovi.contadordetruco;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Space;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    FloatingActionButton fabNuevoJuego = findViewById(R.id.fabAgregarJuego);
    TextView lblNoHayJuegos = findViewById(R.id.lblNoHayJuego);
    Space spcBottom = findViewById(R.id.spcBottomSpace);


    TextView lblNombres1 = findViewById(R.id.lblJug1);
    TextView lblNombres2 = findViewById(R.id.lblJug2);
    TextView lblPtos1 = findViewById(R.id.lblPuntos1);
    TextView lblPtos2 = findViewById(R.id.lblPuntos2);

    Button btnEnvido = findViewById(R.id.btnEnvido);
    Button btnRealEnvido = findViewById(R.id.btnRealEnvido);
    Button btnFaltaEnvido = findViewById(R.id.btnFaltaEnvido);


    if (getIntent().getExtras() != null){
        lblNoHayJuegos.setVisibility(View.GONE);
        spcBottom.setVisibility(View.GONE);
        fabNuevoJuego.setRotation(45);

    }else{
        lblNoHayJuegos.setVisibility(View.VISIBLE);
        spcBottom.setVisibility(View.VISIBLE);
        fabNuevoJuego.setRotation(0);
    }

        fabNuevoJuego.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent abrirOpciones = new Intent (MainActivity.this, OpcionesDelJuego.class);
            startActivity ( abrirOpciones );
        }
    });

    }
}
