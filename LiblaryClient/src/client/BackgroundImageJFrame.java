package client;

import javax.swing.*;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BackgroundImageJFrame extends JFrame {

    JButton b1;
    JLabel l1;

    public BackgroundImageJFrame() {

        setSize(400, 400);
        setVisible(true);

        setLayout(new BorderLayout());
        String path = Paths.get("./src/images/liblary.jpg").toAbsolutePath().toString();
        System.out.println(path);
        JLabel background = new JLabel(new ImageIcon(path));

        add(background);

        background.setLayout(new FlowLayout());

        l1 = new JLabel("Here is a button");
        b1 = new JButton("I am a button");

        background.add(l1);
        background.add(b1);
    }

    public static void main(String args[]) {
        new BackgroundImageJFrame();
    }
}
