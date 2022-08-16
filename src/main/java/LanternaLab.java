import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaLab {
    public static void main(String[] args) throws IOException, InterruptedException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();

        terminal.setCursorPosition(12, 14);
        //Then print a character ‘A’ with this line:
        //terminal.putCharacter('A');
        //Then update the terminal with this line:
        terminal.flush();
      /*  for (int column = 4; column < 10; column++) {
            terminal.setCursorPosition(column, 4);
            terminal.putCharacter('X');
        }

        for (int row = 10; row < 20; row++) {
            terminal.setCursorPosition(row, 10);
            terminal.putCharacter('X');
        }*/
        //Task 5
      /*  for (int row = 6; row < 10; row++) {
            terminal.setCursorPosition(20, row); // column 20, diff row 6 to 9
            terminal.putCharacter('Y');
        }*/
        terminal.flush();

        //Task 6

     /*   String s = "This is a String printed out in Lanterna by iterating over the characters";

        for (int i = 0; i < s.length(); i++) {
            terminal.setCursorPosition(i, 10); //same row , diff col (i)
            terminal.putCharacter(s.charAt(i));
        }*/
        terminal.flush();


        for (int row = 3; row < 7; row++) {
            terminal.setCursorPosition(23, row);
            terminal.putCharacter('H');
            terminal.setCursorPosition(25, row);
            terminal.putCharacter('E');
            terminal.setCursorPosition(27, row);
            terminal.putCharacter('L');
            terminal.setCursorPosition(29, row);
            terminal.putCharacter('L');
            terminal.setCursorPosition(31, row);
            terminal.putCharacter('O');
        }
        terminal.flush();

        // Task 7
        //Character c = keyStroke.getCharacter(); // used Character, not char because it might be null
        //KeyStroke keyStroke = terminal.pollInput();

        KeyStroke keyStroke = null;
        Character c = 'r';
        KeyType type = null;

        do {
            do {
                keyStroke = terminal.pollInput(); //input user
                Thread.sleep(5); // might throw InterruptedException
                if (keyStroke != null) {

                    type = keyStroke.getKeyType();
                    if (type == KeyType.Character) {
                        c = keyStroke.getCharacter();
                    }
                    System.out.println(c);
                    System.out.println(type);
                }

            } while (keyStroke == null);
        } while (c != 'q');
    }
}
/*
     terminal.setCursorPosition(12, 14);
     terminal.putCharacter(c);
     terminal.setCursorPosition(13, 14);
     terminal.putCharacter(c);
     terminal.setCursorPosition(14, 14);
     terminal.putCharacter(c);
     terminal.setCursorPosition(15, 14);
     terminal.putCharacter(c);
*/



