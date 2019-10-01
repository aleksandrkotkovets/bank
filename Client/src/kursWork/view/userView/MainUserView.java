package kursWork.view.userView;

import kursWork.controller.Controller;


import javax.swing.*;
import java.awt.*;

public class MainUserView extends JFrame {
    public static MainUserView jframe;

    private Controller controller;

    public MainUserView(Controller controller) {
        jframe = this;
        this.setBackground(Color.PINK);
        this.setResizable(false);
        this.controller = controller;
        JOptionPane.showMessageDialog(this, "Разработчик еще не сделал ваше меню!\nОжидайте...");

    }
}
