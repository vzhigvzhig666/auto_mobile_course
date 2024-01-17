package course.homework_1.test_2;

import org.junit.Test;

public class MainClassTest extends MainClass{
    MainClass mainClass = new MainClass();
    @Test
    public void testGetClassNumber() {
        int number = mainClass.getClassNumber(20);
        if (number > 45) {
            System.out.println("returned bigger than 45!");

        } else {
            System.out.println("returned less than 45!");
        }
    }
}
