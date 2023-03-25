package fr.samuel.qcm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class CorrectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correction);

        //Récupère le questionnaire
        Questionnaire qcm = Questionnaire.getInstance();

        Bundle extras = getIntent().getExtras();

        //Récupère le numéro de la question
        int num = Integer.parseInt(extras.get("position").toString());
        String [] questions = new String[4];

        System.arraycopy(qcm.get(num).propositions, 0, questions, 0, qcm.get(num).propositions.length);

        //Affiche le numéro de question
        TextView numQuestion = findViewById(R.id.numQuestion);
        numQuestion.setText("Réponse à la question n°" + (num+1) + "/"+qcm.getNbQuestions());

        //Affiche la question
        TextView question = findViewById(R.id.question);
        question.setText(qcm.get(num).question);


        CompoundButton[] checkBox = new CompoundButton[5];

        //Récupère les checkbox
        checkBox[0] = findViewById(R.id.checkBox);
        checkBox[1] = findViewById(R.id.checkBox2);
        checkBox[2] = findViewById(R.id.checkBox3);
        checkBox[3] = findViewById(R.id.checkBox4);
        checkBox[4] = findViewById(R.id.checkBox5);

        //Affiche les réponses que l'on avait coché
        for (int i = 0; i < checkBox.length-1; i++) {
            checkBox[i].setText(questions[i]);
            if(qcm.getResponses().get(num)[i] != checkBox[i].isChecked()){
                checkBox[i].toggle();
            }

            if(qcm.get(num).getSolutions()[i] && checkBox[i].isChecked()){
                checkBox[i].setBackgroundColor(Color.GREEN);
            }else if(!qcm.get(num).getSolutions()[i] && !checkBox[i].isChecked()){
                checkBox[i].setBackgroundColor(Color.GREEN);
            }else{
                checkBox[i].setBackgroundColor(Color.RED);
            }
        }


        //Coche la dernière checkbox si aucune autre checkbox est coché
        if(!Arrays.equals(qcm.getResponses().get(num), new boolean[]{false,false,false,false})) {
            checkBox[4].toggle();
        }

        checkBox[4].setBackgroundColor(Color.RED);
        for (int i = 0; i < qcm.get(num).getSolutions().length; i++) {
            if(qcm.get(num).getSolutions()[i] && !checkBox[4].isChecked()){
                checkBox[4].setBackgroundColor(Color.GREEN);
                break;
            }
        }
    }
}