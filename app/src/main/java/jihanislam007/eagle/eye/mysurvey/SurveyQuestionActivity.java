package jihanislam007.eagle.eye.mysurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import jihanislam007.eagle.eye.mysurvey.DB.Model.SurveyQuestion;
import jihanislam007.eagle.eye.mysurvey.DB.Model.UserInfo;
import jihanislam007.eagle.eye.mysurvey.DB.MyApplication;
import jihanislam007.eagle.eye.mysurvey.databinding.ActivitySurveyquestionBinding;

public class SurveyQuestionActivity extends AppCompatActivity {

    ActivitySurveyquestionBinding binding;
    Realm realm;

    Bundle bundle;
    String mobile,
            age,
            gender;
    EditText q1,q2,q3,q4,q5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_surveyquestion);
        binding = DataBindingUtil.setContentView(SurveyQuestionActivity.this, R.layout.activity_surveyquestion);

        realm  = Realm.getDefaultInstance();

        //ToDo get data from userInfo Activity
        bundle = getIntent().getExtras();
        mobile = bundle.getString("mobile");
        age = bundle.getString("age");
        gender = bundle.getString("gender");

        binding.tvMobile.setText(mobile);
        binding.UserTvGender.setText(gender);
        binding.UserTvAge.setText(age);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // SaveData();
               // checkData();
            }


        });

    }

    private void SaveData() {

        String q11 = binding.q1.getText().toString();
        String q22 = binding.q2.getText().toString();
        String q33 = binding.q3.getText().toString();
        String q44 = binding.q4.getText().toString();
        String q55 = binding.q5.getText().toString();

     //   Toast.makeText(this, "this is save button\n"+q11+q22+q33+q44+q55, Toast.LENGTH_SHORT).show();

        MyApplication.getRealm().beginTransaction();

        SurveyQuestion surveyQuestion = new SurveyQuestion();

        surveyQuestion.setUser_Name(mobile);
        surveyQuestion.setUser_Age(age);
        surveyQuestion.setUser_Gender(gender);

        surveyQuestion.setQuestion_one(q11);
        surveyQuestion.setQuestion_two(q22);
        surveyQuestion.setQuestion_three(q33);
        surveyQuestion.setQuestion_four(q44);
        surveyQuestion.setQuestion_five(q55);

        MyApplication.getRealm().copyToRealm(surveyQuestion);
        MyApplication.getRealm().commitTransaction();

        Toast.makeText(SurveyQuestionActivity.this, "Insert successfully ...", Toast.LENGTH_SHORT).show();


    }

    private void checkData() {

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);

        String q11 = q1.getText().toString();
        String q22 = q2.getText().toString();
        String q33 = q3.getText().toString();
        String q44 = q4.getText().toString();
        String q55 = q5.getText().toString();

        Toast.makeText(getApplicationContext(), "Q1 is ok \n"+ q11+q22+q33+q44+q55, Toast.LENGTH_SHORT).show();


        MyApplication.getRealm().beginTransaction();

        UserInfo userInfo = new UserInfo();

        userInfo.setUser_mobile(mobile);
        userInfo.setUser_age(age);
        userInfo.setUser_gender(gender);

        /*userInfo.setQ_one(q11);
        userInfo.setUser_gender(q22);
        userInfo.setUser_gender(q33);
        userInfo.setUser_gender(q44);
        userInfo.setUser_gender(q55);*/

        MyApplication.getRealm().copyToRealm(userInfo);
        MyApplication.getRealm().commitTransaction();

        Toast.makeText(getApplicationContext(), "Insert successfully ...", Toast.LENGTH_SHORT).show();

    }
}
