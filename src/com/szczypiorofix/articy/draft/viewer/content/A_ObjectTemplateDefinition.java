/*
 * Developed by szczypiorofix on 24.08.18 13:36.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer.content;

import java.util.ArrayList;

public class A_ObjectTemplateDefinition extends A_Object {

    public int featureDefinitionsCount;
    public ArrayList<String> featureDefinitionRef;

    public A_ObjectTemplateDefinition(String id) {
        super(id);
        featureDefinitionRef = new ArrayList<>();
    }

}
