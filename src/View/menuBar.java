package View;

import Controller.InvoiceListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBar extends JFrame implements ActionListener {
    InvoiceListener listener = new InvoiceListener();
    private JMenuBar menuBar;
    private JMenu filemenu;
    private JMenuItem save;
    private JMenuItem load;
    public menuBar() throws HeadlessException {
    }
    public JComponent menuBar(){
        menuBar = new JMenuBar();
        save = new JMenuItem("save");
        save.addActionListener(this);
        save.setActionCommand("s");
        load.setActionCommand("l");
        load = new JMenuItem("load");
        load.addActionListener(this);
        filemenu = new JMenu("file");
        filemenu.add(save);
        filemenu.add(load);
        menuBar.add(filemenu);
        menuBar.setVisible(true);
        return menuBar;
    }
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        switch (e.getActionCommand()) {
            case " s":

                    listener.writefile();

                break;
            case "L":
                listener.loadFile(frame);
                break;
        }

    }

}
