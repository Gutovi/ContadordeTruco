package gutovi.contadordetruco;

import android.content.Intent;
import android.opengl.Visibility;
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
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainActivity extends AppCompatActivity {


    Integer intPtosEnJuego = 0;
    Integer intPtos1 = 0;
    Integer intPtos2 = 0;
    Integer intChicos1 = 0;
    Integer intChicos2 = 0;
    Integer intChicosAGanar = 0;
    Integer intNumeroJugadores = 2;

    Deque<String> JugadaAnterior = new ArrayDeque<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intChicosAGanar = getIntent().getIntExtra("NumeroChicos", 1);
        final FloatingActionButton fabNuevoJuego = findViewById(R.id.fabAgregarJuego);
        final TextView lblMensajeGrande = findViewById(R.id.lblMensajeGrande);
        final Space spcBottom = findViewById(R.id.spcBottomSpace);

        final LinearLayout lytJuego = findViewById(R.id.lytJuego);
        final LinearLayout lytTruco = findViewById(R.id.lytTruco);
        final LinearLayout lytEnvido = findViewById(R.id.lytEnvido);
        final LinearLayout lytFlor = findViewById(R.id.lytFlor);
        final LinearLayout lytMazoNoPrimera = findViewById(R.id.lytPrimeraMazoYNoQuiero);
        final TableLayout lytPosiciones = findViewById(R.id.lytPosiciones);

        TextView lblNombres1 = findViewById(R.id.lblJug1);
        TextView lblNombres2 = findViewById(R.id.lblJug2);
        final TextView lblPtos1 = findViewById(R.id.lblPuntos1);
        final TextView lblPtos2 = findViewById(R.id.lblPuntos2);
        final TextView lblPtosEnJuego = findViewById(R.id.lblPuntosEnJuego);
        final TextView lblChicos1 = findViewById(R.id.lblChicos1);
        final TextView lblChicos2 = findViewById(R.id.lblChicos2);

        TextView lblPosJug11 = findViewById(R.id.lblPosJug11);
        TextView lblPosJug12 = findViewById(R.id.lblPosJug12);
        TextView lblPosJug13 = findViewById(R.id.lblPosJug13);
        TextView lblPosJug21 = findViewById(R.id.lblPosJug21);
        TextView lblPosJug22 = findViewById(R.id.lblPosJug22);
        TextView lblPosJug23 = findViewById(R.id.lblPosJug23);

        final Button btnEnvido = findViewById(R.id.btnEnvido);
        final Button btnRealEnvido = findViewById(R.id.btnRealEnvido);
        final Button btnFaltaEnvido = findViewById(R.id.btnFaltaEnvido);

        final Button btnFlor = findViewById(R.id.btnFlor);
        final Button btnContraFlor = findViewById(R.id.btnContraFlor);
        final Button btnContraFlorAlResto = findViewById(R.id.btnContraFlorAlResto);

        final Button btnTruco = findViewById(R.id.btnTruco);
        final Button btnRetruco = findViewById(R.id.btnRetruco);
        final Button btnValeCuatro = findViewById(R.id.btnValeCuatro);

        final Button btnVanAlMazo = findViewById(R.id.btnMazoONoQuiero);
        final Button btnPrimerCarta = findViewById(R.id.btnSeJuegaPrimerCarta);

        final Button btnGanar1 = findViewById(R.id.btnGanaRonda1);
        final Button btnGanar2 = findViewById(R.id.btnGanaRonda2);

        TextView lblGanar1 = findViewById(R.id.lblResultado1);
        TextView lblGanar2 = findViewById(R.id.lblResultado2);
        intNumeroJugadores = getIntent().getIntExtra("NumeroJugadores",2);


        if (getIntent().getExtras() != null) {
            lblMensajeGrande.setVisibility(View.GONE);
            spcBottom.setVisibility(View.GONE);
            fabNuevoJuego.setRotation(45);
            lytJuego.setVisibility(View.VISIBLE);
            lytPosiciones.setVisibility(View.VISIBLE);
            lblNombres1.setText("\n1: "+getIntent().getStringExtra("E1J1"));
            lblNombres2.setText("\n1: "+getIntent().getStringExtra("E2J1"));
            if (intNumeroJugadores==4){
                lblNombres1.append("\n2: "+getIntent().getStringExtra("E1J2"));
                lblNombres2.append("\n2: "+getIntent().getStringExtra("E2J2"));
            }
            if (intNumeroJugadores==6){
                lblNombres1.append("\n3: "+getIntent().getStringExtra("E1J3"));
                lblNombres2.append("\n3: "+getIntent().getStringExtra("E2J3"));
            }
            if (!getIntent().getBooleanExtra("Flor", true)) lytFlor.setVisibility(View.GONE);
            else lytFlor.setVisibility(View.VISIBLE);

            lblPtos1.setText("Tantos:\n" + intPtos1);
            lblPtos2.setText("Tantos:\n" + intPtos2);
            if (intChicosAGanar > 1) {
                lblChicos1.setText("Chicos:\n" + intChicos1);
                lblChicos2.setText("Chicos:\n" + intChicos2);
            } else {
                lblChicos1.setVisibility(View.GONE);
                lblChicos2.setVisibility(View.GONE);
            }

            JugadaAnterior.push("Inicio");

        } else {
            lblMensajeGrande.setVisibility(View.VISIBLE);
            lblMensajeGrande.setText("No hay un juego cargado.\n Creá uno primero.");
            spcBottom.setVisibility(View.VISIBLE);
            fabNuevoJuego.setRotation(0);
            lytJuego.setVisibility(View.GONE);
            lytPosiciones.setVisibility(View.GONE);

        }


        fabNuevoJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirOpciones = new Intent(MainActivity.this, OpcionesDelJuego.class);
                startActivity(abrirOpciones);
            }
        });

        btnVanAlMazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnVanAlMazo.getText().equals("Van al Mazo")) intPtosEnJuego = 1;
                if (btnVanAlMazo.getText().equals("No se Quiere"))
                    intPtosEnJuego = JugadaAnterior.size() - 1;

                if (lytEnvido.getVisibility() != View.GONE) lytEnvido.setVisibility(View.GONE);
                if (lytFlor.getVisibility() != View.GONE) lytFlor.setVisibility(View.GONE);
                if (lytTruco.getVisibility() != View.GONE) lytTruco.setVisibility(View.GONE);
                lytMazoNoPrimera.setVisibility(View.GONE);

                lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);

                btnGanar1.setEnabled(true);
                btnGanar2.setEnabled(true);
            }
        });

        btnPrimerCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (lytEnvido.getVisibility() != View.GONE) lytEnvido.setVisibility(View.GONE);
                if (lytFlor.getVisibility() != View.GONE) lytFlor.setVisibility(View.GONE);
                btnPrimerCarta.setVisibility(View.GONE);

            }
        });

        btnEnvido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intPtosEnJuego += 2;

                Log.d("Jugada Anterior: ", JugadaAnterior.getFirst());
                if (JugadaAnterior.getFirst().equals("Envido")) btnEnvido.setVisibility(View.GONE);
                JugadaAnterior.push("Envido");

                lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);

                lytTruco.setVisibility(View.GONE);
                lytFlor.setVisibility(View.GONE);
                btnPrimerCarta.setVisibility(View.GONE);

                btnVanAlMazo.setText("No se Quiere");
                btnGanar1.setEnabled(true);
                btnGanar2.setEnabled(true);
            }
        });

        btnRealEnvido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intPtosEnJuego += 3;

                Log.d("Jugada Anterior: ", JugadaAnterior.getFirst());
                btnEnvido.setVisibility(View.GONE);
                btnRealEnvido.setVisibility(View.GONE);
                JugadaAnterior.push("Real Envido");

                lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);

                lytTruco.setVisibility(View.GONE);
                lytFlor.setVisibility(View.GONE);
                btnPrimerCarta.setVisibility(View.GONE);

                if (btnVanAlMazo.getText().equals("Van al Mazo"))
                    btnVanAlMazo.setText("No se Quiere");
                btnGanar1.setEnabled(true);
                btnGanar2.setEnabled(true);
            }
        });

        btnFaltaEnvido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (intPtos1 >= intPtos2) intPtosEnJuego = 30 - intPtos1;
                else intPtosEnJuego = 30 - intPtos2;

                Log.d("Jugada Anterior: ", JugadaAnterior.getFirst());
                lytEnvido.setVisibility(View.GONE);
                JugadaAnterior.push("Falta Envido");

                lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);

                lytTruco.setVisibility(View.GONE);
                lytFlor.setVisibility(View.GONE);
                btnPrimerCarta.setVisibility(View.GONE);

                if (btnVanAlMazo.getText().equals("Van al Mazo"))
                    btnVanAlMazo.setText("No se Quiere");
                btnGanar1.setEnabled(true);
                btnGanar2.setEnabled(true);
            }
        });

        if (getIntent().getBooleanExtra("Flor", true)) {

            btnFlor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intPtosEnJuego = 3;

                    if (btnContraFlor.getVisibility() == View.GONE)
                        btnContraFlor.setVisibility(View.VISIBLE);
                    if (btnContraFlorAlResto.getVisibility() == View.GONE)
                        btnContraFlorAlResto.setVisibility(View.VISIBLE);

                    Log.d("Jugada Anterior: ", JugadaAnterior.getFirst());
                    if (JugadaAnterior.getFirst().equals("Flor")) {
                        btnFlor.setVisibility(View.GONE);
                        btnContraFlor.setVisibility(View.GONE);
                        intPtosEnJuego = 4;
                    }
                    JugadaAnterior.push("Flor");

                    lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);


                    lytTruco.setVisibility(View.GONE);
                    lytEnvido.setVisibility(View.GONE);
                    btnPrimerCarta.setVisibility(View.GONE);

                    btnVanAlMazo.setVisibility(View.GONE);
                    btnGanar1.setEnabled(true);
                    btnGanar2.setEnabled(true);
                }
            });

            btnContraFlor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intPtosEnJuego = 6;

                    Log.d("Jugada Anterior: ", JugadaAnterior.getFirst());
                    btnFlor.setVisibility(View.GONE);
                    btnContraFlor.setVisibility(View.GONE);
                    JugadaAnterior.push("Contra-Flor");

                    lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);
                }
            });

            btnContraFlorAlResto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (intPtos1 >= intPtos2) intPtosEnJuego = 30 - intPtos1;
                    else intPtosEnJuego = 30 - intPtos2;

                    Log.d("Jugada Anterior: ", JugadaAnterior.getFirst());
                    lytFlor.setVisibility(View.GONE);
                    JugadaAnterior.push("Contra-Flor al Resto");

                    lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);
                }
            });
        }

        btnTruco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intPtosEnJuego = 2;

                Log.d("Jugada Anterior: ", JugadaAnterior.getFirst());
                btnTruco.setVisibility(View.GONE);
                btnRetruco.setVisibility(View.VISIBLE);
                JugadaAnterior.push("Truco");

                lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);

                lytEnvido.setVisibility(View.GONE);
                lytFlor.setVisibility(View.GONE);
                btnPrimerCarta.setVisibility(View.GONE);

                btnVanAlMazo.setText("No se Quiere");
                btnGanar1.setEnabled(true);
                btnGanar2.setEnabled(true);
            }
        });

        btnRetruco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intPtosEnJuego = 3;

                Log.d("Jugada Anterior: ", JugadaAnterior.getFirst());
                btnRetruco.setVisibility(View.GONE);
                btnValeCuatro.setVisibility(View.VISIBLE);
                JugadaAnterior.push("Retruco");

                lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);
            }
        });

        btnValeCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intPtosEnJuego = 4;

                Log.d("Jugada Anterior: ", JugadaAnterior.getFirst());
                btnValeCuatro.setVisibility(View.GONE);
                JugadaAnterior.push("Vale Cuatro");

                lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);
            }
        });

        btnGanar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intPtos1 += intPtosEnJuego;
                if (intPtos1 >= 30) {
                    intPtos1 -= 30;
                    intChicos1 += 1;
                }
                if (intChicos1 >= intChicosAGanar) {
                    lytJuego.setVisibility(View.GONE);
                    spcBottom.setVisibility(View.VISIBLE);
                    lblMensajeGrande.setVisibility(View.VISIBLE);
                    lblMensajeGrande.setText("Ha ganado el Equipo 1! Felicitaciones a:\n" +
                            getIntent().getStringExtra("E1J1") +
                            getIntent().getStringExtra("E1J2") +
                            getIntent().getStringExtra("E1J3"));
                } else {
                    intPtosEnJuego = 0;
                    lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);

                    if (JugadaAnterior.getFirst().equals("Envido")||JugadaAnterior.getFirst().equals("Real Envido")
                            ||JugadaAnterior.getFirst().equals("Falta Envido")||JugadaAnterior.getFirst().equals("Flor")||
                            JugadaAnterior.getFirst().equals("Contra-Flor")||JugadaAnterior.getFirst().equals("Contra-Flor al Resto")){
                        lytTruco.setVisibility(View.VISIBLE);
                        lytEnvido.setVisibility(View.GONE);
                        lytFlor.setVisibility(View.GONE);
                        btnVanAlMazo.setVisibility(View.VISIBLE);
                    }else{
                        lytEnvido.setVisibility(View.VISIBLE);
                        btnEnvido.setVisibility(View.VISIBLE);
                        btnRealEnvido.setVisibility(View.VISIBLE);
                        btnFaltaEnvido.setVisibility(View.VISIBLE);
                        lytFlor.setVisibility(View.VISIBLE);
                        btnFlor.setVisibility(View.VISIBLE);
                        btnContraFlor.setVisibility(View.GONE);
                        btnContraFlorAlResto.setVisibility(View.GONE);
                        lytTruco.setVisibility(View.VISIBLE);
                        btnTruco.setVisibility(View.VISIBLE);
                        btnRetruco.setVisibility(View.GONE);
                        btnValeCuatro.setVisibility(View.GONE);
                        lytMazoNoPrimera.setVisibility(View.VISIBLE);
                        btnPrimerCarta.setVisibility(View.VISIBLE);
                        btnVanAlMazo.setVisibility(View.VISIBLE);
                    }
                    btnVanAlMazo.setText("Van al Mazo");
                    btnGanar1.setEnabled(false);
                    btnGanar2.setEnabled(false);

                    JugadaAnterior.clear();
                    JugadaAnterior.push("Inicio");

                    lblPtos1.setText("Tantos:\n" + intPtos1);
                    lblChicos1.setText("Chicos:\n" + intChicos1);
                }
            }
        });

        btnGanar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intPtos2 += intPtosEnJuego;
                if (intPtos2 >= 30) {
                    intPtos2 -= 30;
                    intChicos2 += 1;
                }
                if (intChicos2 >= intChicosAGanar) {
                    lytJuego.setVisibility(View.GONE);
                    spcBottom.setVisibility(View.VISIBLE);
                    lblMensajeGrande.setVisibility(View.VISIBLE);
                    lblMensajeGrande.setText("Ha ganado el Equipo 2! Felicitaciones a:\n" +
                            getIntent().getStringExtra("E2J1") +
                            getIntent().getStringExtra("E2J2") +
                            getIntent().getStringExtra("E2J3"));
                } else {
                    intPtosEnJuego = 0;
                    lblPtosEnJuego.setText("Puntos\nen Juego:\n" + intPtosEnJuego);

                    if (JugadaAnterior.getFirst().equals("Envido")||JugadaAnterior.getFirst().equals("Real Envido")
                            ||JugadaAnterior.getFirst().equals("Falta Envido")||JugadaAnterior.getFirst().equals("Flor")||
                            JugadaAnterior.getFirst().equals("Contra-Flor")||JugadaAnterior.getFirst().equals("Contra-Flor al Resto")){
                        lytTruco.setVisibility(View.VISIBLE);
                        lytEnvido.setVisibility(View.GONE);
                        lytFlor.setVisibility(View.GONE);
                        btnVanAlMazo.setVisibility(View.VISIBLE);
                    }else{
                        lytEnvido.setVisibility(View.VISIBLE);
                        btnEnvido.setVisibility(View.VISIBLE);
                        btnRealEnvido.setVisibility(View.VISIBLE);
                        btnFaltaEnvido.setVisibility(View.VISIBLE);
                        lytFlor.setVisibility(View.VISIBLE);
                        btnFlor.setVisibility(View.VISIBLE);
                        btnContraFlor.setVisibility(View.GONE);
                        btnContraFlorAlResto.setVisibility(View.GONE);
                        lytTruco.setVisibility(View.VISIBLE);
                        btnTruco.setVisibility(View.VISIBLE);
                        btnRetruco.setVisibility(View.GONE);
                        btnValeCuatro.setVisibility(View.GONE);
                        lytMazoNoPrimera.setVisibility(View.VISIBLE);
                        btnPrimerCarta.setVisibility(View.VISIBLE);
                        btnVanAlMazo.setVisibility(View.VISIBLE);
                    }
                    btnVanAlMazo.setText("Van al Mazo");
                    btnGanar1.setEnabled(false);
                    btnGanar2.setEnabled(false);

                    JugadaAnterior.clear();
                    JugadaAnterior.push("Inicio");

                    lblPtos2.setText("Tantos:\n" + intPtos2);
                    lblChicos2.setText("Chicos:\n" + intChicos2);
                }
            }
        });
    }
}
