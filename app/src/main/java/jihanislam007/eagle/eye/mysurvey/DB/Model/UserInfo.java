package jihanislam007.eagle.eye.mysurvey.DB.Model;

import io.realm.RealmObject;

public class UserInfo extends RealmObject {

    String user_mobile;
    String user_gender;
    String user_age;

    //String q_one;
    //String q2,q3,q4,q5;

    public UserInfo() {
    }

    /*public UserInfo(String user_mobile, String user_gender, String user_age, String q1, String q2, String q3, String q4, String q5) {
        this.user_mobile = user_mobile;
        this.user_gender = user_gender;
        this.user_age = user_age;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
    }*/

    public UserInfo(String user_mobile, String user_gender, String user_age ) {
        this.user_mobile = user_mobile;
        this.user_gender = user_gender;
        this.user_age = user_age;
       // this.q_one = q_one;
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

    /*public String getQ_one() {
        return q_one;
    }

    public void setQ_one(String q_one) {
        this.q_one = q_one;
    }*/

    /*public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }*/
}
