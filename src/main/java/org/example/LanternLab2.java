package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternLab2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        int x = 10;
        int y = 10;
        final char player = 'X';
        boolean continueReadingInput = true;
        terminal.setCursorPosition(x, y);
        terminal.putCharacter(player);

        while (continueReadingInput) {
            KeyStroke keyStroke = terminal.pollInput();
            terminal.flush();
            keyStroke = null;
            do {
                Thread.sleep(5); // might throw InterruptedException
                keyStroke = terminal.pollInput();
            } while (keyStroke == null);
            KeyType type = keyStroke.getKeyType();
            if (type == KeyType.Character) {
                continueReadingInput = false;
                System.out.println("quit");
                terminal.close();
            } else {
                switch (type) {
                    case ArrowDown:
                        terminal.setCursorPosition(x, y += 1);
                        terminal.putCharacter(player);
                        break;
                    case ArrowUp:
                        terminal.setCursorPosition(x, y -= 1);
                        terminal.putCharacter(player);
                        break;
                    case ArrowRight:
                        terminal.setCursorPosition(x += 1, y);
                        terminal.putCharacter(player);
                        break;
                    case ArrowLeft:
                        terminal.setCursorPosition(x -= 1, y);
                        terminal.putCharacter(player);
                        break;
                }
            }
            terminal.flush();
        }
    }
}