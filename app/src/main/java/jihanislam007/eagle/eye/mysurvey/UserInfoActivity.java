package jihanislam007.eagle.eye.mysurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.AdapterViewBindingAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmModel;
import jihanislam007.eagle.eye.mysurvey.DB.Model.UserInfo;
import jihanislam007.eagle.eye.mysurvey.DB.MyApplication;
import jihanislam007.eagle.eye.mysurvey.databinding.ActivityUserInfoBinding;

public class UserInfoActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    ActivityUserInfoBinding binding;

    ArrayAdapter aa;
    String[] gender = { "Select your gender","Male", "Female"};

    String user_mobile;
    String user_age;
    String user_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user_info);
        binding = DataBindingUtil.setContentView(UserInfoActivity.this, R.layout.activity_user_info);

        aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.userInfoSpiGender.setAdapter(aa);
        binding.userInfoSpiGender.setOnItemSelectedListener(this);



        binding.userInfoBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Savedata();

            }
        });

        binding.report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),SurveyReportActivity.class));


            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        user_gender = aa.getItem(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void Savedata() {

        user_mobile = binding.userInfoEtMobileNumber.getText().toString();
        user_age = binding.userInfoEtAge.getText().toString();


        //final String user_gender = "gender given".toString().trim();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("mobile", user_mobile);
        intent.putExtra("age", user_age);
        intent.putExtra("gender", user_gender);
        startActivity(intent);

       }


}
