package org.redes.jorge.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.redes.jorge.R;

public class soundView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_view);

        ImageView btnEncender = findViewById(R.id.btnEncenderSonido);
        ImageView btnApagar = findViewById(R.id.btnApagarSonido);
        ImageView btnAnalizar = findViewById(R.id.btnAnalizarSonido);

        btnEncender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnAnalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
