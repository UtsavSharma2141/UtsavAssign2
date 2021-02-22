/* Utsav Sharma, N01392141 Section C */
package utsav.sharma.n01392141;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
                SelectPizza(getString(R.string.pizza_name1));
            }

        });
        pizaLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPizza(getString(R.string.pizza_name2));
            }
        });
        pizahutLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPizza(getString(R.string.pizza_name3));
            }
        });

        nextBtn = findViewById(R.id.utsavNext);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pizzaSelected){
                    Intent i = new Intent(UtsavActivity.this,SharmaActivity2.class);
                    i.putExtra(getString(R.string.pzzanmextra),seectedPizza);
                    //Toast.makeText(UtsavActivity.this, seectedPizza, Toast.LENGTH_SHORT).show();
                    i.putExtra(getString(R.string.imgid),imgId);
                    startActivity(i);

                }else {
                    String msg = getResources().getString(R.string.toast_One);
                    Toast.makeText(UtsavActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(R.string.exit_dialouge);
        builder.setPositiveButton(R.string.exit_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton(R.string.exit_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

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
                Toast.makeText(this,
                        R.string.pizza_website,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.website1)));
                startActivity(intent);
                break;

            case R.id.utsavpizza:
                Toast.makeText(this,
                        R.string.pizza_websitename,
                        Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.website2)));
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
                seectedPizza = getString(R.string.case_pizza_name1);
                imgId  = R.drawable.dominos;
                break;

            case "piza":
                pizaLt.setBackgroundColor(0xff00B8D4);
                dominoLt.setBackgroundColor(0xffeeeeee);
                pizahutLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = getString(R.string.case_pizza_name2);
                imgId  = R.drawable.piza;
                break;

            case "pizaHut":
                pizahutLt.setBackgroundColor(0xff00B8D4);
                dominoLt.setBackgroundColor(0xffeeeeee);
                pizaLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = getString(R.string.case_pizza_name3);
                imgId  = R.drawable.pizahut;
                break;
        }
        pizzaSelected = true;

    }
}