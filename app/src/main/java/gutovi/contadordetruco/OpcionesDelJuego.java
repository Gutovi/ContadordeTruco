package gutovi.contadordetruco;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.Console;


public class OpcionesDelJuego extends AppCompatActivity {



    SeekBar prgJugadores;
    TextView lblJugadores;
    String numJugadores;
    Integer prgValor;

    EditText Eq1Jug2;
    EditText Eq2Jug2;
    EditText Eq1Jug3;
    EditText Eq2Jug3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_del_juego);


        prgJugadores =  findViewById(R.id.prgNumJugadores);
        lblJugadores = findViewById(R.id.lblNumJugadores);
        prgValor = prgJugadores.getProgress();
        numJugadores = Integer.toString((prgValor+1)*2);

        Eq1Jug2 = findViewById(R.id.txtEq1Jug2);
        Eq2Jug2 = findViewById(R.id.txtEq2Jug2);
        Eq1Jug3 = findViewById(R.id.txtEq1Jug3);
        Eq2Jug3 = findViewById(R.id.txtEq2Jug3);

        prgJugadores.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                prgValor = prgJugadores.getProgress();
                numJugadores = Integer.toString((prgValor+1)*2);
                lblJugadores.setText("Número de Jugadores:  " + numJugadores);

                switch (prgValor){
                    case 0:
                        Eq1Jug2.setVisibility(View.GONE);
                        Eq2Jug2.setVisibility(View.GONE);
                        Eq1Jug3.setVisibility(View.GONE);
                        Eq2Jug3.setVisibility(View.GONE);
                        break;
                    case 1:
                        Eq1Jug2.setVisibility(View.VISIBLE);
                        Eq2Jug2.setVisibility(View.VISIBLE);
                        Eq1Jug3.setVisibility(View.GONE);
                        Eq2Jug3.setVisibility(View.GONE);
                        break;
                    case 2:
                        Eq1Jug2.setVisibility(View.VISIBLE);
                        Eq2Jug2.setVisibility(View.VISIBLE);
                        Eq1Jug3.setVisibility(View.VISIBLE);
                        Eq2Jug3.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();

        lblJugadores.setText("Número de Jugadores:  " + numJugadores);
    }
}
