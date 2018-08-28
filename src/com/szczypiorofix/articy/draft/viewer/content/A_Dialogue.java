/*
 * Developed by szczypiorofix on 24.08.18 13:36.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer.content;

import java.util.HashMap;

public class A_Dialogue extends A_Object {

    public String text;
    public HashMap<String, A_Pin> pins;
    public int pinCount;

    public A_Dialogue(String id) {
        super(id);
        pins = new HashMap<>();
    }


    public void addPin(A_Pin pin) {
        pins.put(pin.id, pin);
    }

    public A_Pin getPin(String k) {
        return pins.get(k);
    }
}
