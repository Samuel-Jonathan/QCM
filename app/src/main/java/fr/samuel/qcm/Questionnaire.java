package fr.samuel.qcm;

import java.util.ArrayList;
import java.util.List;

public class Questionnaire {

    private ArrayList <Question> questionlist = new ArrayList<>();
    private static Questionnaire instance;
    private List<Double> listScore;


    private Questionnaire(){
        initialiseQuestionnaire();
        this.listScore = new ArrayList<>();
    }

    private void initialiseQuestionnaire() {

        //Première question
        Question q = new Question("On considère les Etats Unis");
        q.addResponse("La capitale est New York", false);
        q.addResponse("Le pays est indépendant depuis 1774", true);
        q.addResponse("Sa monnaie est le dollar", true);
        q.addResponse("C'est un état fédéral qui compte 52 états", false);
        questionlist.add(q);

        //Deuxième question
        q = new Question("On considère les fruits et les légumes");
        q.addResponse("La tomate est un fruit", true);
        q.addResponse("La pomme de terre vient d'Asie", false);
        q.addResponse("Il faut manger 5 fruite set légumes par jour", true);
        q.addResponse("La banane contient de la vitamine C", false);
        questionlist.add(q);
    }

    public Question get(int i){
        return questionlist.get(i);
    }

    public static Questionnaire getInstance() {
        if (instance == null) {
            instance = new Questionnaire();
        }
        return instance;
    }

    public double getScore(int index){
        return listScore.get(index);
    }

    public void setScore(int index, double score){
        listScore.add(index, score);
    }

    public int getNbQuestions(){
        return this.questionlist.size();
    }

}
