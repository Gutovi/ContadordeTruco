package gutovi.contadordetruco;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.io.Console;


public class OpcionesDelJuego extends AppCompatActivity {



    SeekBar prgJugadores;
    TextView lblJugadores;
    String numJugadores;
    Integer prgValor;
    Integer NumeroChicos;
    Switch swtFlor;

    EditText Chicos;

    EditText Eq1Jug1;
    EditText Eq2Jug1;
    EditText Eq1Jug2;
    EditText Eq2Jug2;
    EditText Eq1Jug3;
    EditText Eq2Jug3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_del_juego);

        Button BotonAceptar = findViewById(R.id.btnCrearJuego);

        prgJugadores =  findViewById(R.id.prgNumJugadores);
        lblJugadores = findViewById(R.id.lblNumJugadores);
        prgValor = prgJugadores.getProgress();
        numJugadores = Integer.toString((prgValor+1)*2);

        Chicos = findViewById(R.id.txtNumeroChicos);

        Eq1Jug1 = findViewById(R.id.txtEq1Jug1);
        Eq2Jug1 = findViewById(R.id.txtEq2Jug1);
        Eq1Jug2 = findViewById(R.id.txtEq1Jug2);
        Eq2Jug2 = findViewById(R.id.txtEq2Jug2);
        Eq1Jug3 = findViewById(R.id.txtEq1Jug3);
        Eq2Jug3 = findViewById(R.id.txtEq2Jug3);

        swtFlor = findViewById(R.id.swtFlor);

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

        BotonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NumeroChicos = Integer.parseInt(Chicos.getText().toString());

                Intent iniciarPartida = new Intent(OpcionesDelJuego.this, MainActivity.class);
                iniciarPartida.putExtra("NumeroJugadores",Integer.parseInt(numJugadores));
                iniciarPartida.putExtra("Flor",swtFlor.isChecked());
                iniciarPartida.putExtra("NumeroChicos",NumeroChicos);

                iniciarPartida.putExtra("E1J1",Eq1Jug1.getText());
                iniciarPartida.putExtra("E1J1",Eq1Jug2.getText());
                iniciarPartida.putExtra("E1J1",Eq1Jug3.getText());
                iniciarPartida.putExtra("E1J1",Eq2Jug1.getText());
                iniciarPartida.putExtra("E1J1",Eq2Jug2.getText());
                iniciarPartida.putExtra("E1J1",Eq2Jug3.getText());

                startActivity(iniciarPartida);

            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();

        lblJugadores.setText("Número de Jugadores:  " + numJugadores);
    }
}
