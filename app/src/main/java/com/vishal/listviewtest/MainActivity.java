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

public class MainActivity extends AppCompatActivity implements View.OnClickListener , RadioGroup.OnCheckedChangeListener {


    Button tryItBtn;
    RadioGroup optionsRadioGroup;
    RadioButton optionsOneRadioButton, optionsTwoRadioButton, optionsThreeRadioButton, optionsFourRadioButton;

    RadioGroup radioGroupContainer;
    RadioButton optionList, optionGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionsRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        optionsOneRadioButton = (RadioButton) findViewById(R.id.radioButton);
        optionsTwoRadioButton = (RadioButton) findViewById(R.id.radioButton2);
        optionsThreeRadioButton = (RadioButton) findViewById(R.id.radioButton3);
        optionsFourRadioButton = (RadioButton) findViewById(R.id.radioButton4);

        radioGroupContainer = (RadioGroup) findViewById(R.id.radioGroupListGrid);
        optionList= (RadioButton) findViewById(R.id.radioButtonList);
        optionGrid = (RadioButton) findViewById(R.id.radioButtonGrid);

        radioGroupContainer.setOnCheckedChangeListener(this);

        tryItBtn = (Button) findViewById(R.id.tryit_btn);
        tryItBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.tryit_btn:
                String container = "LISTVIEW";

                if(optionGrid.isChecked())
                    container = "GRIDVIEW";

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
                        i2.putExtra("container-type", container);
                        i2.putExtra("implementation-style", implementationStyle);
                        startActivity(i2);
                    }
                }
                break;


        }


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

        if(optionGrid.isChecked()) {
            if(optionsOneRadioButton.isChecked())
                optionsTwoRadioButton.setChecked(true);

            optionsOneRadioButton.setEnabled(false);
        } else if(optionList.isChecked()) {

            optionsOneRadioButton.setEnabled(true);
        }
    }
}
