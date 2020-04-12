package de.faceco.assembly.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;

public class Statement {
  private Token command;
  private List<Token> operands;
  
  public Statement(List<Token> tokens) throws RuntimeException {
    if (tokens.size() < 2 || tokens.size() > 3) {
      throw new RuntimeException("Invalid statement " + Joiner.on(' ').skipNulls().join(tokens));
    }
    Token head = tokens.get(0);
    if (!Token.COMMANDS.contains(head)) {
      throw new RuntimeException("Invalid command " + head.toString());
    }
    command = head;
    operands = tokens.subList(1, tokens.size());
  }
  
  public Token getCommand() {
    return command;
  }
  
  public List<Token> getOperands() {
    return operands;
  }
  
  @Override
  public String toString() {
    List<Token> t = new ArrayList<>();
    t.add(command);
    t.addAll(operands);
    return Joiner.on(' ').skipNulls().join(t);
  }
}
