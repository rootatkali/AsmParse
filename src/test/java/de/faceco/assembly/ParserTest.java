package de.faceco.assembly;

import java.util.List;

import de.faceco.assembly.components.Statement;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
  
  @Test
  public void parse() {
    String code = "mov ax,bx\n" +
                  "add ax,5\n" +
                  "int 21h";
  
    List<Statement> st = Parser.parse(code);
    assertEquals(st.toString(), "[MOV AX BX, ADD AX 5, INT 21H]");
  }
}