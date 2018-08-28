/*
 * Developed by szczypiorofix on 28.08.18 10:49.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;

import javax.swing.*;
import java.awt.*;

public class EntitiesDataPanel extends JPanel {

    private JPanel dataPanel;
    private JScrollPane dataScrollPane;

    public EntitiesDataPanel() {
        super(true);
        dataPanel = new JPanel();

        dataScrollPane = new JScrollPane(dataPanel);
        dataScrollPane.setViewportBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //dataScrollPane.setPreferredSize(new Dimension(400, 300));
        add(dataScrollPane);
    }

    public void updateData(String name, ArticyXMLParser parser) {

        dataPanel.removeAll();
        GridLayout gridLayout = new GridLayout(5, parser.getEntitiesList().size(), 5, 5);
        dataPanel.setLayout(gridLayout);

        dataPanel.add(new JLabel("ID: "));
        dataPanel.add(new JLabel(parser.getEntitiesList().get(name).id));

        dataPanel.add(new JLabel("Imię: "));
        dataPanel.add(new JLabel(parser.getEntitiesList().get(name).displayName));

        dataPanel.add(new JLabel("Kolor: "));
        dataPanel.add(new JLabel(parser.getEntitiesList().get(name).color));

        dataPanel.add(new JLabel("Technical Name: "));
        dataPanel.add(new JLabel(parser.getEntitiesList().get(name).technicalName));

        dataPanel.add(new JLabel("Teks: "));
        dataPanel.add(new JLabel(parser.getEntitiesList().get(name).text));

        dataPanel.revalidate();
        this.revalidate();
    }
}
