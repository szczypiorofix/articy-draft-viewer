/*
 * Developed by szczypiorofix on 28.08.18 20:40.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;


import com.szczypiorofix.articy.draft.viewer.content.A_Dialogue;

import javax.swing.*;

public class ArticySimulationButton extends JButton {

    private A_Dialogue dialogue;

    public ArticySimulationButton(A_Dialogue dialogue) {
        super(dialogue.displayName);
        this.dialogue = dialogue;
    }


    public A_Dialogue getDialogue() {
        return dialogue;
    }
}
