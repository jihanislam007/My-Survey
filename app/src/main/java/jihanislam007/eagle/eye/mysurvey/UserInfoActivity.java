package jihanislam007.eagle.eye.mysurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmModel;
import jihanislam007.eagle.eye.mysurvey.DB.Model.UserInfo;
import jihanislam007.eagle.eye.mysurvey.DB.MyApplication;
import jihanislam007.eagle.eye.mysurvey.databinding.ActivityUserInfoBinding;

public class UserInfoActivity extends AppCompatActivity {

    ActivityUserInfoBinding binding;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user_info);
        binding = DataBindingUtil.setContentView(UserInfoActivity.this, R.layout.activity_user_info);

        realm  = Realm.getDefaultInstance();

        binding.userInfoBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Savedata();
                //Toast.makeText(UserInfoActivity.this, "i am ok", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));


            }
        });

    }

    private void Savedata() {

        final String user_mobile = binding.userInfoEtMobileNumber.getText().toString().trim();
        final String user_age = binding.userInfoEtAge.getText().toString().trim();
        final String user_gender = "gender given".toString().trim();

        MyApplication.getRealm().beginTransaction();

        UserInfo userInfo = new UserInfo();
        
        userInfo.setUser_mobile(user_mobile);
        userInfo.setUser_age(user_age);
        userInfo.setUser_gender("Gender");

        MyApplication.getRealm().copyToRealm(userInfo);

        MyApplication.getRealm().commitTransaction();

        Toast.makeText(UserInfoActivity.this, "Insert successfully ...", Toast.LENGTH_SHORT).show();
    }

}
