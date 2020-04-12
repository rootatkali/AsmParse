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
  
  public Stack push(short val) throws StackOverflowError {
    if (stack.size() < 128) {
      stack.add(val);
      pointer.sub((short) 2);
    } else {
      throw new StackOverflowError("Assembly stack overflow.");
    }
    return this;
  }
  
  public Stack pop(Register reg) throws RuntimeException {
    if (stack.size() > 0) {
      reg.mov(stack.remove(stack.size() - 1));
      pointer.add((short) 2);
    } else {
      throw new RuntimeException("Empty stack, no data to pop.");
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
