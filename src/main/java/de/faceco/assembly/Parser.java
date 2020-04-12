package de.faceco.assembly;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import de.faceco.assembly.components.Statement;
import de.faceco.assembly.components.Token;
import org.jetbrains.annotations.NotNull;

public class Parser {
   public static List<Statement> parse(@NotNull String code) {
     Splitter tokenSplitter = Splitter.on(CharMatcher.anyOf(", ")).omitEmptyStrings().trimResults();
     List<Statement> ret = new ArrayList<>();
     String[] lines = code.replaceAll("\\n+", "\n").split("\n");
     
     // Remove comments and leading and trailing whitespaces
     for (int i = 0; i < lines.length; i++) {
       lines[i] = lines[i].substring(0,
           lines[i].contains(";") ? lines[i].indexOf(';') : lines[i].length()
       ).strip();
     }
     
     for (String s : lines) {
       if (s.isBlank()) {
         continue;
       }
       
       Iterable<String> keys = tokenSplitter.split(s);
       List<Token> tokens = new ArrayList<>();
       
       for (String key : keys) {
         tokens.add(new Token(key));
       }
       
       ret.add(new Statement(tokens));
     }
     
     return ret;
   }
}
