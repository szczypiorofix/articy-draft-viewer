/*
 * Developed by szczypiorofix on 26.08.18 00:42.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;

import com.szczypiorofix.articy.draft.viewer.content.A_Entity;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainPanel extends JPanel {

    private ArticyXMLParser parser;

    private JPanel northPanel, westPanel, eastPanel, southPanel, centerPanel;
    private JPanel entitiesPanel;
    private FlowsDataPanel flowFragmentsPanel;
    private DialoguesDataPanel  dialoguesPanel;
    private DialogueFragmentsDataPanel dialoguesFragmentsPanel;
    private SimulatePanel simulatePanel;

    private JPanel entitiesPanelList;
    private EntitiesDataPanel entitiesDataPanel;

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JList<A_Entity> entityList;
    private DefaultListModel<A_Entity> defaultEntityListModel;


    public MainPanel() {
        super(new FlowLayout(), true);

//        northPanel = new JPanel();
//        eastPanel = new JPanel();
//        westPanel = new JPanel();
//        southPanel = new JPanel();
        centerPanel = new JPanel();

        flowFragmentsPanel = new FlowsDataPanel();

        entitiesPanel = new JPanel(new BorderLayout());
        entitiesPanelList = new JPanel();
        //entitiesPanelList.setPreferredSize(new Dimension(150, 400));
        entitiesDataPanel = new EntitiesDataPanel();

        dialoguesPanel = new DialoguesDataPanel();

        dialoguesFragmentsPanel = new DialogueFragmentsDataPanel();

        simulatePanel = new SimulatePanel();


        //flowFragmentsPanel.setPreferredSize(new Dimension(500, 400));


        defaultEntityListModel = new DefaultListModel<>();

        entityList = new JList<>(defaultEntityListModel);

        entityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        entityList.setLayoutOrientation(JList.VERTICAL);
        entityList.setCellRenderer(new EntitiesListRenderer());
        //entityList.setMinimumSize(new Dimension(150, 450));

        ListSelectionModel entitySelectionModel = entityList.getSelectionModel();
        entitySelectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                entitiesDataPanel.updateData(entityList.getSelectedValue().id, parser);
            }
        });


        // Entities Panel List
        JScrollPane entitiesListScrollPane = new JScrollPane(entityList);
        entitiesPanelList.add(entitiesListScrollPane);
        entitiesPanel.add(entitiesPanelList, BorderLayout.WEST);
        entitiesPanel.add(entitiesDataPanel, BorderLayout.CENTER);

        tabbedPane.addTab("Simulate!", simulatePanel);
        tabbedPane.addTab("Flows", flowFragmentsPanel);
        tabbedPane.addTab("Entities", entitiesPanel);
        tabbedPane.addTab("Dialogues", dialoguesPanel);
        tabbedPane.addTab("Dialogues Fragmens", dialoguesFragmentsPanel);


        centerPanel.add(tabbedPane);

//        this.add(northPanel, BorderLayout.NORTH);
//        this.add(southPanel, BorderLayout.SOUTH);
//        this.add(westPanel, BorderLayout.WEST);
//        this.add(eastPanel, BorderLayout.EAST);
//        this.add(centerPanel, BorderLayout.CENTER);
        this.add(centerPanel);
    }


    public void updateMainPanel(ArticyXMLParser parser) {
        this.parser = parser;
        flowFragmentsPanel.updateData(parser);
        dialoguesPanel.updateData(parser);
        dialoguesFragmentsPanel.updateData(parser);
        simulatePanel.updateData(parser);
        for (Map.Entry<String, A_Entity> entry : parser.getEntitiesList().entrySet()) {
            defaultEntityListModel.addElement(entry.getValue());
        }
    }

}
