package jihanislam007.eagle.eye.mysurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import jihanislam007.eagle.eye.mysurvey.Adapter.Model.viewPagerDataModel;
import jihanislam007.eagle.eye.mysurvey.Adapter.ViewPagerAdapter;
import jihanislam007.eagle.eye.mysurvey.R;
import jihanislam007.eagle.eye.mysurvey.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;
    //ToDo offer viewpager
    ArrayList<viewPagerDataModel> viewPagerDataModels = new ArrayList<viewPagerDataModel>();
    ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_dashboard);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard);

        /*ToDo For sliding Image*/
        viewPagerAdapter = new ViewPagerAdapter(this,viewPagerDataModels );
        binding.viewPager.setAdapter(viewPagerAdapter);

        testData();
     //   run();
       // Timer timer = new Timer();
       // timer.scheduleAtFixedRate(new ViewPagerTimer(), 2000, 6000);

    }

    private void testData(){
        viewPagerDataModel d1 = new viewPagerDataModel(0,"1 ছুটি বাড়ল, ঈদের ছুটিতে থাকতে হবে কর্মস্থলে","https://paloimages.prothom-alo.com/contents/cache/images/640x356x1/uploads/media/2020/01/22/871e0ca922e59881246b6c3f398ad4d5-5e283118a8825.jpg");
        viewPagerDataModels.add(d1);

        viewPagerDataModel d2 = new viewPagerDataModel(2,"2 Bangladesh Team unveiled jersey for World Cup 2019","https://cdn5.newsnation.in/images/2019/04/29/Bang-556495480.jpg");
        viewPagerDataModels.add(d2);

        viewPagerDataModel d3 = new viewPagerDataModel(3,"3 ছুটি বাড়ল, ঈদের ছুটিতে থাকতে হবে কর্মস্থলে","https://paloimages.prothom-alo.com/contents/cache/images/640x356x1/uploads/media/2020/01/22/871e0ca922e59881246b6c3f398ad4d5-5e283118a8825.jpg");
        viewPagerDataModels.add(d3);

        viewPagerDataModel d4 = new viewPagerDataModel(4,"4 Bangladesh Team unveiled jersey for World Cup 2019","https://cdn5.newsnation.in/images/2019/04/29/Bang-556495480.jpg");
        viewPagerDataModels.add(d4);

        viewPagerDataModel d5 = new viewPagerDataModel(5,"5 Bangladesh Team unveiled jersey for World Cup 2019","https://cdn5.newsnation.in/images/2019/04/29/Bang-556495480.jpg");
        viewPagerDataModels.add(d5);

        viewPagerDataModel d6 = new viewPagerDataModel(6,"6 ছুটি বাড়ল, ঈদের ছুটিতে থাকতে হবে কর্মস্থলে","https://paloimages.prothom-alo.com/contents/cache/images/640x356x1/uploads/media/2020/01/22/871e0ca922e59881246b6c3f398ad4d5-5e283118a8825.jpg");
        viewPagerDataModels.add(d6);

        viewPagerDataModel d7 = new viewPagerDataModel(7,"7 Bangladesh Team unveiled jersey for World Cup 2019","https://cdn5.newsnation.in/images/2019/04/29/Bang-556495480.jpg");
        viewPagerDataModels.add(d7);

        viewPagerAdapter.notifyDataSetChanged();
    }

    /*public class ViewPagerTimer extends TimerTask {

        @Override
        public void run() {

            DashboardActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(binding.viewPager.getCurrentItem()==0){
                        binding.viewPager.setCurrentItem(6);
                    }*//*else if(binding.viewPager.getCurrentItem()==1){
                        binding.viewPager.setCurrentItem(2);
                    }else{
                        binding.viewPager.setCurrentItem(0);
                    }*//*
                }
            });

        }
    }*/

    /*private void runOnUiThread(Runnable runnable) {
    }*/


}
