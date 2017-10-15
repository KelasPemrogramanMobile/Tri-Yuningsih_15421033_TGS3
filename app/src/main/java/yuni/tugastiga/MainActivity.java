package yuni.tugastiga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button, btnkmb;

    private Spinner spAgama;

    EditText nama, user, almt, pswd, tgl;
    String strnama, struser,stralmt,strpwd,strtgl, strradio, stag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnkirim);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                radioGroup = (RadioGroup) findViewById(R.id.radiogrup);
                button = (Button) findViewById(R.id.btnkirim);
                spAgama = (Spinner) findViewById(R.id.inputspinner);

                nama = (EditText) findViewById(R.id.inputnama);
                user = (EditText) findViewById(R.id.inputuser);
                almt = (EditText) findViewById(R.id.inputalamat);
                pswd = (EditText) findViewById(R.id.inputpwd);
                tgl = (EditText) findViewById(R.id.inputtgl);

                int pilihid = radioGroup.getCheckedRadioButtonId();

                stag = spAgama.getSelectedItem().toString();
                strnama = nama.getText().toString();
                struser = user.getText().toString();
                stralmt = almt.getText().toString();
                strpwd = pswd.getText().toString();
                strtgl = tgl.getText().toString();


                if (struser.isEmpty() || strpwd.isEmpty()){
                    Toast.makeText(MainActivity.this, "Maaf, Field Username / Password Masih Kosong, Harap Diisi!!!", Toast.LENGTH_SHORT).show();

                }
                else {


                    radioButton = (RadioButton) findViewById(pilihid);
                    strradio = radioButton.getText().toString();
                    button = (Button) findViewById(R.id.btnkirim);

                    Intent kirim = new Intent(MainActivity.this, login.class);

                    kirim.putExtra("user",struser);
                    kirim.putExtra("pwd",strpwd);
                    kirim.putExtra("nama",strnama);
                    kirim.putExtra("radio",strradio);
                    kirim.putExtra("tgl",strtgl);
                    kirim.putExtra("agama", stag);
                    kirim.putExtra("almt",stralmt);
                    startActivity(kirim);
                    finish();
                }

            }
        });


        btnkmb= (Button) findViewById(R.id.btnexit);
        btnkmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
