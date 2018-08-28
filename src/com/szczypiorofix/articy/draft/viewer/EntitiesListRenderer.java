/*
 * Developed by szczypiorofix on 28.08.18 11:39.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;

import com.szczypiorofix.articy.draft.viewer.content.A_Entity;

import javax.swing.*;
import java.awt.*;

public class EntitiesListRenderer implements ListCellRenderer<A_Entity> {

    @Override
    public Component getListCellRendererComponent(JList<? extends A_Entity> list, A_Entity value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = new JLabel(value.displayName);
        label.setOpaque(true);
        if (isSelected) {
            label.setBackground(Color.decode("#74b9ff"));
            label.setForeground(Color.decode("#eeeeee"));
        } else {
            label.setBackground(Color.decode("#dfe6e9"));
            label.setForeground(Color.decode("#444444"));
        }
        return label;
    }
}
