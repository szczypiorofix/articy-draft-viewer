/*
 * Developed by szczypiorofix on 24.08.18 13:36.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer.content;

public class A_Entity extends A_Object {


    public String text;

    public A_Entity(String id) {
        super(id);
    }


    @Override
    public String toString() {
        return "A_Entity{" +
                "text='" + text + '\'' +
                ", id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", technicalName='" + technicalName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
