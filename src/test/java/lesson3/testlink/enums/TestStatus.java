package lesson3.testlink.enums;

public enum TestStatus {
    NOT_RUN( "Not run", "", "rgb[a]?\\(0, 0, 0, .{1,3}", ""),
    PASSED( "Passed", "p", "rgb[a]?\\(0, 100, 0, .{1,3}", "rgb[a]\\(213, 238, 213, .{1,3})"),
    FAILED("Failed", "f", "rgb[a]?\\(178, 34, 34, .{1,3}", "rgb[a]\\(238, 213, 213, .{1,3})");

    String description;
    String shortName;
    String colorMask;
    String colorMaskInTree;

    TestStatus(String description, String shortName, String colorMask, String colorMaskInTree) {
        this.colorMask = colorMask;
        this.colorMaskInTree = colorMaskInTree;
        this.description = description;
        this.shortName = shortName;
    }

    public static String getTestColorByStatus(String status){
        for (TestStatus ts: TestStatus.values()) {
            if (ts.description.equals(status)) return ts.colorMask;
        }
        return "";
    }

    public static String getTestTreeColorByStatus(String status){
        for (TestStatus ts: TestStatus.values()) {
            if (ts.description.equals(status)) return ts.colorMaskInTree;
        }
        return "";
    }


    public String getDescription() {
        return description;
    }

    public String getShortName() {
        return shortName;
    }

    public String getColorMask() {
        return colorMask;
    }

    public String getColorMaskInTree() {
        return colorMaskInTree;
    }
}

