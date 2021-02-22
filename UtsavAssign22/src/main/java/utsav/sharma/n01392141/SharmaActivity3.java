/* Utsav Sharma, N01392141 Section C */
package utsav.sharma.n01392141;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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


        getSupportActionBar().setTitle(R.string.order_act3);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        pizaTypeTxt = findViewById(R.id.utsavPizaType);
        pizaSizeTxt = findViewById(R.id.utsavSizeType);
        pizaToppTxt = findViewById(R.id.utsavToppType);

        nameEdt = findViewById(R.id.utsavEdtName);
        creditEdt = findViewById(R.id.utsavEdtCreditCard);
        addEdt = findViewById(R.id.utsavEdtAddress);

        pizaType = getIntent().getStringExtra(getString(R.string.type_act3));
        pizaSize = getIntent().getStringExtra(getString(R.string.size_act3));

        toppArr = new ArrayList<>();
        toppArr = getIntent().getStringArrayListExtra(getString(R.string.topp_act3));
        pizaTypeTxt.setText(pizaType);
        pizaSizeTxt.setText(pizaSize);
        pizaToppTxt.setText(toppArr.toString().replace("]","").replace("[",""));

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
                    nameEdt.setError(getString(R.string.nameedt_act3));
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
                     creditEdt.setError(getString(R.string.namedit2_act3));
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
                    addEdt.setError(getString(R.string.nameedit3_act3));
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
                    ii.putExtra(getString(R.string.ptype_act3),pizaTypeTxt.getText().toString());
                    ii.putExtra(getString(R.string.psize_act3),pizaSizeTxt.getText().toString());
                    ii.putExtra(getString(R.string.ptopp_act3),pizaToppTxt.getText().toString());

                    ii.putExtra(getString(R.string.uname_act3),name);
                    ii.putExtra(getString(R.string.ucredit_act3),creditNo);
                    ii.putExtra(getString(R.string.uaddr_act3),addr);
                    ii.putExtra(getString(R.string.uprov_act3),province);
                    startActivity(ii);

                }
            }
        });
    }
}