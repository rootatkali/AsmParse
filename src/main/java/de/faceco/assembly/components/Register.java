package de.faceco.assembly.components;

import com.google.common.primitives.Shorts;
import com.google.common.primitives.UnsignedBytes;

public class Register {
  private short value;
  private final boolean canDivide;
  
  public static final Register AX = new Register(true);
  public static final Register BX = new Register(true);
  public static final Register CX = new Register(true);
  public static final Register DX = new Register(true);
  public static final Register SI = new Register(false);
  public static final Register DI = new Register(false);
  public static final Register BP = new Register(false);
  public static final Register SP = Stack.getInstance().sp();
  
  Register(boolean canDivide) {
    this.canDivide = canDivide;
    this.value = 0;
  }
  
  Register(boolean canDivide, short value) {
    this(canDivide);
    this.value = value;
  }
  
  public Register add(short value) {
    this.value += value;
    return this;
  }
  
  public Register sub(short value) {
    this.value -= value;
    return this;
  }
  
  public Register add(Register reg) {
    return add(reg.value);
  }
  
  public Register sub(Register reg) {
    return sub(reg.value);
  }
  
  public Register mov(short value) {
    this.value = value;
    return this;
  }
  
  public Register mov(Register reg) {
    return mov(reg.value);
  }
  
  public short getValue() {
    return value;
  }
  
  public byte h() {
    if (canDivide) {
      return Shorts.toByteArray(value)[0];
    } else {
      throw new RuntimeException("Register cannot divide");
    }
  }
  
  public byte l() {
    if (canDivide) {
      return Shorts.toByteArray(value)[1];
    } else {
      throw new RuntimeException("Register cannot divide");
    }
  }
  
  public Register setH(byte val) {
    if (canDivide) {
      value = (short) (UnsignedBytes.toInt(val) * 256 + l());
    } else {
      throw new RuntimeException("Register cannot divide");
    }
    return this;
  }
  
  public Register setL(byte val) {
    if (canDivide) {
      value = (short) (UnsignedBytes.toInt(val) + h() * 256);
    } else {
      throw new RuntimeException("Register cannot divide");
    }
    return this;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Register r = (Register) o;
  
    return value == r.value;
  }
  
  @Override
  public int hashCode() {
    return value;
  }
}
