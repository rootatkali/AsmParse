package de.faceco.assembly;

public class Token {
  private final String text;
  
  public static final Token MOV = new Token("mov");
  public static final Token ADD = new Token("add");
  public static final Token SUB = new Token("sub");
  public static final Token INC = new Token("inc");
  public static final Token DEC = new Token("dec");
  public static final Token MUL = new Token("mul");
  public static final Token DIV = new Token("div");
  
  public Token(String text) {
    this.text = text.toUpperCase();
  }
  
  public String getText() {
    return text;
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
    return "Token{" + "text='" + text + '\'' + '}';
  }
}
