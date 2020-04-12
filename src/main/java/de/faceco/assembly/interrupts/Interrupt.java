package de.faceco.assembly.interrupts;

import java.util.*;

import de.faceco.assembly.components.Register;

public class Interrupt {
  private Map<Integer, Runnable> interrupts = new HashMap<>();
  private static Scanner stdin = new Scanner(System.in);
  
  Interrupt(int name) {
    switch (name) {
      case 0x21:
        interrupts.put(0x01, Interrupt::run01h);
        interrupts.put(0x02, Interrupt::run02h);
        interrupts.put(0x2A, Interrupt::run2Ah);
        interrupts.put(0x4C, Interrupt::run4Ch);
        break;
      default:
        break;
    }
  }
  
  private static void run01h() { // Wait for input single character
    Register.AX.setL((byte) stdin.next().charAt(0));
  }
  
  private static void run02h() { // Print character to STDOUT
    System.out.print((char) Register.DX.l());
  }
  
  private static void run2Ah() { // Get Date
    Calendar c = Calendar.getInstance();
    Register.AX.setL((byte) c.get(Calendar.DAY_OF_WEEK));
    Register.CX.mov((short) c.get(Calendar.YEAR));
    Register.DX.setH((byte) c.get(Calendar.MONTH));
    Register.DX.setL((byte) c.get(Calendar.DAY_OF_MONTH));
  }
  
  private static void run4Ch() { // Terminate with exit code
    System.exit(Register.AX.l());
  }
  
  public void call(int code) {
    interrupts.get(code).run();
  }
  
  public static void main(String[] args) {
    Interrupt int21h = IVT.getInstance().getInterrupt(0x21);
    int21h.call(1);
    Register.DX.setL(Register.AX.l());
    int21h.call(2);
  }
}
