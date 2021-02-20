package utsav.sharma.n01392141;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SharmaActivity2 extends AppCompatActivity {

    TextView pizzaHead;
    RadioGroup pizzatypeGroup, pizzaSizeGroup;

    TextView typetxt, sizetxt;

    String pizzaType = "", pizaSize = "";
    ArrayList<String> toppingsArr = new ArrayList<>();

    Button nextBtn;

    CheckBox[] checkBoxes = new CheckBox[5];
    Integer[] checkBoxIds = {R.id.utsavToppingPineapple,R.id.utsavToppingGreenOlive,R.id.utsavToppingMushroom,R.id.utsavToppingOnion,R.id.utsavToppingSpinach};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharma2);

        pizzaHead = findViewById(R.id.utsavHead);
        String heading = getIntent().getStringExtra("pizzaNm");
        pizzaHead.setText(heading);

        typetxt = findViewById(R.id.utsavPizzaFinal);
        sizetxt = findViewById(R.id.utsavSizeFinal);

        pizzatypeGroup = findViewById(R.id.utsavPizzaTypeRdGroup);
        pizzatypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                RadioButton rd = (RadioButton) findViewById(id);
                pizzaType = String.valueOf(rd.getText());
                //Toast.makeText(SharmaActivity2.this, type, Toast.LENGTH_SHORT).show();
                typetxt.setText(pizzaType);
            }
        });

        pizzaSizeGroup = findViewById(R.id.utsavPizzaSizeRdGroup);
        pizzaSizeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                RadioButton rd = (RadioButton) findViewById(id);
                pizaSize = String.valueOf(rd.getText());
                //Toast.makeText(SharmaActivity2.this, size, Toast.LENGTH_SHORT).show();

                sizetxt.setText(pizaSize);
            }
        });

        for(int i= 0; i<checkBoxIds.length; i++){
            checkBoxes[i] = (CheckBox) findViewById(checkBoxIds[i]);
            checkBoxes[i].setOnCheckedChangeListener(checkedChangeListener);
        }

        nextBtn = findViewById(R.id.utsavNextBtn);
        nextBtn.setOnClickListener(NextBtnListener);
    }

    private CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String txt = buttonView.getText().toString();
            if(isChecked){
                toppingsArr.add(txt);
            }else {
                toppingsArr.remove(txt);
            }
        }
    };

    private View.OnClickListener NextBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(pizaSize.equals("") || pizzaType.equals("") || toppingsArr.size() < 0){
                String msg  = getResources().getString(R.string.selectionToast);
                Toast.makeText(SharmaActivity2.this, msg, Toast.LENGTH_SHORT).show();
            }else{
                Log.d("qwerty", pizaSize + pizzaType);
                Log.d("qwerty", toppingsArr.toString());
            }

        }
    };
}