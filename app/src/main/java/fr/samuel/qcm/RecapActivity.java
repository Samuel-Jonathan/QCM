package fr.samuel.qcm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        //Affichage du score
        for (int i = 0; i < Questionnaire.getInstance().getNbQuestions(); i++) {
            itemsAdapter.add("Question n°"+i + ", score = " + Questionnaire.getInstance().getScore(i));
        }

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);

    }
}