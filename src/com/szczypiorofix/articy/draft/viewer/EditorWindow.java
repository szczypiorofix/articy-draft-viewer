/*
 * Developed by szczypiorofix on 26.08.18 00:42.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class EditorWindow extends JFrame {

    private ArticyXMLParser articyXMLParser;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu plikMenu = new JMenu("Projekt");
    private JMenu infoMenu = new JMenu("Info");
    private JMenuItem plikMenuOtworz = new JMenuItem("Otwórz", KeyEvent.VK_O);
    private JMenuItem plikMenuZakoncz = new JMenuItem("Zakończ", KeyEvent.VK_Z);
    private JMenuItem infoMenuInfo = new JMenuItem("Informacje", KeyEvent.VK_I);
    private JFileChooser fc;
    private MainPanel mainPanel;
    private JScrollPane scrollMainPanel;

    public EditorWindow(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        scrollMainPanel = new JScrollPane(mainPanel);
        this.add(scrollMainPanel, BorderLayout.CENTER);

        plikMenuOtworz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
//        plikMenuOtworz.addActionListener(e -> {
//            fc = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
//            fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
//            fc.setDialogTitle("ArticyDraft 3 XML project ");
//            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//            fc.setMultiSelectionEnabled(false);
//            fc.setAcceptAllFileFilterUsed(false);
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("XML file (ArticyDraft 3 export)", "xml");
//            fc.addChoosableFileFilter(filter);
//
//            int returnValue = fc.showOpenDialog(null);
//            if (returnValue == JFileChooser.APPROVE_OPTION) {
//                File selectedFile = fc.getSelectedFile();
//                articyXMLParser = new ArticyXMLParser(selectedFile);
//                mainPanel.updateMainPanel(articyXMLParser);
//            }
//        });

        plikMenuZakoncz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        plikMenuZakoncz.addActionListener(e -> System.exit(0));

        plikMenu.setMnemonic(KeyEvent.VK_P);
        plikMenu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        plikMenu.add(plikMenuOtworz);
        plikMenu.add(plikMenuZakoncz);

        infoMenuInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
        infoMenu.add(infoMenuInfo);
        infoMenu.setMnemonic(KeyEvent.VK_I);

        menuBar.add(plikMenu);
        menuBar.add(infoMenu);
        this.setJMenuBar(menuBar);


        // xxxXXXxxx SKRÓT xxxXXXxxx
        articyXMLParser = new ArticyXMLParser(new File("TestProject.xml"));
        mainPanel.updateMainPanel(articyXMLParser);

    }

}
