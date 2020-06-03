package jihanislam007.eagle.eye.mysurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import jihanislam007.eagle.eye.mysurvey.Adapter.Model.singleSurveyQues;
import jihanislam007.eagle.eye.mysurvey.Adapter.Model.viewPagerDataModel;
import jihanislam007.eagle.eye.mysurvey.Adapter.SingleSurQuesViewPagerAdapter;
import jihanislam007.eagle.eye.mysurvey.Adapter.ViewPagerAdapter;
import jihanislam007.eagle.eye.mysurvey.R;
import jihanislam007.eagle.eye.mysurvey.databinding.ActivitySingleSurveyQuesBinding;

public class SingleSurveyQuesActivity extends AppCompatActivity {

    ActivitySingleSurveyQuesBinding binding;

    ArrayList<singleSurveyQues> singleSurveyQues = new ArrayList<singleSurveyQues>();
    SingleSurQuesViewPagerAdapter viewPagerAdapter;

    int position =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_single_survey_ques);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_single_survey_ques);


        /*ToDo For sliding Image*/
        viewPagerAdapter = new SingleSurQuesViewPagerAdapter(this,singleSurveyQues );
        binding.viewPager.setAdapter(viewPagerAdapter);

        /*Timer timer = new Timer();
        timer.scheduleAtFixedRate(new ViewPagerTimer(), 2000, 6000);*/


        binding.btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.viewPager.setCurrentItem(position++);
            }
        });


        testData();
    }
    private void testData(){
        singleSurveyQues d1 = new singleSurveyQues(0,"1. A line which joins subsidiary stations on the main line is called _____","Tie line","Survey lines","Base lines","Check lines");
        singleSurveyQues.add(d1);

        singleSurveyQues d2 = new singleSurveyQues(0,"2. In which type of surveying only linear measurements are made?","a) Contouring\n","b) Chain surveying","c) Theodolite surveying","d) Dumpy level");
        singleSurveyQues.add(d2);

        singleSurveyQues d3 = new singleSurveyQues(0,"3. A survey station is prominent on the chain line and can be either at the beginning of the chain or at the end. Such stations are known as ______","a) Main station","b) Tie station","c) Subsidiary station","d) Intermediate station");
        singleSurveyQues.add(d3);

        singleSurveyQues d4 = new singleSurveyQues(0,"4. What is laid by joining the apex of the triangle to any point on the opposite side or by joining two points on any two sides of a triangle?","a) Check line","b) Base line","c) Tie line","d) Survey line");
        singleSurveyQues.add(d4);

        singleSurveyQues d5 = new singleSurveyQues(0,"5. The accuracy in the location of the objects depends upon the accuracy in laying the ________","a) Check line","b) Base line","c) Tie line","d) Survey line");
        singleSurveyQues.add(d5);

        singleSurveyQues d6 = new singleSurveyQues(0,"6. A line which joins subsidiary stations on the main line is called _____","Tie line","Survey lines","Base lines","Check lines");
        singleSurveyQues.add(d6);

        singleSurveyQues d7 = new singleSurveyQues(0,"7. In which type of surveying only linear measurements are made?","a) Contouring\n","b) Chain surveying","c) Theodolite surveying","d) Dumpy level");
        singleSurveyQues.add(d7);

        singleSurveyQues d8 = new singleSurveyQues(0,"8. A survey station is prominent on the chain line and can be either at the beginning of the chain or at the end. Such stations are known as ______","a) Main station","b) Tie station","c) Subsidiary station","d) Intermediate station");
        singleSurveyQues.add(d8);

        singleSurveyQues d9 = new singleSurveyQues(0,"9. What is laid by joining the apex of the triangle to any point on the opposite side or by joining two points on any two sides of a triangle?","a) Check line","b) Base line","c) Tie line","d) Survey line");
        singleSurveyQues.add(d9);

        singleSurveyQues d10 = new singleSurveyQues(0,"5. The accuracy in the location of the objects depends upon the accuracy in laying the ________","a) Check line","b) Base line","c) Tie line","d) Survey line");
        singleSurveyQues.add(d10);



        viewPagerAdapter.notifyDataSetChanged();
    }

    /*public class ViewPagerTimer extends TimerTask {

        @Override
        public void run() {

            SingleSurveyQuesActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(binding.viewPager.getCurrentItem()==0){
                        binding.viewPager.setCurrentItem(1);
                    }else if(binding.viewPager.getCurrentItem()==1){
                        binding.viewPager.setCurrentItem(2);
                    }else{
                        binding.viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }*/

    /*private void runOnUiThread(Runnable runnable) {
    }*/


}
