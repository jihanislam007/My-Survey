package jihanislam007.eagle.eye.mysurvey.DB.Model;

import io.realm.RealmObject;

public class SurveyQuestion extends RealmObject {

    String User_Name;
    String User_Age;
    String User_Gender;

    String question_one;
    String question_two;
    String question_three;
    String question_four;
    String question_five;

    public SurveyQuestion() {
    }

    public SurveyQuestion(String user_Name, String user_Age, String user_Gender, String question_one, String question_two,
                          String question_three, String question_four, String question_five) {
        User_Name = user_Name;
        User_Age = user_Age;
        User_Gender = user_Gender;
        this.question_one = question_one;
        this.question_two = question_two;
        this.question_three = question_three;
        this.question_four = question_four;
        this.question_five = question_five;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Age() {
        return User_Age;
    }

    public void setUser_Age(String user_Age) {
        User_Age = user_Age;
    }

    public String getUser_Gender() {
        return User_Gender;
    }

    public void setUser_Gender(String user_Gender) {
        User_Gender = user_Gender;
    }

    public String getQuestion_one() {
        return question_one;
    }

    public void setQuestion_one(String question_one) {
        this.question_one = question_one;
    }

    public String getQuestion_two() {
        return question_two;
    }

    public void setQuestion_two(String question_two) {
        this.question_two = question_two;
    }

    public String getQuestion_three() {
        return question_three;
    }

    public void setQuestion_three(String question_three) {
        this.question_three = question_three;
    }

    public String getQuestion_four() {
        return question_four;
    }

    public void setQuestion_four(String question_four) {
        this.question_four = question_four;
    }

    public String getQuestion_five() {
        return question_five;
    }

    public void setQuestion_five(String question_five) {
        this.question_five = question_five;
    }
}
