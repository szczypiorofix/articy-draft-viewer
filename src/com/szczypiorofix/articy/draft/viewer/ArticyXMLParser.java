/*
 * Developed by szczypiorofix on 24.08.18 13:35.
 * Copyright (c) 2018. All rights reserved.
 *
 */

package com.szczypiorofix.articy.draft.viewer;

import com.szczypiorofix.articy.draft.viewer.content.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ArticyXMLParser {

    private HashMap<String, A_Entity> entitiesList;
    private HashMap<String, A_FlowFragment> flowFragments;
    private HashMap<String, A_Connection> connections;
    private HashMap<String, A_Dialogue> dialogues;
    private HashMap<String, A_DialogueFragment> dialoguesFragmens;
    private HashMap<String, A_Hub> hubs;

    private String startId;
    private String stopId;
    private String currentId;
    private A_State state;


    public ArticyXMLParser(File inputFile) {

        startId = "-1";

        entitiesList = new HashMap<>();
        flowFragments = new HashMap<>();
        connections = new HashMap<>();
        dialogues = new HashMap<>();
        dialoguesFragmens = new HashMap<>();
        hubs = new HashMap<>();

        try {
            parseXML(inputFile);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        //System.out.println(a_hierarchyNode.children.get(0).children.size());


        System.out.println("Entities: ");
        entitiesList.forEach((key, value)
                -> System.out.println(key + " => " + value));
        System.out.println();


        System.out.println("Flow Fragments: ");
        flowFragments.forEach((key, value)
                -> System.out.println(key + " => " + value));
        System.out.println();


        System.out.println("Connections: ");
        connections.forEach((key, value)
                -> System.out.println(
                        key + " => sourceIdRef: " + value.sourceIdRef + " - sourcePinRef: " + value.sourcePinRef
                                + " => targetIdRef: " + value.targetIdRef + " - targetPinRef: " + value.targetPinRef
        ));
        System.out.println();


        System.out.println("Dialogues: ");
        dialogues.forEach((key, value)
                -> System.out.println(key + " => " + value.displayName +", text=" +value.text));
        System.out.println();


        System.out.println("Dialogue Fragments: ");
        dialoguesFragmens.forEach((key, value)
                -> System.out.println(key + " => " + value.text +", menu text: "+value.menuText));
        System.out.println();


        System.out.println("Hubs: ");
        hubs.forEach((key, value)
                -> System.out.println(key + " => " + value));
        System.out.println();



        // #############################
        //System.exit(0);
        // #############################

//
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//        boolean end = false;
//        state = A_State.DIALOGUE;
//
//
//        //startId = dialogues.get("Todd Howard").pins.get("0x0100000000000139").id;
//        //System.out.println(dialogues.get("0x0100000000000136").pins.get("0x0100000000000139").id);
//        startId = dialogues.get("0x0100000000000136").pins.get("0x0100000000000139").id;
//
//        //stopId = flowFragment.pins.get("0x010000000000012A").id;
//
//        System.out.println("Flow from "+startId +" to "+stopId);
//
//        //currentId = startId;
//        currentId = "0x0100000000000136";
//
//        Scanner in = new Scanner(System.in);
//        String[] ids = new String[0];
//        int input;
//        int c;
//
//        do {
//            c = 0;
//            try {
//                Thread.sleep(250);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("Current id: "+currentId);
//
//            if (state == A_State.DIALOGUE) {
//                Set<Map.Entry<String, A_Pin>> flowFragmentEntries = dialogues.get(currentId).pins.entrySet();
//                Iterator<Map.Entry<String, A_Pin>> flowFramentIterator = flowFragmentEntries.iterator();
//                ids = new String[dialogues.get(currentId).pins.size()];
//                while (flowFramentIterator.hasNext()) {
//                    Map.Entry<String, A_Pin> entry = flowFramentIterator.next();
//                    System.out.println("[" +c+"] " + entry.getKey() + " => " + entry.getValue());
//                    ids[c] = entry.getKey();
//                    c++;
//                }
//                state = A_State.CONNECTION;
//            }
//
//
//            if (state == A_State.CONNECTION) {
//                connections.forEach((key, value)
//                        -> {
//                        if (currentId.equalsIgnoreCase(value.sourcePinRef)) {
//                            currentId = value.targetIdRef;
//                            state = A_State.DIALOGUE;
//                            //System.out.println("new current id :" +currentId);
//                        }
//                    }
//                );
//            }
//
//
////            if (state == State.DIALOGUE) {
////                dialogues.forEach((key, value)
////                                -> {
////                            if (key.equalsIgnoreCase(currentId)) {
////                                System.out.println("Dialog :" +key +", " +value.displayName);
////                                System.out.println(value.text);
////
////
////
////                            }
////
////                        }
////                );
////            }
//
//
//            input = in.nextInt();
//
//            if (input >= 0 && input < ids.length) {
//                currentId = ids[input];
//                //System.out.println("New currentId: "+currentId);
//                state = A_State.CONNECTION;
//            }
//            if (input == -1 || currentId.equalsIgnoreCase(stopId)) end = true;
//
//
//
//
//
////                    Set<Map.Entry<String, A_Pin>> employeeSalaryEntries = flowFragments.get(currentId).pins.entrySet();
////                    Iterator<Map.Entry<String, A_Pin>> employeeSalaryIterator = employeeSalaryEntries.iterator();
////
////                    ids = new String[flowFragments.get(currentId).pins.size()];
////
////                    while (employeeSalaryIterator.hasNext()) {
////                        Map.Entry<String, A_Pin> entry = employeeSalaryIterator.next();
////                        System.out.println("[" +c+"] " + entry.getKey() + " => " + entry.getValue());
////                        ids[c] = entry.getKey();
////                        c++;
////                    }
////                    Integer i = in.nextInt();
////                    if (i == -1 || currentId.equalsIgnoreCase(stopId)) end = true;
////
////                    if (i < ids.length && i >= 0) {
////                        currentId = ids[i];
////                        state = State.CONNECTION;
////                    }
//
//
//
//        } while (!end);
//

    }


    private void parseXML(File inputFile) throws ParserConfigurationException, IOException, SAXException {
        //InputStream inputFile = getClass().getResourceAsStream("/quests/"+name);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList exportList = doc.getElementsByTagName("Export");
        for (int export = 0; export < exportList.getLength(); export++) {
            Node exportNode = exportList.item(export);
            if (exportNode.getNodeType() == Node.ELEMENT_NODE) {
                Element exportElement = (Element) exportNode;


                // ####################### Content
                NodeList contentList = exportElement.getElementsByTagName("Content");
                for (int content = 0; content < contentList.getLength(); content++) {
                    Node contentNode = exportList.item(content);
                    if (contentNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element contentElement = (Element) contentNode;



                        // ################ ENTITY ################
                        NodeList entityList = contentElement.getElementsByTagName("Entity");
                        for (int entity = 0; entity < entityList.getLength(); entity++) {
                            Node entityNode = entityList.item(entity);
                            if (entityNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element entityElement = (Element) entityNode;

                                A_Entity a_entity = new A_Entity(entityElement.getAttribute("Id"));

                                // DisplayName
                                NodeList displayNameList = entityElement.getElementsByTagName("DisplayName");
                                for (int dn = 0; dn < displayNameList.getLength(); dn++) {
                                    Node dnNode = displayNameList.item(dn);
                                    if (dnNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element dnElement = (Element) dnNode;
                                        NodeList localizedStringNameList = dnElement.getElementsByTagName("LocalizedString");
                                        for (int ls = 0; ls < localizedStringNameList.getLength(); ls++) {
                                            Node lsNode = localizedStringNameList.item(ls);
                                            if (lsNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element lsElement = (Element) lsNode;
                                                a_entity.displayName = lsElement.getTextContent().trim();
                                            }
                                        }
                                    }
                                }

                                // Text
                                NodeList textList = entityElement.getElementsByTagName("Text");
                                for (int tn = 0; tn < textList.getLength(); tn++) {
                                    Node textNode = textList.item(tn);
                                    if (textNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element textElement = (Element) textNode;
                                        NodeList localizedStringNameList = textElement.getElementsByTagName("LocalizedString");
                                        for (int ls = 0; ls < localizedStringNameList.getLength(); ls++) {
                                            Node lsNode = localizedStringNameList.item(ls);
                                            if (lsNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element lsElement = (Element) lsNode;
                                                a_entity.text = lsElement.getTextContent().trim();
                                            }
                                        }
                                    }
                                }

                                // Color
                                NodeList colorList = entityElement.getElementsByTagName("Color");
                                for (int cn = 0; cn < colorList.getLength(); cn++) {
                                    Node colorNode = colorList.item(cn);
                                    if (colorNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element colorElement = (Element) colorNode;
                                        a_entity.color = colorElement.getTextContent().trim();
                                    }
                                }

                                // Technical Name
                                NodeList technicalNameList = entityElement.getElementsByTagName("TechnicalName");
                                for (int cn = 0; cn < technicalNameList.getLength(); cn++) {
                                    Node colorNode = technicalNameList.item(cn);
                                    if (colorNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element colorElement = (Element) colorNode;
                                        a_entity.technicalName = colorElement.getTextContent().trim();
                                    }
                                }

                                entitiesList.put(a_entity.id, a_entity);
                            }
                        }


                        // ################ FLOW FRAGMENT ################
                        NodeList flowFragmentList = contentElement.getElementsByTagName("FlowFragment");
                        for (int ff = 0; ff < flowFragmentList.getLength(); ff++) {
                            Node ffNode = flowFragmentList.item(ff);
                            if (ffNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element ffElement = (Element) ffNode;

                                A_FlowFragment a_flowFragment = new A_FlowFragment(ffElement.getAttribute("Id"));

                                // DisplayName
                                NodeList displayNameList = ffElement.getElementsByTagName("DisplayName");
                                for (int dn = 0; dn < displayNameList.getLength(); dn++) {
                                    Node dnNode = displayNameList.item(dn);
                                    if (dnNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element dnElement = (Element) dnNode;
                                        NodeList localizedStringNameList = dnElement.getElementsByTagName("LocalizedString");
                                        for (int ls = 0; ls < localizedStringNameList.getLength(); ls++) {
                                            Node lsNode = localizedStringNameList.item(ls);
                                            if (lsNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element lsElement = (Element) lsNode;
                                                a_flowFragment.displayName = lsElement.getTextContent().trim();
                                            }
                                        }
                                    }
                                }

                                // Text
                                NodeList textNameList = ffElement.getElementsByTagName("Text");
                                for (int tn = 0; tn < textNameList.getLength(); tn++) {
                                    Node tNode = textNameList.item(tn);
                                    if (tNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element tElement = (Element) tNode;
                                        NodeList localizedStringNameList = tElement.getElementsByTagName("LocalizedString");
                                        for (int ls = 0; ls < localizedStringNameList.getLength(); ls++) {
                                            Node lsNode = localizedStringNameList.item(ls);
                                            if (lsNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element lsElement = (Element) lsNode;
                                                a_flowFragment.text = lsElement.getTextContent().trim();
                                            }
                                        }
                                    }
                                }

                                // Pins
                                NodeList pinsList = ffElement.getElementsByTagName("Pins");
                                for (int pn = 0; pn < pinsList.getLength(); pn++) {
                                    Node pinsNode = pinsList.item(pn);
                                    if (pinsNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element pinsElement = (Element) pinsNode;

                                        a_flowFragment.pinCount = Integer.parseInt(pinsElement.getAttribute("Count"));

                                        NodeList pinList = pinsElement.getElementsByTagName("Pin");
                                        for (int p = 0; p < pinList.getLength(); p++) {
                                            Node pNode = pinList.item(p);
                                            if (pNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element pinElement = (Element) pNode;

                                                A_Semantic s;
                                                if (pinElement.getAttribute("Semantic").equalsIgnoreCase("Input"))
                                                    s = A_Semantic.INPUT;
                                                else s = A_Semantic.OUTPUT;

                                                A_Pin a_pin = new A_Pin(
                                                        pinElement.getAttribute("Id"),
                                                        Integer.parseInt(pinElement.getAttribute("Index")),
                                                        s,
                                                        pinElement.getAttribute("Expression")
                                                );
                                                a_flowFragment.addPin(a_pin);
                                            }
                                        }
                                    }
                                }
                                flowFragments.put(ffElement.getAttribute("Id"), a_flowFragment);
                            }
                        }


                        // ################ CONNECTION ################
                        NodeList connectionsList = contentElement.getElementsByTagName("Connection");
                        for (int cn = 0; cn < connectionsList.getLength(); cn++) {
                            Node connectionsNode = connectionsList.item(cn);
                            if (connectionsNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element connectionsElement = (Element) connectionsNode;

                                A_Connection a_connection = new A_Connection(connectionsElement.getAttribute("Id"));

                                NodeList sourceList = connectionsElement.getElementsByTagName("Source");
                                for (int sl = 0; sl < sourceList.getLength(); sl++) {
                                    Node sourceNode = sourceList.item(sl);
                                    if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element sourceElement = (Element) sourceNode;
                                        a_connection.sourceIdRef = sourceElement.getAttribute("IdRef");
                                        a_connection.sourcePinRef = sourceElement.getAttribute("PinRef");
                                    }
                                }

                                NodeList targetList = connectionsElement.getElementsByTagName("Target");
                                for (int tl = 0; tl < targetList.getLength(); tl++) {
                                    Node targetNode = targetList.item(tl);
                                    if (targetNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element targetElement = (Element) targetNode;
                                        a_connection.targetIdRef = targetElement.getAttribute("IdRef");
                                        a_connection.targetPinRef = targetElement.getAttribute("PinRef");
                                    }
                                }
                                connections.put(a_connection.id, a_connection);
                            }
                        }



                        // ################ DIALOGUE ################
                        NodeList dialogueList = contentElement.getElementsByTagName("Dialogue");
                        for (int dl = 0; dl < dialogueList.getLength(); dl++) {
                            Node dialogueNode = dialogueList.item(dl);
                            if (dialogueNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element dialogueElement = (Element) dialogueNode;

                                A_Dialogue a_dialogue = new A_Dialogue(dialogueElement.getAttribute("Id"));

                                // DisplayName
                                NodeList displayNameList = dialogueElement.getElementsByTagName("DisplayName");
                                for (int dn = 0; dn < displayNameList.getLength(); dn++) {
                                    Node dnNode = displayNameList.item(dn);
                                    if (dnNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element dnElement = (Element) dnNode;
                                        NodeList localizedStringNameList = dnElement.getElementsByTagName("LocalizedString");
                                        for (int ls = 0; ls < localizedStringNameList.getLength(); ls++) {
                                            Node lsNode = localizedStringNameList.item(ls);
                                            if (lsNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element lsElement = (Element) lsNode;
                                                a_dialogue.displayName = lsElement.getTextContent().trim();
                                            }
                                        }
                                    }
                                }

                                // Text
                                NodeList textList = dialogueElement.getElementsByTagName("Text");
                                for (int tn = 0; tn < textList.getLength(); tn++) {
                                    Node tNode = textList.item(tn);
                                    if (tNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element tElement = (Element) tNode;
                                        NodeList localizedStringNameList = tElement.getElementsByTagName("LocalizedString");
                                        for (int ls = 0; ls < localizedStringNameList.getLength(); ls++) {
                                            Node lsNode = localizedStringNameList.item(ls);
                                            if (lsNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element lsElement = (Element) lsNode;
                                                a_dialogue.text = lsElement.getTextContent().trim();
                                            }
                                        }
                                    }
                                }

                                // Pins
                                NodeList pinsList = dialogueElement.getElementsByTagName("Pins");
                                for (int pn = 0; pn < pinsList.getLength(); pn++) {
                                    Node pinsNode = pinsList.item(pn);
                                    if (pinsNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element pinsElement = (Element) pinsNode;

                                        a_dialogue.pinCount = Integer.parseInt(pinsElement.getAttribute("Count"));

                                        NodeList pinList = pinsElement.getElementsByTagName("Pin");
                                        for (int p = 0; p < pinList.getLength(); p++) {
                                            Node pNode = pinList.item(p);
                                            if (pNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element pinElement = (Element) pNode;

                                                A_Semantic s;
                                                if (pinElement.getAttribute("Semantic").equalsIgnoreCase("Input"))
                                                    s = A_Semantic.INPUT;
                                                else s = A_Semantic.OUTPUT;

                                                A_Pin a_pin = new A_Pin(
                                                        pinElement.getAttribute("Id"),
                                                        Integer.parseInt(pinElement.getAttribute("Index")),
                                                        s,
                                                        pinElement.getAttribute("Expression")
                                                );
                                                a_dialogue.addPin(a_pin);
                                            }
                                        }
                                    }
                                }

                                dialogues.put(a_dialogue.id, a_dialogue);
                            }
                        }


                        // ################ DIALOGUE FRAGMENTS ################
                        NodeList dialogueFragmentsList = contentElement.getElementsByTagName("DialogueFragment");
                        for (int df = 0; df < dialogueFragmentsList.getLength(); df++) {
                            Node dialogueFragmentsNode = dialogueFragmentsList.item(df);
                            if (dialogueFragmentsNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element dialogueFragmentsNodeElement = (Element) dialogueFragmentsNode;

                                A_DialogueFragment a_dialogueFragment = new A_DialogueFragment(dialogueFragmentsNodeElement.getAttribute("Id"));

                                // Text
                                NodeList displayNameList = dialogueFragmentsNodeElement.getElementsByTagName("Text");
                                for (int dn = 0; dn < displayNameList.getLength(); dn++) {
                                    Node dnNode = displayNameList.item(dn);
                                    if (dnNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element dnElement = (Element) dnNode;
                                        NodeList localizedStringNameList = dnElement.getElementsByTagName("LocalizedString");
                                        for (int ls = 0; ls < localizedStringNameList.getLength(); ls++) {
                                            Node lsNode = localizedStringNameList.item(ls);
                                            if (lsNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element lsElement = (Element) lsNode;
                                                a_dialogueFragment.text = lsElement.getTextContent().trim();
                                            }
                                        }
                                    }
                                }


                                // Menu text
                                NodeList menuTextList = dialogueFragmentsNodeElement.getElementsByTagName("MenuText");
                                for (int dn = 0; dn < menuTextList.getLength(); dn++) {
                                    Node mtNode = menuTextList.item(dn);
                                    if (mtNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element mtElement = (Element) mtNode;
                                        NodeList localizedStringNameList = mtElement.getElementsByTagName("LocalizedString");
                                        for (int ls = 0; ls < localizedStringNameList.getLength(); ls++) {
                                            Node lsNode = localizedStringNameList.item(ls);
                                            if (lsNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element lsElement = (Element) lsNode;
                                                a_dialogueFragment.menuText = lsElement.getTextContent().trim();
                                            }
                                        }
                                    }
                                }

                                // Speaker IdRef
                                NodeList speakerList = dialogueFragmentsNodeElement.getElementsByTagName("Speaker");
                                for (int sl = 0; sl < speakerList.getLength(); sl++) {
                                    Node sNode = speakerList.item(sl);
                                    if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element sElement = (Element) sNode;
                                        a_dialogueFragment.speakerIdRef = sElement.getAttribute("IdRef");
                                    }
                                }

                                // Pins
                                NodeList pinsList = dialogueFragmentsNodeElement.getElementsByTagName("Pins");
                                for (int pn = 0; pn < pinsList.getLength(); pn++) {
                                    Node pinsNode = pinsList.item(pn);
                                    if (pinsNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element pinsElement = (Element) pinsNode;

                                        a_dialogueFragment.pinCount = Integer.parseInt(pinsElement.getAttribute("Count"));

                                        NodeList pinList = pinsElement.getElementsByTagName("Pin");
                                        for (int p = 0; p < pinList.getLength(); p++) {
                                            Node pNode = pinList.item(p);
                                            if (pNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element pinElement = (Element) pNode;

                                                A_Semantic s;
                                                if (pinElement.getAttribute("Semantic").equalsIgnoreCase("Input"))
                                                    s = A_Semantic.INPUT;
                                                else s = A_Semantic.OUTPUT;

                                                A_Pin a_pin = new A_Pin(
                                                        pinElement.getAttribute("Id"),
                                                        Integer.parseInt(pinElement.getAttribute("Index")),
                                                        s,
                                                        pinElement.getAttribute("Expression")
                                                );
                                                a_dialogueFragment.addPin(a_pin);
                                            }
                                        }
                                    }
                                }
                                dialoguesFragmens.put(a_dialogueFragment.id, a_dialogueFragment);
                            }
                        }



                        // ################ HUB ################
                        NodeList hubList = contentElement.getElementsByTagName("Hub");
                        for (int df = 0; df < hubList.getLength(); df++) {
                            Node hubNode = hubList.item(df);
                            if (hubNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element hubElement = (Element) hubNode;

                                A_Hub a_hub = new A_Hub(hubElement.getAttribute("Id"));

                                // Pins
                                NodeList pinsList = hubElement.getElementsByTagName("Pins");
                                for (int pn = 0; pn < pinsList.getLength(); pn++) {
                                    Node pinsNode = pinsList.item(pn);
                                    if (pinsNode.getNodeType() == Node.ELEMENT_NODE) {
                                        Element pinsElement = (Element) pinsNode;

                                        a_hub.pinCount = Integer.parseInt(pinsElement.getAttribute("Count"));

                                        NodeList pinList = pinsElement.getElementsByTagName("Pin");
                                        for (int p = 0; p < pinList.getLength(); p++) {
                                            Node pNode = pinList.item(p);
                                            if (pNode.getNodeType() == Node.ELEMENT_NODE) {
                                                Element pinElement = (Element) pNode;

                                                A_Semantic s;
                                                if (pinElement.getAttribute("Semantic").equalsIgnoreCase("Input"))
                                                    s = A_Semantic.INPUT;
                                                else s = A_Semantic.OUTPUT;

                                                A_Pin a_pin = new A_Pin(
                                                        pinElement.getAttribute("Id"),
                                                        Integer.parseInt(pinElement.getAttribute("Index")),
                                                        s,
                                                        pinElement.getAttribute("Expression")
                                                );
                                                a_hub.addPin(a_pin);
                                            }
                                        }
                                    }
                                }
                                hubs.put(a_hub.id, a_hub);
                            }
                        }
                    }
                }


                // ###################################  Hierarchy
                NodeList hierarchyList = exportElement.getElementsByTagName("Hierarchy");
                for (int i = 0; i < hierarchyList.getLength(); i++) {
                    Node hierarchyListNode = hierarchyList.item(i);
                    if (hierarchyListNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element hierarchyListElement = (Element) hierarchyListNode;

                        A_HierarchyNode a_hierarchyNode = new A_HierarchyNode();
                        a_hierarchyNode.type = hierarchyListElement.getAttribute("Type");
                        a_hierarchyNode.IdRef = hierarchyListElement.getAttribute("IdRef");
                        parseHierarchy(a_hierarchyNode, hierarchyListElement);
                    }
                }
            }
        }
    }

    private void parseHierarchy(A_HierarchyNode node, final Element e) {
        final NodeList children = e.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            final Node n = children.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) n;
                A_HierarchyNode aNode = new A_HierarchyNode();
                aNode.type = el.getAttribute("Type");
                aNode.IdRef = el.getAttribute("IdRef");
                node.children.add(aNode);
                //System.out.println(n.getNodeName()+", IdRef: "+el.getAttribute("IdRef"));
                parseHierarchy(aNode, (Element) n);
            }
        }
    }

    public HashMap<String, A_Entity> getEntitiesList() {
        return entitiesList;
    }

    public HashMap<String, A_FlowFragment> getFlowFragments() {
        return flowFragments;
    }

    public HashMap<String, A_Connection> getConnections() {
        return connections;
    }

    public HashMap<String, A_Dialogue> getDialogues() {
        return dialogues;
    }

    public HashMap<String, A_DialogueFragment> getDialoguesFragmens() {
        return dialoguesFragmens;
    }

    public HashMap<String, A_Hub> getHubs() {
        return hubs;
    }
}
