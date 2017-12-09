package com.fisal.fisalquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        RadioGroup question1_answer_group = (RadioGroup) findViewById(R.id.Question1_answer_group);
        // get selected radio button id from radioGroup
        int has_Q1_correct = question1_answer_group.getCheckedRadioButtonId();

        RadioGroup question2_answer_group = (RadioGroup) findViewById(R.id.Question2_answer_group);
        int has_Q2_correct = question2_answer_group.getCheckedRadioButtonId();

        RadioGroup question3_answer_group = (RadioGroup) findViewById(R.id.Question3_answer_group);
        int has_Q3_correct = question3_answer_group.getCheckedRadioButtonId();

        EditText question4_answer = (EditText) findViewById(R.id.Q4_answer);
        // get user text input
        String has_Q4_correct = question4_answer.getText().toString();

        CheckBox q5_A_answer = (CheckBox) findViewById(R.id.Q5_A_answer);
        // Check user answer if he checked the box and assign to boolean
        boolean has_Q5_A_correct = q5_A_answer.isChecked();

        CheckBox q5_B_answer = (CheckBox) findViewById(R.id.Q5_B_answer);
        boolean has_Q5_B_correct = q5_B_answer.isChecked();

        CheckBox q5_C_answer = (CheckBox) findViewById(R.id.Q5_C_answer);
        boolean has_Q5_C_correct = q5_C_answer.isChecked();

        CheckBox q5_D_answer = (CheckBox) findViewById(R.id.Q5_D_answer);
        boolean has_Q5_D_correct = q5_D_answer.isChecked();

        // Calculate the final total grade by sum all quiz answers
        int final_grade_result = calculate_Grades(has_Q1_correct, has_Q2_correct, has_Q3_correct, has_Q4_correct, has_Q5_A_correct, has_Q5_B_correct, has_Q5_C_correct, has_Q5_D_correct);

        // if user answer all quiz Qs he will see success msg and his total grades of 5
        if (final_grade_result == 5) {
            Toast.makeText(MainActivity.this, "You passed the quiz successfully and you got " + final_grade_result + " of 5", Toast.LENGTH_LONG).show();
        }
        // if user fails to answer any quiz Qs he will see unsuccessful msg and his grades smaller than 5 of 5
        else
            Toast.makeText(MainActivity.this, "You did not passed the quiz and you got " + final_grade_result + " of 5" , Toast.LENGTH_LONG).show();


    }

    /**
     * Calculates the price of the order.
     *
     * @param Q1_grade is Question's 1 answer as determined by it's view id.
     * @param Q2_grade is Question's 2 answer as determined by it's view id.
     * @param Q3_grade is Question's 3 answer as determined by it's view id.
     * @param Q4_grade is Question's 4 answer as determined by it's user input.
     * @param Q5_A_grade and B,C,D is Question's 5 answer as determined by it's boolean value.
     * @return grade is total grades calculated from whole quiz.
     */
    private int calculate_Grades(int Q1_grade, int Q2_grade, int Q3_grade, String Q4_grade, boolean Q5_A_grade, boolean Q5_B_grade, boolean Q5_C_grade, boolean Q5_D_grade) {

        // the initial grade as no any right answer
        int grade = 0;

        // check if user select right answer by compare the selected view (radio button) id also same to Q2, Q3
        if (Q1_grade == R.id.Q1_A_answer) {
            grade ++ ;
        }

        if (Q2_grade == R.id.Q2_B_answer) {
            grade ++ ;
        }

        if (Q3_grade == R.id.Q3_C_answer) {
            grade ++ ;
        }

        // check if user enter the right answer by compare the got text to correct answer "google" word regardless to it's case letters.
        if (Q4_grade.equalsIgnoreCase("google") || Q4_grade.equalsIgnoreCase("google.com")) {
            grade ++;
        }

        // check if user select the right checkboxes as all are correct answers even the last one D.
        if ((Q5_A_grade) && (Q5_B_grade) && (Q5_C_grade) || (Q5_D_grade) ) {
            grade ++ ;
        }

        return grade;
    }

}
