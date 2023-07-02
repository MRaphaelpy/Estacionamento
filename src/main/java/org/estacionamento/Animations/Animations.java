package org.estacionamento.Animations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animations extends JFrame {
    private JLabel label;

    public Animations() {
        setTitle("Volte Sempre Animation");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        label = new JLabel("Volte Sempre!");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        Timer timer = new Timer(500, new ActionListener() {
            private boolean isVisible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                isVisible = !isVisible;
                label.setVisible(isVisible);
            }
        });
        timer.start();
    }

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
    public class TerminalAnimation {
        public static void encerramento()   {
            String[] frames = {
                    "|",
                    "/",
                    "-",
                    "\\"
            };

            int index = 0;
            while (true) {
                System.out.print("\rEncerrando " + frames[index]);
                index = (index + 1) % frames.length;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
