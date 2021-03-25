package com.example.vetrox.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.vetrox.R;

public class InvolvedActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button next_btn;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_involved);

        radioGroup = findViewById(R.id.radioGroup);
        next_btn = findViewById(R.id.next_btn);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton)group.findViewById(checkedId);
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectId = radioGroup.getCheckedRadioButtonId();
                if (selectId == -1){
                    Toast.makeText(InvolvedActivity.this, "No answer has been selected!", Toast.LENGTH_SHORT).show();
                }
                else {
                    radioButton = (RadioButton)radioGroup.findViewById(selectId);
                    Toast.makeText(InvolvedActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(InvolvedActivity.this,DashBoardActivity.class));
                }
            }
        });

    }
}
