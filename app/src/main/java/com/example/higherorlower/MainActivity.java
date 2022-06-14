package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int min=1;
        final int max=10;
        final int random=new Random().nextInt((max-min)+1)+min;

        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edt=findViewById(R.id.edt);
                String number=edt.getText().toString();
                int a=Integer.parseInt(number);

                if(a==random){
                    Toast.makeText(MainActivity.this, "Your guessed it right ", Toast.LENGTH_SHORT).show();
                }else if (a<random){
                    Toast.makeText(MainActivity.this, "Higher", Toast.LENGTH_SHORT).show();
                }else if(a>random ) {
                    try {
//                        throw new OutOfBound();
                        Toast.makeText(MainActivity.this, "Lower", Toast.LENGTH_SHORT).show();
                        throw new OutOfBound();
                    } catch (OutOfBound e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Out of Range ! Guess between 1 And 10", Toast.LENGTH_SHORT).show();
                    }
                }
//                }else{
//
//                }
            }
        });
    }
}

class OutOfBound extends Exception
        {
        OutOfBound()
        {
        super("Out of bound!Try number between 1 to 10");
        }
        }
