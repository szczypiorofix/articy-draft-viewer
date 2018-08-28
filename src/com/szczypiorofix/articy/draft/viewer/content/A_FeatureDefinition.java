/*
 * Developed by szczypiorofix on 24.08.18 13:36.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer.content;

import java.util.ArrayList;

public class A_FeatureDefinition extends A_Object {


    public int propertyDefinitionsCount;
    public ArrayList<String> propertyDefinitionsRef;

    public A_FeatureDefinition(String id) {
        super(id);
        propertyDefinitionsRef = new ArrayList<>();
    }


}
