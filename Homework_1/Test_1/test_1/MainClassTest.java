package course.homework_1.test_1;

import org.junit.Test;

public class MainClassTest extends MainClass
{
    MainClass mainclass = new MainClass();
    @Test
    public void testGetLocalNumber() {
        int number = mainclass.getLocalNumber( 14);
        if ( number == 14) {
            System.out.println("Test returned 14, correct!");
        } else
            System.out.println("Test haven't returned 14, incorrect");
    }
}
