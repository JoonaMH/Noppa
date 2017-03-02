package fi.joona.noppa;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    private TextView lopputulos;
    private EditText dNumero;
    private RadioGroup radio;
    private RadioButton kolikko, noppa, muuNoppa;
    private Button button;
    private Button obutton;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            radio = (RadioGroup) findViewById(R.id.radio);
            kolikko = (RadioButton) findViewById(R.id.kolikko);
            noppa = (RadioButton) findViewById(R.id.noppa);
            muuNoppa = (RadioButton) findViewById(R.id.muuNoppa);
            lopputulos = (TextView) findViewById(R.id.lopputulos);
            dNumero = (EditText) findViewById(R.id.dNumero);

            obutton = (Button) findViewById(R.id.buttonToast);

            obutton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View arg0) {

                    Toast.makeText(MainActivity.this, getString(R.string.explanation),
                            Toast.LENGTH_LONG).show();
                }
            });

            button = (Button)findViewById(R.id.heittaa);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int selectedId = radio.getCheckedRadioButtonId();
                    String numero = dNumero.getText().toString();

                    double numerot = Double.parseDouble(numero);
                    int min = 1;
                    int max = (int) numerot;
                    Random rand = new Random();
                    int tulos = rand.nextInt(max - min + 1) + min;
                    int ntulos = rand.nextInt(6 - min + 1) +min;
                    int ktulos = rand.nextInt(2 - min +1) +min;


                    if(selectedId == kolikko.getId()) {
                        if(ktulos == 1) {
                            lopputulos.setText(R.string.heads);
                        } else {
                            lopputulos.setText(R.string.tails);
                        }

                    } else if(selectedId == noppa.getId()) {
                        lopputulos.setText("" +ntulos);
                    } else {
                        lopputulos.setText("" +tulos);
                    }
                }
            });
        }

    }

