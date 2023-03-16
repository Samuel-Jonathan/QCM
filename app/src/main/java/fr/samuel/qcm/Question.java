package fr.samuel.qcm;

public class Question {

    public String question;
    public String propositions [] = new String[4];
    private boolean solutions [] = new boolean[4];

    public Question(String question){
        this.question = question;
    }

    public void addResponse(String prop, boolean verite){

    }

    public void verify(boolean solutions []){

    }
}
