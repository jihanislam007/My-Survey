package jihanislam007.eagle.eye.mysurvey.Adapter.Model;

public class SurveyReport {

    String report_mobile;
    String report_gender;
    String report_age;

    //String q_one;
    //String q2,q3,q4,q5;

    public SurveyReport() {
    }

    public SurveyReport(String user_mobile, String user_gender, String user_age) {
        this.report_mobile = user_mobile;
        this.report_gender = user_gender;
        this.report_age = user_age;
    }

    /*public SurveyReport(String report_mobile, String report_gender, String report_age, String q_one) {
        this.report_mobile = report_mobile;
        this.report_gender = report_gender;
        this.report_age = report_age;
        this.q_one = q_one;
    }*/

    public String getReport_mobile() {
        return report_mobile;
    }

    public void setReport_mobile(String report_mobile) {
        this.report_mobile = report_mobile;
    }

    public String getReport_gender() {
        return report_gender;
    }

    public void setReport_gender(String report_gender) {
        this.report_gender = report_gender;
    }

    public String getReport_age() {
        return report_age;
    }

    public void setReport_age(String report_age) {
        this.report_age = report_age;
    }

    /*public String getQ_one() {
        return q_one;
    }

    public void setQ_one(String q_one) {
        this.q_one = q_one;
    }*/
}
