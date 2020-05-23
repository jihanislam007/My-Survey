package jihanislam007.eagle.eye.mysurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    sleep(5000);
                    /*startActivity(new Intent(getApplicationContext(),
                            MainActivity.class));
                    finish();*/
                    runOnUiThread(new Runnable()
                    {
                        public void run()
                        {
                            //Toast.makeText(getApplicationContext(), "Something", Toast.LENGTH_SHORT).show();
                            if (isConnected()) {
                                //  Toast.makeText(getApplicationContext(), "Internet Connected", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),
                                        LoginActivity.class));
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Please check Internet Connection ...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        };
        thread.start();

    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }
}