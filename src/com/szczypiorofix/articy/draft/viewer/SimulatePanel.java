/*
 * Developed by szczypiorofix on 28.08.18 14:44.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;


import com.szczypiorofix.articy.draft.viewer.content.A_Dialogue;
import com.szczypiorofix.articy.draft.viewer.content.A_State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SimulatePanel extends JPanel implements ActionListener {

    private JPanel dataPanel, buttonsPanel;
    private JButton nextButton;
    private boolean dialogueChosen = false;
    private String currentId;
    private A_State state;
    private ArticyXMLParser parser;

    public SimulatePanel() {
        super(new BorderLayout(), true);
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        nextButton.setEnabled(dialogueChosen);

        buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(nextButton);

        state = A_State.DIALOGUE;

        dataPanel = new JPanel();

        add(dataPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void nextStep() {
        dataPanel.removeAll();
        dataPanel.revalidate();
        System.out.println(currentId);
    }

    public void updateData(ArticyXMLParser parser) {
        this.parser = parser;
        HashMap<String, A_Dialogue> dialogues = parser.getDialogues();
        setLayout(new GridLayout(dialogues.size(), 1, 5, 5));

        dataPanel.setLayout(new GridLayout(dialogues.size(), 1, 10, 10));

        for (Map.Entry<String, A_Dialogue> map : dialogues.entrySet()) {
            ArticySimulationButton b = new ArticySimulationButton(map.getValue());
            b.addActionListener(e -> {
                ArticySimulationButton source = (ArticySimulationButton) e.getSource();
                dialogueChosen = true;
                currentId = source.getDialogue().id;
                nextButton.setEnabled(dialogueChosen);
                nextStep();
            });
            dataPanel.add(b);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(currentId);

        if (state == A_State.DIALOGUE) {
            //currentId = parser.getDialogues().get(currentId).pins.get
        }

    }
}
