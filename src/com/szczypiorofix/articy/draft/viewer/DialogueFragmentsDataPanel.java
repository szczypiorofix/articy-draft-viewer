/*
 * Developed by szczypiorofix on 28.08.18 13:47.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;



import com.szczypiorofix.articy.draft.viewer.content.A_DialogueFragment;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DialogueFragmentsDataPanel extends JPanel {

    public DialogueFragmentsDataPanel() {
        super(true);
    }

    public void updateData(ArticyXMLParser parser) {
        HashMap<String, A_DialogueFragment> dialoguesFragments = parser.getDialoguesFragmens();
        setLayout(new GridLayout(dialoguesFragments.size(), 1, 5, 5));
        for (Map.Entry<String, A_DialogueFragment> map : dialoguesFragments.entrySet()) {
            add(new JLabel(map.getValue().text));
        }
    }
}
