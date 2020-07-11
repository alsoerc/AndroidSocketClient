package org.redes.jorge.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.redes.jorge.R;

public class presenceView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presence_view);

        ImageView btnEncender = findViewById(R.id.btnEncenderMovimiento);
        ImageView btnApagar = findViewById(R.id.btnApagarMovimiento);
        ImageView btnAnalizar = findViewById(R.id.btnAnalizarMovimiento);

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
