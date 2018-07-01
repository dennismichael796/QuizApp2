package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startEvaluation(View view) {
        String[] answers = evaluateGui();

        int result = evaluateQuiz(answers);

        toastResult(result);
    }

    public String[] evaluateGui() {
        String[] ret = new String[5];
        EditText editTextQuestion1 = findViewById(R.id.question_1);

        CheckBox checkBoxQuestion2Dennis_Mbevi = findViewById(R.id.question_2_Dennis_Mbevi);
        CheckBox checkBoxQuestion2mark_zuckenberge = findViewById(R.id.question_2_mark_zuckenberge);
        CheckBox checkBoxQuestion2milka_startimes = findViewById(R.id.question_2_milka_startimes);

        Boolean answerQuestion2 = false;

        if (checkBoxQuestion2Dennis_Mbevi.isChecked() == true && checkBoxQuestion2mark_zuckenberge.isChecked() == false && checkBoxQuestion2milka_startimes.isChecked() == true) {
            answerQuestion2 = true;
        }

        CheckBox checkBoxQuestion4sony_20MP = findViewById(R.id.question_4_sony_20MP);
        CheckBox checkBoxQuestion4samsung_13MP = findViewById(R.id.question_4_samsung_13MP);
        CheckBox checkBoxQuestion4infinix_8MP = findViewById(R.id.question_4_infinix_8MP);

        Boolean answerQuestion4 = false;

        Boolean sony_20MP = checkBoxQuestion4sony_20MP.isChecked();
        Boolean samsung_13MP = checkBoxQuestion4samsung_13MP.isChecked();
        Boolean question_4_infinix_8MP = checkBoxQuestion4infinix_8MP.isChecked();


        if (samsung_13MP == false && question_4_infinix_8MP == false && sony_20MP == true) {
            answerQuestion4 = true;
        }

        ret[0] = editTextQuestion1.getText().toString().toLowerCase();
        ret[1] = Boolean.toString(answerQuestion2);
        ret[2] = evaluateRadioGroup(R.id.radio_group_question_3).toLowerCase();
        ret[3] = Boolean.toString(answerQuestion4);
        ret[4] = evaluateRadioGroup(R.id.radio_group_question_5).toLowerCase();

        return ret;
    }

    public int evaluateQuiz(String[] answers) {
        int result = 0;
        String[] correctAnswers = {"css", "true", "android studio", "true", "nairobi"};

        for (int i = 0; i < correctAnswers.length; i++) {
            if (answers[i].equals(correctAnswers[i])) {
                result++;
            }
        }

        return result;
    }

    public void toastResult(int result) {
        String message = result + " out of 5. ";
        Toast reportResult = Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT);
        reportResult.show();
    }

    private String evaluateRadioGroup(int id) {
        RadioGroup radioGroupQuestion;
        RadioButton radioButtonQuestion;

        radioGroupQuestion = findViewById(id);

        int radioButtonId = radioGroupQuestion.getCheckedRadioButtonId();
        radioButtonQuestion = findViewById(radioButtonId);

        if (radioButtonQuestion == null) {
            return "";
        }

        return (String)radioButtonQuestion.getText();
    }

    public void reset(View view) {
        EditText editText = findViewById(R.id.question_1);
        editText.setText("");

        CheckBox checkBox = findViewById(R.id.question_2_Dennis_Mbevi);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_2_mark_zuckenberge);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_2_milka_startimes);
        checkBox.setChecked(false);

        RadioGroup radioGroup = findViewById(R.id.radio_group_question_3);
        radioGroup.clearCheck();

        checkBox = findViewById(R.id.question_4_sony_20MP);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_4_samsung_13MP);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_4_infinix_8MP);
        checkBox.setChecked(false);

        radioGroup = findViewById(R.id.radio_group_question_5);
        radioGroup.clearCheck();
    }
}