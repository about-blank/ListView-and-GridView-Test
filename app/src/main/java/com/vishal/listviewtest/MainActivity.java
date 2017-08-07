package com.vishal.listviewtest;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener /*, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener */{

//    Button option1_btn, option2_btn, option3_btn, option4_btn;

    Button tryItBtn;
    RadioGroup optionsRadioGroup;
    RadioButton optionsOneRadioButton, optionsTwoRadioButton, optionsThreeRadioButton, optionsFourRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        option1_btn = (Button) findViewById(R.id.OptionOneBtn);
//        option2_btn = (Button) findViewById(R.id.OptionTwoBtn);
//        option3_btn = (Button) findViewById(R.id.OptionThreeBtn);
//        option4_btn = (Button) findViewById(R.id.OptionFourBtn);
//
//        option1_btn.setOnClickListener(this);

        optionsRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        optionsOneRadioButton = (RadioButton) findViewById(R.id.radioButton);
        optionsTwoRadioButton = (RadioButton) findViewById(R.id.radioButton2);
        optionsThreeRadioButton = (RadioButton) findViewById(R.id.radioButton3);
        optionsFourRadioButton = (RadioButton) findViewById(R.id.radioButton4);

//        optionsRadioGroup.setOnCheckedChangeListener(this);
//        optionsOneRadioButton.setOnCheckedChangeListener(this);
//        optionsTwoRadioButton.setOnCheckedChangeListener(this);
//        optionsThreeRadioButton.setOnCheckedChangeListener(this);
//        optionsFourRadioButton.setOnCheckedChangeListener(this);

        tryItBtn = (Button) findViewById(R.id.tryit_btn);
        tryItBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
//            case R.id.OptionOneBtn:
//                Intent i1 = new Intent(this, ListViewStyleOne.class);
//                startActivity(i1);
//                break;
//            case R.id.OptionTwoBtn:
//                break;
//            case R.id.OptionThreeBtn:
//                break;
//            case R.id.OptionFourBtn:
//                break;
            case R.id.tryit_btn:
                if(optionsOneRadioButton.isChecked()) {
                    Intent i1 = new Intent(this, ListViewStyleOne.class);
                    startActivity(i1);
                }
                else {
                    int implementationStyle = -1;
                    if(optionsTwoRadioButton.isChecked()) {
                        implementationStyle = 2;
                    }
                    else if(optionsThreeRadioButton.isChecked()) {
                        implementationStyle = 3;
                    }
                    else if(optionsFourRadioButton.isChecked()) {
                        implementationStyle = 4;
                    }

                    if(implementationStyle != -1) {
                        Intent i2 = new Intent(this, ListViewStyleTwo.class);
                        i2.putExtra("implementation-style", implementationStyle);
                        startActivity(i2);
                    }
                }
                break;


        }


    }

}
