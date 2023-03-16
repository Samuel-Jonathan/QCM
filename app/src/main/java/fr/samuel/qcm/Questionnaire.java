package fr.samuel.qcm;

import java.util.ArrayList;

public class Questionnaire {

    private ArrayList <Question> questionlist = new ArrayList<>();

    public Questionnaire(){
        initialiseQuestionnaire();
    }

    private void initialiseQuestionnaire() {
        Question q = new Question("On considère les Etats Unis");
        q.addResponse("La capitale est New York", false);
        q.addResponse("Le pays est indépendant depuis 1774", true);
        q.addResponse("Sa monnaie est le dollar", true);
        q.addResponse("C'est un état fédéral qui compte 52 états", false);
        questionlist.add(q);

        q = new Question("On considère les fruits et les légumes");
        q.addResponse("La tomate est un fruit", true);
        q.addResponse("La pomme de terre vient d'Asie", false);
        q.addResponse("Il faut manger 5 fruite set légumes par jour", true);
        q.addResponse("La banane contient de la vitamine C", false);
        questionlist.add(q);
    }

    private Question get(int i){
        return questionlist.get(i);
    }

}
