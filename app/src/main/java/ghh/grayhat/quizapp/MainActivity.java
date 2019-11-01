package ghh.grayhat.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    Button next;
    Button prev;
    Button subit;
    RadioGroup group;
    RadioButton op1;
    RadioButton op2;
    RadioButton op3;
    RadioButton op4;
    TextView questionView;
    TextView count;
    Questions questions ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next=(Button) findViewById(R.id.next);
        prev=(Button) findViewById(R.id.prev);
        subit=(Button) findViewById(R.id.submit);
        group = (RadioGroup)findViewById(R.id.radio);
        op1=(RadioButton)findViewById(R.id.op1);
        op2=(RadioButton)findViewById(R.id.op2);
        op3=(RadioButton)findViewById(R.id.op3);
        op4=(RadioButton)findViewById(R.id.op4);
        questionView=(TextView)findViewById(R.id.ques);
        count=(TextView)findViewById(R.id.index);

        questions=new Questions();
        subit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedSubmit();
            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                changedAnswer(checkedId);
            }
        });
        /*group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changedAnswer(v.getId(),v);
            }
        });*/
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        updateUI();
    }

    private void clickedSubmit() {
        Intent result = new Intent(this,Result.class);
        result.putExtra("RES",calculateScore());
        startActivity(result);
    }

    private void goBack() {
        group.clearCheck();
        questions.previous();
        updateUI();
    }

    private void goNext() {
        group.clearCheck();
        questions.next();
        updateUI();
    }

    public void updateUI()
    {
        count.setText((questions.getIndex()+1)+" / "+questions.getSize());
        questionView.setText(questions.getCurrentQuestion().question);
        op1.setText(questions.getCurrentQuestion().answers.get(0));
        op1.setBackgroundColor(Color.parseColor("#38383b"));
        op2.setText(questions.getCurrentQuestion().answers.get(1));
        op2.setBackgroundColor(Color.parseColor("#38383b"));
        op3.setText(questions.getCurrentQuestion().answers.get(2));
        op3.setBackgroundColor(Color.parseColor("#38383b"));
        op4.setText(questions.getCurrentQuestion().answers.get(3));
        op4.setBackgroundColor(Color.parseColor("#38383b"));
        if(questions.getSelected()[questions.getIndex()]==-1)
            return;
        int selected = questions.getSelected()[questions.getIndex()];
        switch (selected){
            case 0:
                if(questions.getCurrentQuestion().getCorrect().equalsIgnoreCase(op1.getText().toString()))
                {
                    op1.setBackgroundColor(Color.GREEN);
                    break;
                }
                op1.setBackgroundColor(Color.RED);
                break;
            case 1:
                if(questions.getCurrentQuestion().getCorrect().equalsIgnoreCase(op2.getText().toString()))
                {
                    op2.setBackgroundColor(Color.GREEN);
                    break;
                }
                op2.setBackgroundColor(Color.RED);
                break;
            case 2:
                if(questions.getCurrentQuestion().getCorrect().equalsIgnoreCase(op3.getText().toString()))
                {
                    op3.setBackgroundColor(Color.GREEN);
                    break;
                }
                op3.setBackgroundColor(Color.RED);
                break;
            case 3:
                if(questions.getCurrentQuestion().getCorrect().equalsIgnoreCase(op4.getText().toString()))
                {
                    op4.setBackgroundColor(Color.GREEN);
                    break;
                }
                op4.setBackgroundColor(Color.RED);
                break;
        }
    }

    private void changedAnswer(int checkedId) {

        if(checkedId==op1.getId())
        {
            questions.setSelected(questions.getIndex(),0);
        }
        else if(checkedId==op2.getId())
        {
            questions.setSelected(questions.getIndex(),1);
        }
        else if(checkedId==op3.getId())
        {
            questions.setSelected(questions.getIndex(),2);
        }
        else if(checkedId==op4.getId())
        {
            questions.setSelected(questions.getIndex(),3);
        }
        updateUI();
    }

    private String calculateScore() {
        String out="";
        int total=0;
        for(int i=0;i<questions.getSize();i++)
        {
            Question ques=questions.getQuestion(i);
            if(questions.getSelected()[i]==-1)
            {
                continue;
            }
            if(ques.getCorrect().equalsIgnoreCase(ques.answers.get(questions.getSelected()[i])))
            {
                total+=1;
            }
        }
        out=total+" / "+questions.getSize();
        return out;
    }

}
