package de.faceco.assembly.components;

import java.util.ArrayList;
import java.util.List;

public class Stack {
  private List<Short> stack;
  private Register pointer;
  
  private static Stack singleton;
  
  private Stack() {
    stack = new ArrayList<>();
    pointer = new Register(false, (short) 256);
  }
  
  public Stack push(short val) {
    if (stack.size() < 128) {
      stack.add(val);
    } else {
    
    }
    return this;
  }
  
  public static Stack getInstance() {
    if (singleton == null) {
      singleton = new Stack();
    }
    
    return singleton;
  }
  
  public Register sp() {
    return pointer;
  }
}
