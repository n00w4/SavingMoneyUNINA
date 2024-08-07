package oo.smu.GUI;

import oo.smu.GUI.GUIFrames.LoginFrame;

public class MainController {
    private LoginFrame loginFrame;

    public MainController() {
        this.loginFrame = new LoginFrame(this);
    }

    public void start() {
        // Mostra la finestra di login
        loginFrame.setVisible(true);
    }
}
