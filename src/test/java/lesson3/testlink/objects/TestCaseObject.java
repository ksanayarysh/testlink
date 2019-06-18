package lesson3.testlink.objects;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.ArrayList;
import java.util.List;

public class TestCaseObject {
    private String name;
    private String summary;
    private String preconditions;
    private List<String> steps;
    private int stepCount = 0;

    public TestCaseObject(String name, String summary, String preconditions) {
        this.name = name;
        this.summary = summary;
        this.preconditions = preconditions;
        steps = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public void addStep(String step){
        steps.add(step);
        stepCount++;
    }

    public String getStep(int id){
        return steps.get(id);
    }

    public int getStepCount() {
        return stepCount;
    }

    //    public List<String> setSteps(){
//        List<String> steps = new ArrayList<String>();
//        steps.add("Зайти по адресу localhost/testlink");
//        steps.add("Ввести логин test");
//        steps.add("Ввести пароль test");
//        steps.add("Нажать кнопку войти");
//        return steps;
//    }


}
