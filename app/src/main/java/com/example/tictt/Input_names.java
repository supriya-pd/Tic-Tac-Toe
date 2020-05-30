package com.example.tictt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.EditText;

public class Input_names extends AppCompatActivity {

    EditText p1_name;
    EditText p2_name;
    String n1;
    String n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_names);
        p1_name=(EditText)findViewById(R.id.editText);
        p2_name=(EditText)findViewById(R.id.editText2);
        n1=p1_name.getText().toString();
        n2=p2_name.getText().toString();
        Intent intent=new Intent(Input_names.this,MainActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("p1_name",n1);
        bundle.putString("p2_name",n2);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
