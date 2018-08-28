/*
 * Developed by szczypiorofix on 24.08.18 13:36.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer.content;

public class A_Pin extends A_Object {

    public int index;
    public A_Semantic ASemantic;
    public String expression;

    public A_Pin(String id) {
        super(id);
    }

    public A_Pin(String id, int index, A_Semantic ASemantic, String expression) {
        this(id);
        this.index = index;
        this.ASemantic = ASemantic;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "\nA_Pin{index=" + index + " semantic=" + ASemantic + " id=" + id +"}\n";
    }
}
