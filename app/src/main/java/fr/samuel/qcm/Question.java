package fr.samuel.qcm;

import java.util.Arrays;

public class Question {

    public String question;
    public String [] propositions;
    private boolean [] solutions;

    public Question(String question){
        this.question = question;
        this.propositions = new String[]{"", "", "", ""};
        this.solutions = new boolean[]{false, false, false, false};
    }

    public void addResponse(String prop, boolean verite){
        //Ajoute les réponses
        for (int i = 0; i < propositions.length; i++) {
            if(propositions[i].equals("")){
                propositions[i] = prop;
                solutions[i] = verite;
                break;
            }
        }
    }

    public double verify(boolean [] solutions){

        double score = 0;

        //Vérifie si nos réponses sont exactes
        for (int i = 0; i < solutions.length; i++) {
            if(solutions[i] == this.solutions[i]){
                score += 0.25;
            }else{
                score -= 0.25;
            }
        }
        return score;
       /* if(Arrays.equals(solutions, this.solutions)){
            return 1;
        }*/

    }
}
