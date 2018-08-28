/*
 * Developed by szczypiorofix on 28.08.18 13:09.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;


import com.szczypiorofix.articy.draft.viewer.content.A_FlowFragment;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FlowsDataPanel extends JPanel {

    public FlowsDataPanel() {
        super(true);
    }


    public void updateData(ArticyXMLParser parser) {

        HashMap<String, A_FlowFragment> flowFragments = parser.getFlowFragments();
        setLayout(new GridLayout(flowFragments.size(), 1, 5, 5));
        for (Map.Entry<String, A_FlowFragment> map : flowFragments.entrySet()) {
            add(new JLabel(map.getValue().id +" " +map.getValue().displayName));
        }

    }

}
