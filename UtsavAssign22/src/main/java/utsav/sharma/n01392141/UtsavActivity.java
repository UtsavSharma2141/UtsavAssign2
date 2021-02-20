/* Utsav Sharma, N01392141 Section C */
package utsav.sharma.n01392141;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class UtsavActivity extends AppCompatActivity {

    Button nextBtn;
    LinearLayout dominoLt, pizaLt, pizahutLt;


    Boolean pizzaSelected = false;
    String seectedPizza = "";

    int imgId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

        }
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
                    i.putExtra("imgId",imgId);
                    startActivity(i);

                }else {
                    String msg = getResources().getString(R.string.toast_One);
                    Toast.makeText(UtsavActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.utsavMenu:
                Toast.makeText(this, "Help website", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://food.ndtv.com/food-drinks/an-ultimate-guide-on-how-to-order-a-pizza-1905628"));
                startActivity(intent);
                break;

            case R.id.utsavpizza:
                Toast.makeText(this,
                        R.string.pizza_websitename,
                        Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.dominos.ca/en/"));
                startActivity(intent2);
                break;

            case R.id.myname:
                String name1 = getResources().getString(R.string.menu3);
                Toast.makeText(this, name1, Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void SelectPizza(String pizzaCatg){

        switch (pizzaCatg){
            case "dominos":
                dominoLt.setBackgroundColor(0xff00B8D4);
                pizaLt.setBackgroundColor(0xffeeeeee);
                pizahutLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = "Dominos";
                imgId  = R.drawable.dominos;
                break;

            case "piza":
                pizaLt.setBackgroundColor(0xff00B8D4);
                dominoLt.setBackgroundColor(0xffeeeeee);
                pizahutLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = "Piza Pizza";
                imgId  = R.drawable.piza;
                break;

            case "pizaHut":
                pizahutLt.setBackgroundColor(0xff00B8D4);
                dominoLt.setBackgroundColor(0xffeeeeee);
                pizaLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = "PizzaHut";
                imgId  = R.drawable.pizahut;
                break;
        }
        pizzaSelected = true;

    }
}