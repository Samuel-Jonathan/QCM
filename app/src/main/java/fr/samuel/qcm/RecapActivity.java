package fr.samuel.qcm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RecapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        double scoreTotal = 0;

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        //Affichage du score
        for (int i = 0; i < Questionnaire.getInstance().getNbQuestions(); i++) {
            double score = Questionnaire.getInstance().getScore(i);
            itemsAdapter.add("Question n°"+i + ", score = " + score);
            scoreTotal += score;
        }


        ListView scores = findViewById(R.id.scores);
        scores.setAdapter(itemsAdapter);

        //Affichage de la note totale
        TextView noteTotale = findViewById(R.id.noteTotale);
        noteTotale.setText("Note totale : " + scoreTotal);

    }
}