package fr.samuel.qcm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onChangeCheck();

    }

    private void onChangeCheck(){
        CompoundButton[] checkBox = new CompoundButton[5];


        checkBox[0] = findViewById(R.id.checkBox);
        checkBox[1] = findViewById(R.id.checkBox2);
        checkBox[2] = findViewById(R.id.checkBox3);
        checkBox[3] = findViewById(R.id.checkBox4);
        checkBox[4] = findViewById(R.id.checkBox5);

        checkBox[4].setOnClickListener(e->{
            boolean checked = ((CheckBox)e).isChecked();

            if(checked){
                for (int i = 0; i < checkBox.length-1; i++) {
                    boolean otherChecked = checkBox[i].isChecked();
                    if(otherChecked){
                        checkBox[i].toggle();
                    }
                }
            }
        });



        checkBox[0].setOnClickListener(e->{
            boolean checked = ((CheckBox)e).isChecked();
            if(!checked && !checkBox[1].isChecked() && !checkBox[2].isChecked() && !checkBox[3].isChecked()){
                checkBox[4].toggle();
            }else if(checkBox[4].isChecked()){
                checkBox[4].toggle();
            }
        });

        checkBox[1].setOnClickListener(e->{
            boolean checked = ((CheckBox)e).isChecked();
            if(!checked && !checkBox[0].isChecked() && !checkBox[2].isChecked() && !checkBox[3].isChecked()){
                checkBox[4].toggle();
            }else if(checkBox[4].isChecked()){
                checkBox[4].toggle();
            }
        });

        checkBox[2].setOnClickListener(e->{
            boolean checked = ((CheckBox)e).isChecked();
            if(!checked && !checkBox[1].isChecked() && !checkBox[0].isChecked() && !checkBox[3].isChecked()){
                checkBox[4].toggle();
            }else if(checkBox[4].isChecked()){
                checkBox[4].toggle();
            }
        });

        checkBox[3].setOnClickListener(e->{
            boolean checked = ((CheckBox)e).isChecked();
            if(!checked && !checkBox[1].isChecked() && !checkBox[2].isChecked() && !checkBox[0].isChecked()){
                checkBox[4].toggle();
            }else if(checkBox[4].isChecked()){
                checkBox[4].toggle();
            }
        });
    }
}