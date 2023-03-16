package fr.samuel.qcm;

import java.util.Arrays;

public class Question {

    public String question;
    public String [] propositions;
    private boolean [] solutions;

    public Question(String question){
        this.question = question;
        this.propositions = new String[]{"", "", "", ""};
        this.solutions = new boolean[4];
    }

    public void addResponse(String prop, boolean verite){
        //Ajoute les réponses
        for (int i = 0; i < propositions.length; i++) {
            if(propositions[i].equals("")){

                propositions[i] = prop;
                break;
            }
        }

        //Vrai ou faux
        for (int i = 0; i < solutions.length; i++) {
            if(!solutions[i]){
                solutions[i] = verite;
            }
        }
    }

    public double verify(boolean [] solutions){

        //Vérifie si nos réponses sont exactes
        if(Arrays.equals(solutions, this.solutions)){
            return 1;
        }
        return 0;
    }
}
