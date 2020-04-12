package de.faceco.assembly.interrupts;

import de.faceco.assembly.components.Register;
import org.junit.Test;

public class InterruptTest {
  
  @Test
  public void testInterrupt() {
    Interrupt int21h = IVT.getInstance().getInterrupt(0x21);
    //int21h.call(1);
    Register.DX.setL((byte) 'R');
    int21h.call(2);
  }
}