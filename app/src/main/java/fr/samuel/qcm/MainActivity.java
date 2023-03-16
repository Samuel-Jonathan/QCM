package fr.samuel.qcm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Questionnaire qcm;
    private int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CompoundButton[] checkBox = new CompoundButton[5];

        //Récupère les checkbox
        checkBox[0] = findViewById(R.id.checkBox);
        checkBox[1] = findViewById(R.id.checkBox2);
        checkBox[2] = findViewById(R.id.checkBox3);
        checkBox[3] = findViewById(R.id.checkBox4);
        checkBox[4] = findViewById(R.id.checkBox5);

        //Évènements des checkbox
        onChecked(checkBox);
        //Création du questionnaire
        this.qcm = new Questionnaire();
        //Met à jour les questionnaire
        updateQuestion(questionNumber, checkBox);

        onValidate(checkBox, questionNumber);

    }

    private void onChecked(CompoundButton [] checkBox){

        //Si on coche la checkbox "Aucun des choix ci-dessus", ça décoche les autres checkbox
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
            //Si on décoche la première checkbox et que les autres ne sont pas cochées, ça active la dernière checkbox
            if(!checked && !checkBox[1].isChecked() && !checkBox[2].isChecked() && !checkBox[3].isChecked()){
                checkBox[4].toggle();
                //Si on coche la première checkbox, ça décoche la dernière checkbox
            }else if(checkBox[4].isChecked()){
                checkBox[4].toggle();
            }
        });

        checkBox[1].setOnClickListener(e->{
            boolean checked = ((CheckBox)e).isChecked();
            //Si on décoche la deuxième checkbox et que les autres ne sont pas cochées, ça active la dernière checkbox
            if(!checked && !checkBox[0].isChecked() && !checkBox[2].isChecked() && !checkBox[3].isChecked()){
                checkBox[4].toggle();
                //Si on coche la deuxième checkbox, ça décoche la dernière checkbox
            }else if(checkBox[4].isChecked()){
                checkBox[4].toggle();
            }
        });

        checkBox[2].setOnClickListener(e->{
            boolean checked = ((CheckBox)e).isChecked();
            //Si on décoche la troisième checkbox et que les autres ne sont pas cochées, ça active la dernière checkbox
            if(!checked && !checkBox[1].isChecked() && !checkBox[0].isChecked() && !checkBox[3].isChecked()){
                checkBox[4].toggle();
                //Si on coche la troisième checkbox, ça décoche la dernière checkbox
            }else if(checkBox[4].isChecked()){
                checkBox[4].toggle();
            }
        });

        checkBox[3].setOnClickListener(e->{
            boolean checked = ((CheckBox)e).isChecked();
            //Si on décoche la quatrième checkbox et que les autres ne sont pas cochées, ça active la dernière checkbox
            if(!checked && !checkBox[1].isChecked() && !checkBox[2].isChecked() && !checkBox[0].isChecked()){
                checkBox[4].toggle();
                //Si on coche la quatrième checkbox, ça décoche la dernière checkbox
            }else if(checkBox[4].isChecked()){
                checkBox[4].toggle();
            }
        });
    }

    private void updateQuestion(int num, CompoundButton[] checkBox){
        System.out.println(num);
        if(num > 1){

            Intent intent = new Intent(MainActivity.this, RecapActivity.class);
            startActivity(intent);

        }else {
            //Met à jour le numéro de question
            TextView numQuestion = findViewById(R.id.numQuestion);
            numQuestion.setText("Question n°" + (num + 1) + "/20");

            //Met à jour les questions
            for (int i = 0; i < checkBox.length - 1; i++) {
                checkBox[i].setText(qcm.get(num).propositions[i]);
            }
        }
    }

    private void onValidate(CompoundButton[] checkbox, int num) {

        Button validateButton = findViewById(R.id.validateButton);

        //Évèvnement lors qu'on clique sur le bouton valider
        validateButton.setOnClickListener(e->{
            //Crée la boîte de dialogue
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Confirmation");
            alert.setMessage("Voulez-vous validez vos réponses ?");
            //Valide les réponses
            alert.setPositiveButton("Valider", (dialogInterface, i) -> {
                boolean [] response = new boolean[4];

                for (int j = 0; j < response.length; j++) {
                    response[j] = checkbox[j].isChecked();
                }
                //Vérifie les réponses
                qcm.get(num).verify(response);

                //Décoche toutes les checkbox
                reset(checkbox);
                questionNumber++;
                //Question suivante
                updateQuestion(questionNumber, checkbox);


            });

            //Annule
            alert.setNegativeButton("Annuler", (dialogInterface, i) -> {

            });

            //Affiche la boîte de dialogue
            alert.show();

        });

    }

    private void reset(CompoundButton[] checkbox){
        for (CompoundButton element : checkbox) {
            boolean checked = element.isChecked();

            if (checked) {
                element.toggle();
            }
        }
    }

}