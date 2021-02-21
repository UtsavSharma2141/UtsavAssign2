package utsav.sharma.n01392141;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharmaActivity4 extends AppCompatActivity {

    TextView typetxt, sizetxt, topptxt, nametxt, addtxt, creditxt, provincetxt;
    Button checkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharma4);


        getSupportActionBar().setTitle("Conformation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        typetxt = findViewById(R.id.utsavPType);
        sizetxt = findViewById(R.id.utsavPSize);
        topptxt = findViewById(R.id.utsavPTopp);

        nametxt = findViewById(R.id.utsavUname);
        addtxt = findViewById(R.id.utsavUadd);
        creditxt = findViewById(R.id.utsavUcredit);
        provincetxt = findViewById(R.id.utsavUProvince);


        typetxt.setText(getIntent().getStringExtra("type"));
        sizetxt.setText(getIntent().getStringExtra("size"));
        topptxt.setText(getIntent().getStringExtra("topp"));

        nametxt.setText(getIntent().getStringExtra("uname"));
        addtxt.setText(getIntent().getStringExtra("uaddr"));
        creditxt.setText(getIntent().getStringExtra("ucredit"));
        provincetxt.setText(getIntent().getStringExtra("uprov"));

        checkBtn = findViewById(R.id.utsavCheckTBtn);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SharmaActivity4.this);
            }
        });

    }
}