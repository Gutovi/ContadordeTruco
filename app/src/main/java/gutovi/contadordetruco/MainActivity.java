package gutovi.contadordetruco;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    FloatingActionButton fabNuevoJuego = findViewById(R.id.fabAgregarJuego);

    fabNuevoJuego.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent abrirOpciones = new Intent (MainActivity.this, OpcionesDelJuego.class );
            startActivity ( abrirOpciones );
        }
    });
    }

}
