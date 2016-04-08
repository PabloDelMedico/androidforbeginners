package com.example.pablo.studyjam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Handler;


public class MainActivity extends AppCompatActivity {

    private String[][] data = {
            {"¿Cuál es el país menos turístico de Europa?", "Liechtenstein", "Moldavia", "Armenia", "Hungría"},
            {"¿A qué país pertenece la isla de Tasmania?", "Australia", "Estados Unidos", "Portugal", "Ninguna es correcta"},
            {"¿En cuál de los siguientes países NO hay ningún desierto?", "Alemania", "España", "Chile", "Mongolia"},
            {"¿Cuál es el código internacional para Cuba?", "CU", "CB", "CA", "Ninguna es correcta"},
            {"¿Cuál es la capital del estado de Arkansas?", "Little Rock", "Kansas", "Hot Springs", "Washington"}
    };

    private String[] correctAnswers = {"Liechtenstein", "Australia", "Alemania", "CU", "Little Rock"};

    private int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configText();
    }

    public void HandleClick(View view) {
        Button btnAnswer = (Button) view;
        CharSequence btnTextAnswer = btnAnswer.getText();

        String msg = new String();
        if (correctAnswers[step] == btnTextAnswer) {
            msg = "Felicitaciones!! Tu respuesta:" + btnTextAnswer + " es correcta. Sigue jugando.";
        } else {
            msg = "Ooops!! Tu respuesta:" + btnTextAnswer + " no es correcta. Sigue jugando.";
        }

        showAlert(msg);

        step++;
        configText();
    }

    private void showAlert(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Mensaje");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void configText() {
        int i = 0;

        TextView txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        Button btnAnswer_1 = (Button) findViewById(R.id.btnAnswer_1);
        Button btnAnswer_2 = (Button) findViewById(R.id.btnAnswer_2);
        Button btnAnswer_3 = (Button) findViewById(R.id.btnAnswer_3);
        Button btnAnswer_4 = (Button) findViewById(R.id.btnAnswer_4);

        txtQuestion.setText(data[step][i]);
        btnAnswer_1.setText(data[step][++i]);
        btnAnswer_2.setText(data[step][++i]);
        btnAnswer_3.setText(data[step][++i]);
        btnAnswer_4.setText(data[step][++i]);
    }
}
