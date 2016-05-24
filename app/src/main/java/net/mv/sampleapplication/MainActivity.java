package net.mv.sampleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int currentQuestion;
    private String[] questions;
    private String[] answers;
    private Button answerButton;
    private Button questionButton;
    private TextView questionView;
    private TextView answerView;
    private EditText answerText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       init();
    }

    public void init()
    {
        questions = new String[]{
                "Abstract class can have both abstract and _____ methods",
                "Abstract class can have non static, non final fields",
                "While static methods can be _____, final methods can not",
                "RuntimeException and Error are ______ exceptions",
                "Garbage collection runs on ____ memory"
        };
        answers = new String[]{
                "concrete",
                "true",
                "overridden",
                "unchecked",
                "heap"

        };
        currentQuestion = -1;
        answerButton = (Button)findViewById(R.id.AnswerButton);
        questionButton = (Button)findViewById(R.id.QuestionButton);
        questionView = (TextView)
                findViewById(R.id.QuestionTextView);
        answerView = (TextView) findViewById(R.id.AnswerTextView);
        answerText = (EditText) findViewById(R.id.AnswerText);
        answerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer();
            }});

        questionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showQuestion();
            }});
    }

    public void showQuestion()
    {
        currentQuestion++;
        if(currentQuestion == questions.length)
            currentQuestion =0;

        questionView.setText(questions[currentQuestion]);
        answerView.setText("");
        answerText.setText("");
    }

    public boolean isCorrect(String answer)
    {
        return (answer.equalsIgnoreCase(answers[currentQuestion]));
    }

    public void checkAnswer()
    {
        String answer = answerText.getText().toString();
        if(isCorrect(answer))
            answerView.setText("You're right!");
        else
            answerView.setText("Sorry, the correct answer is : " + answers[currentQuestion]);

    }
}
