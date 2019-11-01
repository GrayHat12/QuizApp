package ghh.grayhat.quizapp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Questions {

    List<Question> question;
    private int index=0;
    private int selected[];

    public Questions()
    {
        question = new LinkedList<>();
        loadData();
        shuffleData();
    }

    public int getIndex() {
        return index;
    }

    public int getSize()
    {
        return question.size();
    }

    private void loadData()
    {
        String[] answers = {
                "Stock Exchange of New York\n"+
                "Stock Exchange of Kolkata\n"+
                "Super Market in Mumbai\n"+
                "Indian Township in Washington",

                "Total Revolution\n"+
                "Non-Cooperation\n"+
                "Upliftment of all\n"+
                "Non Violence",

                "Agassit\n"+
                "Albertus Magnus\n"+
                "Janseen\n"+
                "Joseph Aspdin",

                "Bihar\n"+
                "Rajasthan\n"+
                "Madhya Pradesh\n"+
                "Maharashtra",

                "Football\n"+
                "Chess\n"+
                "Athletics\n"+
                "Hockey",

                "Igor Sikorsky\n"+
                "Broquet\n"+
                "Copernicus\n"+
                "Cockrell",

                "Agatha Christic\n"+
                "V.S.Naipaul\n"+
                "Ian Fleming\n"+
                "Mario Puzo",

                "Fahien\n"+
                "Megasthanes\n"+
                "Nandagopala\n"+
                "Kautilya",

                "Octomber 21\n"+
                "December 14\n"+
                "February 14\n"+
                "November 21",

                "Zinc\n"+
                "Silver\n"+
                "Copper\n"+
                "Aluminium",

                "Rahul Dravid\n"+
                "Zaheer Khan\n"+
                "Yuvaraj Singh\n"+
                "Sachin Tendulkar",

                "Saul Bellow\n"+
                "Albert Camus\n"+
                "Samuel Beckett\n"+
                "Jean Paul Sartre"
        };
        String questions[]={
                "\"Wall Street\" is the name of the",
                "Sarvodaya stands for",
                "Who discovered Cement?",
                "Which State is the largest producer of pulses in India",
                "Krishna Poonia is associated with ?",
                "Helicopter was invented by ?",
                "Who wrote the book \"The God Father\"?",
                "The brain trust of Chandra Gupta Maurya was ?",
                "Valentine’s Day is celebrated on",
                "The metal whose salts are sensitive to light is ?",
                "In 2011 India won the World Cup. Who was adjudicated as the man of the series in the tournament ?",
                "The author of \"Waiting for Godot\" is"
        };
        String correct[]={
                "Stock Exchange of New York",
                "Upliftment of all",
                "Joseph Aspdin",
                "Madhya Pradesh",
                "Athletics",
                "Igor Sikorsky",
                "Mario Puzo",
                "Kautilya",
                "February 14",
                "Silver",
                "Yuvaraj Singh",
                "Samuel Beckett"
        };
        selected=new int[questions.length];
        for(int i=0;i<questions.length;i++)
        {
            Question ques = new Question(questions[i],answers[i].split("\n"),correct[i]);
            question.add(ques);
            selected[i]=-1;
        }
    }

    public int[] getSelected() {
        return selected;
    }

    public void setSelected(int ind,int val) {
        selected[ind] = val;
    }

    private void shuffleData()
    {
        Collections.shuffle(question);
    }

    public Question getCurrentQuestion()
    {
        return question.get(index);
    }

    public void next()
    {
        if(index==question.size()-1)
        {
            index=0;
        }
        else
        {
            index+=1;
        }
    }

    public Question getQuestion(int ind) {
        return question.get(ind);
    }

    public  void previous()
    {
        if(index==0)
            return;
        index-=1;
    }
}
