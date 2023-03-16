package fr.samuel.qcm;

public class Question {

    public String question;
    public String [] propositions;
    private boolean [] solutions;

    public Question(String question){
        this.question = question;
        this.propositions = new String[4];
        this.solutions = new boolean[4];
    }

    public void addResponse(String prop, boolean verite){
        for (int i = 0; i < propositions.length; i++) {
            if(propositions[i].isEmpty()){
                propositions[i] = prop;
            }
        }

        for (int i = 0; i < solutions.length; i++) {
            if(!solutions[i]){
                solutions[i] = verite;
            }
        }
    }

    public double verify(boolean [] solutions){
        return 0;
    }
}
