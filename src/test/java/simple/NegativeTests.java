import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(AllureJunit5.class)
public class NegativeTests { ... }

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("simple")
public class NegativeTests {
    @Test
    void test1(){
        assertTrue (false);
    }

    @Test
    void test2(){
        assertTrue (false);
    }

    @Test
    void test3(){
        assertTrue (false);
    }

    @Test
    void test4(){
        assertTrue (false);
    }
}

