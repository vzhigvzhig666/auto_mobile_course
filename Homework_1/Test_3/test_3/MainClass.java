package course.homework_1.test_3;

public class MainClass {
    private String classString(String class_string) {
        class_string = "Hello, world";
        return class_string;
    }
    public String getClassString(String string) {
        return this.classString("Hello, world");
    }
}
