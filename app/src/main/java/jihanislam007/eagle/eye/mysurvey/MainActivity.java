package jihanislam007.eagle.eye.mysurvey;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import io.realm.Realm;
import jihanislam007.eagle.eye.mysurvey.DB.Model.UserInfo;
import jihanislam007.eagle.eye.mysurvey.DB.MyApplication;
import jihanislam007.eagle.eye.mysurvey.databinding.ActivityMainBinding;
import jihanislam007.eagle.eye.mysurvey.databinding.ActivityUserInfoBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    ActivityMainBinding binding;
    Realm realm;

    Bundle bundle;
    String mobile,
            age,
            gender;
    EditText q1,q2,q3,q4,q5;
    String q11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
      //  binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.content_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        realm  = Realm.getDefaultInstance();

        bundle = getIntent().getExtras();
        mobile = bundle.getString("mobile");
        age = bundle.getString("age");
        gender = bundle.getString("gender");

        //ToDo get data from userInfo Activity
        TextView Umobile = (TextView) findViewById(R.id.tv_mobile);
        TextView Ugender = (TextView) findViewById(R.id.User_tv_gender);
        TextView Uage = (TextView) findViewById(R.id.User_tv_age);
        Umobile.setText(mobile);
        Ugender.setText(gender);
        Uage.setText(age);

        Button btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }


        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*@Override
    public boolean onSupportNavigateUp() {
     //   NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
     //   return NavigationUI.navigateUp(navController, mAppBarConfiguration)|| super.onSupportNavigateUp();
    }*/

    private void SaveData() {

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);

        q11 = q1.getText().toString();
        String q22 = q2.getText().toString();
        String q33 = q3.getText().toString();
        String q44 = q4.getText().toString();
        String q55 = q5.getText().toString();

        Toast.makeText(MainActivity.this, "Q1 is ok \n"+ q11+q22+q33+q44+q55, Toast.LENGTH_SHORT).show();




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

        Toast.makeText(MainActivity.this, "Insert successfully ...", Toast.LENGTH_SHORT).show();

    }
}
