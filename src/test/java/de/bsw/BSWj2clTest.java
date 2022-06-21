package de.bsw;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@J2clTestInput(BSWj2clTest.class)
public class BSWj2clTest {

    @Test
    public void someSimpleTest() {
        assertEquals(BSWj2cl.HELLO_WORLD, new BSWj2cl().helloWorldString());
    }
}
