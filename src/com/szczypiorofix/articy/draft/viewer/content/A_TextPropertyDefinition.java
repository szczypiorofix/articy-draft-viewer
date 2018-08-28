/*
 * Developed by szczypiorofix on 24.08.18 13:36.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer.content;

public class A_TextPropertyDefinition extends A_Object {

    /**
     * Based on parent property;
     */
    public String basedOn;

    /**
     *
     */
    public boolean isMandatory;

    /**
     *
     */
    public boolean isLocalized;

    /**
     *
     */
    public boolean allowLineBreaks;

    public A_TextPropertyDefinition(String id) {
        super(id);
    }

}
