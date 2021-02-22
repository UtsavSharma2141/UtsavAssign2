package utsav.sharma.n01392141;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SharmaActivity4 extends AppCompatActivity {

    TextView typetxt, sizetxt, topptxt, nametxt, addtxt, creditxt, provincetxt;
    Button checkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharma4);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        getSupportActionBar().setTitle(R.string.title_conform);

        typetxt = findViewById(R.id.utsavPType);
        sizetxt = findViewById(R.id.utsavPSize);
        topptxt = findViewById(R.id.utsavPTopp);

        nametxt = findViewById(R.id.utsavUname);
        addtxt = findViewById(R.id.utsavUadd);
        creditxt = findViewById(R.id.utsavUcredit);
        provincetxt = findViewById(R.id.utsavUProvince);


        typetxt.setText(getIntent().getStringExtra(getString(R.string.type_act2)));
        sizetxt.setText(getIntent().getStringExtra(getString(R.string.size_act2)));
        topptxt.setText(getIntent().getStringExtra(getString(R.string.topp_act2)));

        nametxt.setText(getIntent().getStringExtra(getString(R.string.uname_act2)));
        addtxt.setText(getIntent().getStringExtra(getString(R.string.uaddr_act2)));
        creditxt.setText(getIntent().getStringExtra(getString(R.string.ucredit_act2)));
        provincetxt.setText(getIntent().getStringExtra(getString(R.string.uprove_act2)));


        checkBtn = findViewById(R.id.utsavCheckTBtn);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SharmaActivity4.this);
                builder.setTitle(R.string.screen4_title);
                builder.setMessage(R.string.toastMsg);
                builder.setPositiveButton(R.string.name_confirm_last, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SharmaActivity4.this, getResources().getString(R.string.endToast),Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton(R.string.name_dismiss, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(SharmaActivity4.this,UtsavActivity.class));
                    }
                });
                builder.show();
            }
        });

    }

}