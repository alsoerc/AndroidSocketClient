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

public class soundView extends AppCompatActivity {

    SocketConectorView mySocket;
    String msg;
    String rply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_view);

        ImageView btnEncender = findViewById(R.id.btnEncenderSonido);
        final ImageView iconAlert = findViewById(R.id.iconAlertSonido);
        final ImageView btnApagar = findViewById(R.id.btnApagarSonido);
        final ImageView btnAnalizar = findViewById(R.id.btnAnalizarSonido);
        TextView txtBack = findViewById(R.id.txtBackS);

        btnApagar.setVisibility(View.INVISIBLE);
        btnAnalizar.setVisibility(View.INVISIBLE);
        iconAlert.setVisibility(View.INVISIBLE);


        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        try {
            this.mySocket = SocketConectorView.getSocketConector();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnEncender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mySocket.sendMessage(Messages.MOVIL_SOUND_ON);
                    rply = Messages.MOVIL_SOUND_ON.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mySocket.sendMessage(Messages.MOVIL_SOUND_OFF);
                    rply = Messages.MOVIL_SOUND_OFF.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnAnalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mySocket.sendMessage(Messages.MOVIL_SOUND_ANALIZAR);
                    rply = "MOVIL_SOUND_" + String.valueOf(getRandomIntegerBetweenRange(0,2));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread task = new Thread() {
            @Override
            public void run() {
                String msgBackFromSensor = "";
                System.out.println("******LOG SOUND VIEW********");
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
                                case "MOVIL_SOUND_ON":
                                    Toast.makeText(getApplicationContext(), "Encendido", Toast.LENGTH_SHORT).show();
                                    btnApagar.setVisibility(View.VISIBLE);
                                    btnAnalizar.setVisibility(View.VISIBLE);
                                    break;
                                case "MOVIL_SOUND_OFF":
                                    Toast.makeText(getApplicationContext(), "Apagado", Toast.LENGTH_SHORT).show();
                                    btnApagar.setVisibility(View.INVISIBLE);
                                    btnAnalizar.setVisibility(View.INVISIBLE);
                                    iconAlert.setVisibility(View.INVISIBLE);
                                    break;
                                case "MOVIL_SOUND_0":
                                    iconAlert.setVisibility(View.INVISIBLE);
                                    System.out.println("NO PRESENCE");
                                    Toast.makeText(getApplicationContext(), "No sound", Toast.LENGTH_SHORT).show();
                                    break;
                                case "MOVIL_SOUND_1":
                                    iconAlert.setVisibility(View.VISIBLE);
                                    System.out.println("PRESENCE!");
                                    Toast.makeText(getApplicationContext(), "Sound!", Toast.LENGTH_SHORT).show();
                                    break;
                                case "MOVIL_SOUND_2":
                                    iconAlert.setVisibility(View.INVISIBLE);
                                    System.out.println("NO PRESENCE");
                                    Toast.makeText(getApplicationContext(), "No sound", Toast.LENGTH_SHORT).show();
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

    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}
