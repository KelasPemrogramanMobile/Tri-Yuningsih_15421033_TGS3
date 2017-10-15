package yuni.tugastiga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tampil extends AppCompatActivity {

    String sttgl,stnm,stpw,stjk,stag,stuser, stalmt;

    Intent namaa, alamat, tgl, user, pswd, jk, iagama, awal;

    Button kembali, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        namaa=getIntent();
        alamat=getIntent();
        user=getIntent();
        tgl=getIntent();
        pswd=getIntent();
        jk=getIntent();
        iagama=getIntent();

        TextView tnm = (TextView) findViewById(R.id.namatampil);
        TextView tusr = (TextView) findViewById(R.id.usertampil);
        TextView tpw = (TextView) findViewById(R.id.pwdtampil);
        TextView ttgl = (TextView) findViewById(R.id.tanggaltampil);
        TextView talmt = (TextView) findViewById(R.id.alamattampil);
        TextView tjk = (TextView) findViewById(R.id.jktampil);
        TextView tag = (TextView) findViewById(R.id.agamatampil);



        sttgl=tgl.getStringExtra("tgl");
        stag=iagama.getStringExtra("agama");
        stjk=jk.getStringExtra("radio");
        stpw=pswd.getStringExtra("pwd");
        stuser=user.getStringExtra("user");
        stnm=namaa.getStringExtra("nama");
        stalmt=alamat.getStringExtra("almt");

        ttgl.setText(sttgl);
        tusr.setText(stuser);
        tnm.setText(stnm);
        tpw.setText(stpw);
        talmt.setText(stalmt);
        tjk.setText(stjk);
        tag.setText(stag);

        kembali=(Button) findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                awal= new Intent(tampil.this, MainActivity.class);
                startActivity(awal);
                finish();

            }
        });

        exit= (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
