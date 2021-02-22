/* Utsav Sharma, N01392141 Section C */
package utsav.sharma.n01392141;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SharmaActivity2 extends AppCompatActivity {

    RadioGroup pizzatypeGroup, pizzaSizeGroup;

    String pizzaType = "", pizaSize = "";
    ArrayList<String> toppingsArr = new ArrayList<>();

    Button nextBtn;
    ImageView pizaImg;

    CheckBox[] checkBoxes = new CheckBox[5];
    Integer[] checkBoxIds = {R.id.utsavToppingPineapple,R.id.utsavToppingGreenOlive,R.id.utsavToppingMushroom,R.id.utsavToppingOnion,R.id.utsavToppingSpinach};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharma2);


        pizaImg = findViewById(R.id.utsavImg);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        String heading = getIntent().getStringExtra(getString(R.string.pizzanm1_activity2));
        getSupportActionBar().setTitle(heading);
        pizaImg.setImageDrawable(getResources().getDrawable(getIntent().getIntExtra("imgId",R.drawable.dominos)));

        pizzatypeGroup = findViewById(R.id.utsavPizzaTypeRdGroup);
        pizzatypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                RadioButton rd = (RadioButton) findViewById(id);
                pizzaType = String.valueOf(rd.getText());
                //Toast.makeText(SharmaActivity2.this, type, Toast.LENGTH_SHORT).show();
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
            //Toast.makeText(SharmaActivity2.this, Integer.toString(toppingsArr.size()), Toast.LENGTH_SHORT).show();
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

            if(pizaSize.equals("") || pizzaType.equals("") || toppingsArr.size() == 0){
                String msg  = getResources().getString(R.string.selectionToast);
                Toast.makeText(SharmaActivity2.this, msg, Toast.LENGTH_SHORT).show();
            }else{
                Intent ii = new Intent(SharmaActivity2.this,SharmaActivity3.class);
                ii.putExtra(getString(R.string.pizzatype_activity2),pizzaType);
                ii.putExtra(getString(R.string.pizzasize_activity2),pizaSize);
                ii.putStringArrayListExtra(getString(R.string.toppings1_activity2),toppingsArr);

                startActivity(ii);
            }

        }

    };
}