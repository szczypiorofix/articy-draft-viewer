/*
 * Developed by szczypiorofix on 24.08.18 13:36.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer.content;

import java.util.HashMap;

public class A_FlowFragment extends A_Object {

    public HashMap<String, A_Pin> pins;
    public int pinCount;
    public String text;

    public A_FlowFragment(String id) {
        super(id);
        pins = new HashMap<>();
        pinCount = 0;
    }


    public void addPin(A_Pin pin) {
        pins.put(pin.id, pin);
    }

    public A_Pin getPin(String k) {
        return pins.get(k);
    }

    @Override
    public String toString() {
        return "A_FlowFragment{" +
                ", pinCount=" + pinCount +
                "\npins=\n" + pins +
                "\ntext=" + text +
                ", id=" + id+
                ", displayName=" + displayName + "}";
    }
}
