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

    public TestCaseObject() {
        this.name = "Проверка входа с правильными creds";
        this.summary = "Преверяем возможность логина с верными логином и паролем";
        this.preconditions = "Установлен тест-линк, существует пользователь с логин test пароль test";
        steps = new ArrayList<String>();
        this.addStep("Зайти по адресу localhost/testlink");
        this.addStep("Ввести логин test");
        this.addStep("Ввести пароль test");
        this.addStep("Нажать кнопку войти");
    }

    public TestCaseObject(String name, String summary, String preconditions) {
        this.name = name;
        this.summary = summary;
        this.preconditions = preconditions;
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


}
