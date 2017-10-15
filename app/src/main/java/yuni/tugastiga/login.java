package yuni.tugastiga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private Button button, kembali;

    Intent nma, pwd, user, almt, tgl, iagama, jk, awal;

    String nama, pass;
    EditText ednama, edpwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.btnlogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nma=getIntent();
                user=getIntent();
                pwd=getIntent();
                almt=getIntent();
                tgl=getIntent();
                iagama=getIntent();
                jk=getIntent();

                ednama= (EditText) findViewById(R.id.inputusr);
                edpwd= (EditText) findViewById(R.id.inputpw);
                nama=ednama.getText().toString();
                pass=edpwd.getText().toString();

                if(nama.equals(user.getStringExtra("user")) && pass.equals(pwd.getStringExtra("pwd"))){
                    Intent kirim2 = new Intent(login.this, tampil.class);

                    kirim2.putExtra("user", user.getStringExtra("user"));
                    kirim2.putExtra("pwd", pwd.getStringExtra("pwd"));
                    kirim2.putExtra("nama", nma.getStringExtra("nama"));
                    kirim2.putExtra("radio", jk.getStringExtra("radio"));
                    kirim2.putExtra("tgl", tgl.getStringExtra("tgl"));
                    kirim2.putExtra("agama", iagama.getStringExtra("agama"));
                    kirim2.putExtra("almt",almt.getStringExtra("almt"));
                    startActivity(kirim2);
                    Toast.makeText(login.this,"Anda Berhasil Login",Toast.LENGTH_LONG).show();
                    finish();
                }

                else {
                    Toast.makeText(login.this,"Anda Gagal Login",Toast.LENGTH_SHORT).show();
                }

            }
        });

        kembali= (Button) findViewById(R.id.btnkembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awal= new Intent(login.this, MainActivity.class);
                startActivity(awal);
                finish();
            }
        });

    }
}
