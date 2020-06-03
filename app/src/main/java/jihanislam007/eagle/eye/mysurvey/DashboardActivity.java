package jihanislam007.eagle.eye.mysurvey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Person;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import jihanislam007.eagle.eye.mysurvey.Adapter.Model.viewPagerDataModel;
import jihanislam007.eagle.eye.mysurvey.Adapter.Model.viewPagerOfferDataModel;
import jihanislam007.eagle.eye.mysurvey.Adapter.ViewPagerAdapter;
import jihanislam007.eagle.eye.mysurvey.Adapter.ViewPagerOfferAdapter;
import jihanislam007.eagle.eye.mysurvey.R;
import jihanislam007.eagle.eye.mysurvey.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    /*ToDo Gmail login property*/
    GoogleSignInClient mGoogleSignInClient;
    private GoogleApiClient mGoogleApiClient;
    /*ToDo Gmail login property*/

    ActivityDashboardBinding binding;
    //ToDo offer viewpager
    ArrayList<viewPagerDataModel> viewPagerDataModels = new ArrayList<viewPagerDataModel>();
    ViewPagerAdapter viewPagerAdapter;

    ArrayList<viewPagerOfferDataModel> viewPagerOfferDataModels = new ArrayList<viewPagerOfferDataModel>();
    ViewPagerOfferAdapter viewPagerAdapter_offer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_dashboard);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard);



       /* ToDo Gmail login property*/
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(DashboardActivity.this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();


            binding.name.setText("Name: "+personName);
            binding.email.setText("Email: "+personEmail);
            binding.id.setText("ID: "+ personGivenName+"\n"
                    +personFamilyName+"\n"
                    +personId);

            Glide.with(this).load(personPhoto).into(binding.photo);
        }

        binding.logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
    //}
        /*ToDo Gmail login property*/

        /*ToDo For sliding Image*/
        viewPagerAdapter = new ViewPagerAdapter(this,viewPagerDataModels );
        binding.viewPager.setAdapter(viewPagerAdapter);

        viewPagerAdapter_offer = new ViewPagerOfferAdapter(this,viewPagerOfferDataModels );
        binding.viewPagerOffer.setAdapter(viewPagerAdapter_offer);

        testData();
        testData_offer();
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
    private void testData_offer(){
        viewPagerOfferDataModel d1 = new viewPagerOfferDataModel(0,"1 Wallet Cash-In","https://cdn01.grameenphone.com/sites/default/files/GP_Customer_can_refill_their_GPAY_wallet_from_both_physical_agent_point_and_digital_channels_Desktop_Inner.jpg");
        viewPagerOfferDataModels.add(d1);

        viewPagerOfferDataModel d2 = new viewPagerOfferDataModel(2,"2 Bangladesh Team unveiled jersey for World Cup 2019","https://cdn01.grameenphone.com/sites/default/files/offfers-images/SSC_Result_2020_Tile.jpg");
        viewPagerOfferDataModels.add(d2);

        viewPagerOfferDataModel d3 = new viewPagerOfferDataModel(3,"3 ছুটি বাড়ল, ঈদের ছুটিতে থাকতে হবে কর্মস্থলে","https://cdn01.grameenphone.com/sites/default/files/offfers-images/GP_Bundle_offer_Huawei_Smartphones_Tile.jpg");
        viewPagerOfferDataModels.add(d3);

        viewPagerOfferDataModel d4 = new viewPagerOfferDataModel(4,"4 Bangladesh Team unveiled jersey for World Cup 2019","https://cdn01.grameenphone.com/sites/default/files/offfers-images/Covid_19_Insurance_Coverage_with_GP_Welcome_Tune_Subscription_Tile_Image.jpg");
        viewPagerOfferDataModels.add(d4);

        viewPagerOfferDataModel d5 = new viewPagerOfferDataModel(5,"5 Bangladesh Team unveiled jersey for World Cup 2019","https://cdn01.grameenphone.com/sites/default/files/offfers-images/GP_Operator_Bundle_Offer_tile_image.jpg");
        viewPagerOfferDataModels.add(d5);

        viewPagerOfferDataModel d6 = new viewPagerOfferDataModel(6,"6 ছুটি বাড়ল, ঈদের ছুটিতে থাকতে হবে কর্মস্থলে","https://cdn01.grameenphone.com/sites/default/files/offfers-images/GP_Monthly_Data_Packs_Tile_banner.jpg");
        viewPagerOfferDataModels.add(d6);

        viewPagerOfferDataModel d7 = new viewPagerOfferDataModel(7,"7 Bangladesh Team unveiled jersey for World Cup 2019","https://cdn01.grameenphone.com/sites/default/files/offfers-images/DAKCHE_AMAR_DESH_TILE.jpg");
        viewPagerOfferDataModels.add(d7);

        viewPagerAdapter_offer.notifyDataSetChanged();
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

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(DashboardActivity.this,"Successfully signed out", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
                        finish();
                    }
                });
    }

}
