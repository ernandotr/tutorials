package br.com.devcompleto;

import javax.swing.UIManager;

public class ShowLookAndFeelList {
    public static void main(String[] a) {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }
    }
}

