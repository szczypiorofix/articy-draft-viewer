/*
 * Developed by szczypiorofix on 28.08.18 13:45.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;


import com.szczypiorofix.articy.draft.viewer.content.A_Dialogue;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DialoguesDataPanel extends JPanel {

    public DialoguesDataPanel() {
        super(true);

    }

    public void updateData(ArticyXMLParser parser) {
        HashMap<String, A_Dialogue> dialogues = parser.getDialogues();
        setLayout(new GridLayout(dialogues.size(), 1, 5, 5));
        for (Map.Entry<String, A_Dialogue> map : dialogues.entrySet()) {
            add(new JLabel(map.getValue().id +" " +map.getValue().displayName));
        }
    }
}
