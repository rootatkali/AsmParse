package de.faceco.assembly.components;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Token {
  private final String text;
  
  public static final Token MOV = new Token("mov");
  public static final Token ADD = new Token("add");
  public static final Token SUB = new Token("sub");
  public static final Token INC = new Token("inc");
  public static final Token DEC = new Token("dec");
  public static final Token MUL = new Token("mul");
  public static final Token DIV = new Token("div");
  public static final Token INT = new Token("int");
  public static final Token PUSH = new Token("push");
  public static final Token POP = new Token("pop");
  public static final List<Token> COMMANDS = Arrays.asList(MOV, ADD, SUB, INC, DEC, MUL, DIV, INT,
      PUSH, POP);
  
  public Token(String text) {
    this.text = text.toUpperCase(Locale.ROOT);
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Token t = (Token) o;
  
    return text.equals(t.text);
  }
  
  @Override
  public int hashCode() {
    return text.hashCode();
  }
  
  @Override
  public String toString() {
    return text;
  }
}
