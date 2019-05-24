package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;

    int mode =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.button1);
        btnOCBC = findViewById(R.id.button2);
        btnUOB = findViewById(R.id.button3);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId() == R.id.button1){
            mode=1;
        }
        if(v.getId() == R.id.button2){
            mode=2;
        }
        if(v.getId() == R.id.button3){
            mode=3;
        }

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Call");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       if(item.getItemId()==0){

           if(mode==1){
               Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
               startActivity(intentCall);
           }
           if(mode==2){
               Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
               startActivity(intentCall);
           }
           if(mode==3){
               Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
               startActivity(intentCall);
           }
        }
        else if(item.getItemId()==1){
            if(mode==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+180011+11111));
                startActivity(intentCall);
            }
           if(mode==2){
               Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+180036+33333));
               startActivity(intentCall);
           }
           if(mode==3){
               Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18002+222121));
               startActivity(intentCall);
           }
       }



        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");

            return true;
        }else if (id == R.id.ChineseSelection) {
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
        }else  {

        }

        return super.onOptionsItemSelected(item);
    }
}
