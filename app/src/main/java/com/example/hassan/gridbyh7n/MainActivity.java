package com.example.hassan.gridbyh7n;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.EventLogTags;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            android.support.v7.widget.GridLayout mainGrid = (android.support.v7.widget.GridLayout)findViewById(R.id.mainGrid);

            setSingleEvent(mainGrid);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            Log.i("Error",e.getMessage());
        }
    }

    private void setSingleEvent(android.support.v7.widget.GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0)
                    {
                        Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                        startActivity(intent);
                    }else
                    {
                        Intent intent = new Intent(MainActivity.this,DecripationActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }


                }
            });
        }
    }



}
