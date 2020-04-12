package de.faceco.assembly;

import java.util.List;

import com.google.common.base.CharMatcher;
import de.faceco.assembly.components.Stack;
import de.faceco.assembly.components.Statement;
import de.faceco.assembly.components.Token;
import de.faceco.assembly.interrupts.IVT;

public class Interpreter {
  private static Stack stack = Stack.getInstance();
  private static IVT ivt = IVT.getInstance();
  private static CharMatcher digit = CharMatcher.inRange('0', '9');
  private static final String[] REGISTERS = {"AX", "AH", "AL", "BX", "BH", "BL", "CX", "CH", "CL",
      "DX", "DH", "DL", "SI", "DI", "SP", "BP"};
  
  public static void interpret(Statement s, boolean verbose) throws RuntimeException {
    Token cmd = s.getCommand();
    List<Token> op = s.getOperands();
    
    if(cmd.equals(Token.MOV)) {
      // TODO: Implement MOV reg->reg, val->reg, re*->re*,val->re*
    }
  }
  
  private static int parseNum(String in) {
    return Integer.parseInt(in);
  }
  
  public static void interpret(Statement s) throws RuntimeException {
    interpret(s, false);
  }
}
