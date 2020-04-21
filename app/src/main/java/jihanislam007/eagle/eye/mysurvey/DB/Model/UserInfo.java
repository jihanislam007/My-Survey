package jihanislam007.eagle.eye.mysurvey.DB.Model;

import io.realm.RealmObject;

public class UserInfo extends RealmObject {

    String user_mobile;
    String user_gender;
    String user_age;

    public UserInfo() {
    }

    public UserInfo(String user_mobile, String user_gender, String user_age) {
        this.user_mobile = user_mobile;
        this.user_gender = user_gender;
        this.user_age = user_age;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }
}
