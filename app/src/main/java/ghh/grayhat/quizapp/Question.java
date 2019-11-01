package ghh.grayhat.quizapp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Question {

    String question;
    List<String> answers;
    String correct;

    public Question(String ques,String[] ans,String corr)
    {
        answers=new LinkedList<>();
        if(ans.length==4)
        {
            question=ques;
            answers.add(ans[0]);
            answers.add(ans[1]);
            answers.add(ans[2]);
            answers.add(ans[3]);
            correct=corr;
            shuffleAnswers();
        }
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getCorrect() {
        return correct;
    }

    public void shuffleAnswers()
    {
        Collections.shuffle(answers);
    }
}
/*
"\"Wall Street\" is the name of the"
"Stock Exchange of New York"
"Stock Exchange of Kolkata"
"Super Market in Mumbai"
"Indian Township in Washington"

"Sarvodaya stands for"
"Total Revolution"
"Non-Cooperation"
"Upliftment of all"
"Non Violence"

"Who discovered Cement?"
"Agassit"
"Albertus Magnus"
"Janseen"
"Joseph Aspdin"

"Which State is the largest producer of pulses in India"
"Bihar"
"Rajasthan"
"Madhya Pradesh"
"Maharashtra"

"Krishna Poonia is associated with ?"
"Football"
"Chess"
"Athletics"
"Hockey"

"Helicopter was invented by ?"
"Drinker"
"Broquet"
"Copernicus"
"Cockrell"

"Who wrote the book \"The God Father\"?"
"Agatha Christic"
"V.S.Naipaul"
"Ian Fleming"
"Mario Puzo"

"The brain trust of Chandra Gupta Maurya was ?"
"Fahien"
"Megasthanes"
"Nandagopala"
"Kautilya"

"Valentine’s Day is celebrated on"
"Octomber 21"
"December 14"
"February 14"
"November 21"

"The metal whose salts are sensitive to light is ?"
"Zinc"
"Silver"
"Copper"
"Aluminium"

"In 2011 India won the World Cup. Who was adjudicated as the man of the series in the tournament ?"
"Rahul Dravid"
"Zaheer Khan"
"Yuvaraj Singh"
"Sachin Tendulkar"

"The author of \"Waiting for Godot\" is"
"Saul Bellow"
"Albert Camus"
"Samuel Beckett"
"Jean Paul Sartre"
 */