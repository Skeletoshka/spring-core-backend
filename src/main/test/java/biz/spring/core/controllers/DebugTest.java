package biz.spring.core.controllers;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Ignore
public class DebugTest {

    @Test
    public void testTest(){
        assertEquals("Hello, world", "Hello, world");
        //assertEquals("Hello, world", "Hello, world1");
    }
}
