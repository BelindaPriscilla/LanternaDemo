package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
    public class Main {
        public static void main(String[] args) throws IOException, InterruptedException {
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
            Terminal terminal = terminalFactory.createTerminal();
            KeyStroke keyStroke = terminal.pollInput();
            terminal.flush();
            keyStroke = null;
            do {
                Thread.sleep(5); // might throw InterruptedException
                keyStroke = terminal.pollInput();
            } while (keyStroke == null);

            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();
            System.out.println(c);
            System.out.println(type);
            terminal.flush();

      /* String input = "This is a String printed out in Lanterna by iterating over the characters";
        for(int i = 0; i<input.length(); i++){
            terminal.setCursorPosition(i, 0);
            terminal.putCharacter(input.charAt(i));
            terminal.flush();
        }
        /*terminal.putCharacter('G');
        line:terminal.flush();
        for (int row = 4; row < 10; row++) {
            terminal.setCursorPosition(4, row);
            terminal.putCharacter('X');
        }
        line:terminal.flush();*/

        }
    }
