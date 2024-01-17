package course.homework_1.test_3;

import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{
    MainClass mainClass = new MainClass();
    @Test
    public void testGetClassString() {
        String string = mainClass.getClassString("Hello, world");
        if (string.contains("Hello")) {
            System.out.println("Contains Hello!");
        } else if (string.contains("hello")) {
            System.out.println("Contains hello!");
        } else {
            Assert.fail("Exception!");
        }

    }

    }

