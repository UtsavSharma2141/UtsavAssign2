/* Utsav Sharma, N01392141 Section C */
package utsav.sharma.n01392141;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class UtsavActivity extends AppCompatActivity {

    Button nextBtn;
    RelativeLayout dominoLt, pizaLt, pizahutLt;

    Boolean pizzaSelected = false;
    String seectedPizza = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dominoLt = findViewById(R.id.utsavDomino);
        pizaLt = findViewById(R.id.utsavPiza);
        pizahutLt = findViewById(R.id.utsavPizahut);

        dominoLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPizza("dominos");
            }
        });
        pizaLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPizza("piza");
            }
        });
        pizahutLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPizza("pizaHut");
            }
        });

        nextBtn = findViewById(R.id.utsavNext);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pizzaSelected){
                    Intent i = new Intent(UtsavActivity.this,SharmaActivity2.class);
                    i.putExtra("pizzaNm",seectedPizza);
                    //Toast.makeText(UtsavActivity.this, seectedPizza, Toast.LENGTH_SHORT).show();

                    startActivity(i);

                }else {
                    String msg = getResources().getString(R.string.toast_One);
                    Toast.makeText(UtsavActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void SelectPizza(String pizzaCatg){

        switch (pizzaCatg){
            case "dominos":
                dominoLt.setBackgroundColor(0xff00B8D4);
                pizaLt.setBackgroundColor(0xffeeeeee);
                pizahutLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = "Dominos";
                break;

            case "piza":
                pizaLt.setBackgroundColor(0xff00B8D4);
                dominoLt.setBackgroundColor(0xffeeeeee);
                pizahutLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = "Piza Pizza";
                break;

            case "pizaHut":
                pizahutLt.setBackgroundColor(0xff00B8D4);
                dominoLt.setBackgroundColor(0xffeeeeee);
                pizaLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = "PizzaHut";
                break;
        }
        pizzaSelected = true;

    }
}