package de.faceco.assembly.components;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterTest {
  @Test
  public void testMov() {
    Register ax = Register.AX;
    Register bx = Register.BX;
    ax.add((short) 5);
    bx.add(ax);
    assertEquals(ax, bx);
  }
  
  @Test
  public void testSp() {
    assertNotNull(Register.SP);
    Register.AX.mov((short) 256);
    assertEquals(Register.SP, Register.AX);
//    assertSame(Register.BP, Stack.getInstance().sp()); // Will throw assertion error
  }
}
