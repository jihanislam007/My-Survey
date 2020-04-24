package jihanislam007.eagle.eye.mysurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.EditText;

import io.realm.Realm;
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

        //ToDo get data from userInfo Activity
        bundle = getIntent().getExtras();
        mobile = bundle.getString("mobile");
        age = bundle.getString("age");
        gender = bundle.getString("gender");

        binding.tvMobile.setText(mobile);
        binding.UserTvGender.setText(gender);
        binding.UserTvAge.setText(age);

    }
}
