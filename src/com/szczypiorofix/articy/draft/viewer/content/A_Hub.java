/*
 * Developed by szczypiorofix on 28.08.18 22:40.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer.content;

import java.util.HashMap;

public class A_Hub extends A_Object {

    public HashMap<String, A_Pin> pins;
    public int pinCount;

    public A_Hub(String id) {
        super(id);
        pins = new HashMap<>();
    }

    public void addPin(A_Pin pin) {
        pins.put(pin.id, pin);
    }

    public A_Pin getPin(String k) {
        return pins.get(k);
    }

    @Override
    public String toString() {
        return "A_Hub{" +
                "pinCount=" + pinCount +
                ", id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", technicalName='" + technicalName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
