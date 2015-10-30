package com.example.administrator.oct;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        final View.OnClickListener showToast1=new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"直接输出信息",Toast.LENGTH_LONG).show();
            }
        };
        View.OnClickListener showToast2 = new View.OnClickListener(){
            public void onClick(View v){
                LayoutInflater li =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = li.inflate(R.layout.toastinfo,null);
                Toast toast = new Toast(MainActivity.this);
                toast.setView(view);
                toast.show();
            }
        };
        View.OnClickListener showToast3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(MainActivity.this,"图文显示",Toast.LENGTH_LONG);
                LinearLayout mlayout=new LinearLayout(MainActivity.this);
                mlayout.setOrientation(LinearLayout.VERTICAL);
                ImageView mImage=new ImageView(MainActivity.this);
                mImage.setImageResource(R.drawable.ic_launcher);
                View toastView=toast.getView();
                mlayout.addView(mImage);
                mlayout.addView(toastView);
                toast.setView(mlayout);
                toast.show();
            }
        };

        btn1.setOnClickListener(showToast1);
        btn2.setOnClickListener(showToast2);
        btn3.setOnClickListener(showToast3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
