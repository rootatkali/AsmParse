package de.faceco.assembly.interrupts;

import java.util.HashMap;
import java.util.Map;

public class IVT {
  private Map<Integer, Interrupt> table = new HashMap<>();
  private static IVT singleton;
  
  private IVT() {
    table.put(0x21, new Interrupt(0x21));
  }
  
  public Interrupt getInterrupt(int number) {
    return table.get(number);
  }
  
  public static IVT getInstance() {
    if (singleton == null) {
      singleton = new IVT();
    }
    
    return singleton;
  }
}
