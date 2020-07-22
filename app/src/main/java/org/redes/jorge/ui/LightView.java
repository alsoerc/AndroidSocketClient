package org.redes.jorge.ui;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.redes.jorge.Messages;
import org.redes.jorge.R;
import org.redes.jorge.SocketConectorView;

import java.io.IOException;

public class LightView extends AppCompatActivity {

    SocketConectorView mySocket;
    String msg;
    String rply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_view);

        final ImageView btnEncender = findViewById(R.id.btnEncenderLuz);
        final ImageView btnApagar = findViewById(R.id.btnApagarLuz);
        final ImageView iconLuz = findViewById(R.id.iconLuz);
        TextView txtBack = findViewById(R.id.txtBack);

        try {
            this.mySocket = SocketConectorView.getSocketConector();
        } catch (IOException e) {
            e.printStackTrace();
        }



        iconLuz.setVisibility(View.INVISIBLE);
        btnApagar.setVisibility(View.INVISIBLE);


        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mySocket.sendMessage(Messages.MOVIL_LIGHT_OFF);
                    rply = Messages.MOVIL_LIGHT_OFF.toString();
                    System.out.println(rply);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        btnEncender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mySocket.sendMessage(Messages.MOVIL_LIGHT_ON);
                    rply = Messages.MOVIL_LIGHT_ON.toString();
                    System.out.println(rply);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread task = new Thread() {
            @Override
            public void run() {
                String msgBackFromSensor = "";
                System.out.println("******LOG LIGH TVIEW********");
                while (true){
                    try {
                        msgBackFromSensor = mySocket.getInputData().readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    msg = msgBackFromSensor;
                    System.out.println("De sensor recibí: " + msg);

                    runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                switch (rply) {
                                    case "MOVIL_LIGHT_ON":
                                        Toast.makeText(getApplicationContext(), "Encendido", Toast.LENGTH_SHORT).show();
                                        iconLuz.setVisibility(View.VISIBLE);
                                        btnApagar.setVisibility(View.VISIBLE);
                                        break;
                                    case "MOVIL_LIGHT_OFF":
                                        Toast.makeText(getApplicationContext(), "Apagado", Toast.LENGTH_SHORT).show();
                                        iconLuz.setVisibility(View.INVISIBLE);
                                        btnApagar.setVisibility(View.INVISIBLE);
                                        break;
                                    default:
                                        System.out.println(rply);
                                }
                            }
                        });
                    }
            }
        };

        System.out.println(msg);
        task.start();

    }

}
























