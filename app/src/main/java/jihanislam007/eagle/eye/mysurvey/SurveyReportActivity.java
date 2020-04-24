package jihanislam007.eagle.eye.mysurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import jihanislam007.eagle.eye.mysurvey.Adapter.Model.SurveyReport;
import jihanislam007.eagle.eye.mysurvey.Adapter.SurveyReport_Recyclerview_adapter;
import jihanislam007.eagle.eye.mysurvey.DB.Model.UserInfo;
import jihanislam007.eagle.eye.mysurvey.DB.MyApplication;
import jihanislam007.eagle.eye.mysurvey.databinding.ActivitySurveyreportBinding;

import static java.security.AccessController.getContext;

public  class SurveyReportActivity extends AppCompatActivity {

    ActivitySurveyreportBinding binding;
    Realm realm;

    ArrayList<SurveyReport> categoryList = new ArrayList<SurveyReport>();
    SurveyReport_Recyclerview_adapter dashBoard_recyclerview_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_surveyreport);
        binding = DataBindingUtil.setContentView(SurveyReportActivity.this, R.layout.activity_surveyreport);


        binding.RVSurveyReport.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        dashBoard_recyclerview_adapter = new SurveyReport_Recyclerview_adapter(getApplicationContext(),categoryList);
        binding.RVSurveyReport.setAdapter(dashBoard_recyclerview_adapter);

        CategoryDataserver();

    //    retrieveData();

    }

    private void CategoryDataserver() {

        RealmResults<UserInfo> loginModels = MyApplication.getRealm().where(UserInfo.class).findAll();

        realm = Realm.getDefaultInstance();

        for (UserInfo model : loginModels) {
            //   users.setText("");
            /*binding.UserTvMobile.append(model.getUser_mobile() );
            binding.UserTvGender.append(model.getUser_gender() );
            binding.UserTvAge.append(model.getUser_age() + "\n");*/



            SurveyReport data = new SurveyReport(model.getUser_mobile(),model.getUser_gender(),model.getUser_age());
            categoryList.add(data);

            //categoryList.clear();
        }

        /*SurveyReport data1 = new SurveyReport("01234567","male","10");
        categoryList.add(data1);
        SurveyReport data2 = new SurveyReport("01234567","male","11");
        categoryList.add(data2);
        SurveyReport data3 = new SurveyReport("01234567","male","12");
        categoryList.add(data3);
        SurveyReport data4 = new SurveyReport("01234567","male","13");
        categoryList.add(data4);*/


    }

    /*private void retrieveData() {

        RealmResults<UserInfo> loginModels = MyApplication.getRealm().where(UserInfo.class).findAll();

        realm = Realm.getDefaultInstance();

        for (UserInfo model : loginModels) {
            //    users.setText("");
            *//*binding.UserTvMobile.append(model.getUser_mobile() );
            binding.UserTvGender.append(model.getUser_gender() );
            binding.UserTvAge.append(model.getUser_age() + "\n");*//*


        }

    }*/
}