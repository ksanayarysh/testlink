package lesson3.testlink.objects;

public class TestPlan {
    private String name = "План тестирования";
    private String description = "Описание плана";
    private boolean publicPlan = true;

    public TestPlan(String name, String description, boolean publicPlan) {
        this.name = name;
        this.description = description;
        this.publicPlan = publicPlan;
    }

    public TestPlan() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublicPlan() {
        return publicPlan;
    }
}
