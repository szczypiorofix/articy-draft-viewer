/*
 * Developed by szczypiorofix on 24.08.18 13:35.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;



import java.awt.*;


public class ArticyFraftProjectViewer {

    private ArticyFraftProjectViewer() {

//        Path scriptPath = Paths.get("test.js");
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("JavaScript");
//        try {
//            Reader scriptReader = Files.newBufferedReader(scriptPath);
//            engine.eval(scriptReader);
//        } catch (IOException | ScriptException e) {
//            e.printStackTrace();
//        }

        EditorWindow editorWindow = new EditorWindow("Articy Draft Viewer");
        editorWindow.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(ArticyFraftProjectViewer::new);
    }
}
