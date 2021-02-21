package utsav.sharma.n01392141;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SharmaActivity3 extends AppCompatActivity {


    EditText nameEdt, creditEdt, addEdt;

    String pizaType, pizaSize;
    ArrayList<String> toppArr;
    TextView pizaTypeTxt, pizaSizeTxt, pizaToppTxt;

    Spinner provinceSpinner;
    Button orderbtn;

    String province;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharma3);


        getSupportActionBar().setTitle("Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pizaTypeTxt = findViewById(R.id.utsavPizaType);
        pizaSizeTxt = findViewById(R.id.utsavSizeType);
        pizaToppTxt = findViewById(R.id.utsavToppType);

        nameEdt = findViewById(R.id.utsavEdtName);
        creditEdt = findViewById(R.id.utsavEdtCreditCard);
        addEdt = findViewById(R.id.utsavEdtAddress);

        pizaType = getIntent().getStringExtra("pizaType");
        pizaSize = getIntent().getStringExtra("pizaSize");

        toppArr = new ArrayList<>();
        toppArr = getIntent().getStringArrayListExtra("toppArr");

        pizaTypeTxt.setText(pizaType);
        pizaSizeTxt.setText(pizaSize);
        pizaToppTxt.setText(toppArr.toString());

        nameEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() <= 0){
                    nameEdt.setError("Enter details");
                }
            }
        });

        creditEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() <= 0){
                     creditEdt.setError("Enter details");
                }
            }
        });

        addEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() <= 0){
                    addEdt.setError("Enter details");
                }
            }
        });

        provinceSpinner = findViewById(R.id.utsavProvinceSpin);
        provinceSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,getResources().getStringArray(R.array.province)));

        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                province = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        orderbtn = findViewById(R.id.utsavOrderBtn);
        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdt.getText().toString();
                String creditNo = creditEdt.getText().toString();
                String addr = addEdt.getText().toString();
                

                name = name.replaceAll("\\d","");

                if(name.length() < 3 || creditNo.length() < 16 || addr.length() == 0){
                    String msg = getResources().getString(R.string.toast3);
                    Toast.makeText(SharmaActivity3.this, msg, Toast.LENGTH_SHORT).show();
                }else{
                    // String msg = getResources().getString(R.string.toast3);

                   // Toast.makeText(SharmaActivity3.this, msg, Toast.LENGTH_SHORT).show();
                    Intent ii = new Intent(SharmaActivity3.this,SharmaActivity4.class);
                    ii.putExtra("type",pizaTypeTxt.getText().toString());
                    ii.putExtra("size",pizaSizeTxt.getText().toString());
                    ii.putExtra("topp",pizaToppTxt.getText().toString());

                    ii.putExtra("uname",name);
                    ii.putExtra("ucredit",creditNo);
                    ii.putExtra("uaddr",addr);
                    ii.putExtra("uprov",province);
                    startActivity(ii);

                }
            }
        });
    }
}