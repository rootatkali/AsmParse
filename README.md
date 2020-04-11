# AsmParse
A TASM x86-16 Assembly language interpreter written in Java.

## Installing AsmParse
Maven integration is coming soon. For now, you can download a JAR file from Releases, or you can build the artifact yourself.

## Using AsmParse
First, load the code to a String. Then, parse the String code to a list of `Statement`s, using the Parser:

```java
String code = """
mov ax,5
mov bx,3
add ax,bx
""";
List<Statement> statements = Parser.parse(code);
```

After you parsed the statements, you should interpret each on their own, using the `Interpreter` class:

```java
boolean verbose = true; // If verbose is set to true, the interpreter will print every statement in human-readable format
for (Statement s : statements) {
  Interpreter.interpret(s, verbose); // If there's a PRINT interrupt (int 21h [ah = 2h|9h]), it will print to STDOUT
  System.out.println(Register.AX); // The interpreter updates the registers according to the functions.
  Register.printAll(); // Or you can print all of the registers, similarly to TD.
}
```

Support for graphics is currently not available.
