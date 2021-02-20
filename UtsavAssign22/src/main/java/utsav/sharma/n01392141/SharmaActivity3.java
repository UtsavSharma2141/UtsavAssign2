package utsav.sharma.n01392141;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SharmaActivity3 extends AppCompatActivity {


    EditText nameEdt, creditEdt, addEdt;

    String pizaType, pizaSize;
    ArrayList<String> toppArr;
    TextView pizaTypeTxt, pizaSizeTxt, pizaToppTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utsav3);

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
        pizaToppTxt.setText((CharSequence) toppArr);

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

            }
        });


    }
}