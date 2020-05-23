package jihanislam007.eagle.eye.mysurvey.DB;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;

public class MyApplication extends Application{

    private static Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

    }

    public static Realm getRealm(){
        if(realm==null){
            RealmConfiguration realmConfiguration = new RealmConfiguration
                    .Builder()
                    .name("survey_one.realm")
                    .deleteRealmIfMigrationNeeded()
                    .build();
            try {
                realm = Realm.getInstance(realmConfiguration);
            } catch (RealmMigrationNeededException r) {
                Realm.deleteRealm(realmConfiguration);
                realm = Realm.getInstance(realmConfiguration);
            }
        }
        //Log.d("SIMILAR CHANNEL SIZE6","listItems "+(realm==null));
        return realm;
    }

}
