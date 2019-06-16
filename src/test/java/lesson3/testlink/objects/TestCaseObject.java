package lesson3.testlink.objects;

public class TestCaseObject {
    private String name;
    private String summary;
    private String preconditions;

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
}
