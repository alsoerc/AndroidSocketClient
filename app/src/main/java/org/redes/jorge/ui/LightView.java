package org.redes.jorge.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.redes.jorge.Messages;
import org.redes.jorge.R;
import org.redes.jorge.SocketConectorView;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LightView extends AppCompatActivity {

    SocketConectorView mySocket;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_view);

        ImageView btnEncender = findViewById(R.id.btnEncenderLuz);
        ImageView btnApagar = findViewById(R.id.btnApagarLuz);
        ImageView btnAnalizar = findViewById(R.id.btnAnalizarLuz);


        btnEncender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "here", Toast.LENGTH_SHORT).show();
            }
        });

        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "here", Toast.LENGTH_SHORT).show();
            }
        });

        btnAnalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "here", Toast.LENGTH_SHORT).show();
            }
        });
        //Button btnEnviar = findViewById(R.id.btnEnviar);

        /*btnEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    mySocket.sendMessage(Messages.MOVIL_LIGHT_ON);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            this.mySocket = SocketConectorView.getSocketConector();
        } catch (IOException e) {
            e.printStackTrace();
        }



        Thread task = new Thread() {
            @Override
            public void run() {
                String msgBackFromSensor;
                System.out.println("******LOG LIGH TVIEW********");
                while (true) {

                    try {
                        msgBackFromSensor = mySocket.getInputData().readUTF();
                        if(msgBackFromSensor != null|| msgBackFromSensor.equals("")){
                            System.out.println(msgBackFromSensor);
                        }
                        switch (msgBackFromSensor) {
                            case "MOVIL_LIGHT_SENSOR_ON":
                                System.out.println("ok ENCENDIDO");

                                break;
                            case "MOVIL_LIGHT_SENSOR_OFF":
                                System.out.println("APAGADO");

                                break;
                            default:
                                System.err.println("Escuchando");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(LightView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        task.start();*/

    }




}
