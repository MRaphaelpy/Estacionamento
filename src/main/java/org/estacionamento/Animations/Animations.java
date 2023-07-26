package org.estacionamento.Animations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animations extends JFrame {

    public static void carregamento() {
        String[] animationFrames = { "|", "/", "-", "\\" };

        for (int i = 0; i < 10; i++) {
            String frame = animationFrames[i % animationFrames.length];
            System.out.print("\rCarregando " + frame);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
