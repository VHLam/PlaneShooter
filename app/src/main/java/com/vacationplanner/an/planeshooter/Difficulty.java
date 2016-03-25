package com.vacationplanner.an.planeshooter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Difficulty extends Activity {
    private int shiptype=0;
    private int difficulty=0;
    Toast toast;
    RadioGroup rG;

    private int theme=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        rG=(RadioGroup) findViewById(R.id.radioGroup);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_difficulty, menu);
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

    public void start(View view) {
        if(rG.getCheckedRadioButtonId()==R.id.radio1)
        {
            difficulty=0;
        }
        else if(rG.getCheckedRadioButtonId()==R.id.radio2)
        {
            difficulty=1;
        }
        else if(rG.getCheckedRadioButtonId()==R.id.radio3)
        {
            difficulty=2;
        }
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("ShipType",shiptype);
        intent.putExtra("Difficulty",difficulty);
        startActivity(intent);
    }

    public void falcon(View view) {
        toast=Toast.makeText(getApplicationContext(),"You have picked: Falcon",Toast.LENGTH_SHORT);
        toast.show();
        shiptype=0;
    }
    public void eagle(View view) {
        toast=Toast.makeText(getApplicationContext(),"You have picked: Eagle",Toast.LENGTH_SHORT);
        toast.show();
        shiptype=1;
    }
    public void bumblebee(View view) {
        toast=Toast.makeText(getApplicationContext(),"You have picked: Bumblebee",Toast.LENGTH_SHORT);
        toast.show();
        shiptype=2;
    }
}
