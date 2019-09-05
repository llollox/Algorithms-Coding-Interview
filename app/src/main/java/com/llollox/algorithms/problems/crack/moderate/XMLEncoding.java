package com.llollox.algorithms.problems.crack.moderate;

import java.util.HashMap;
import java.util.List;

public class XMLEncoding {

    /*
        Since XML is very verbose,you are given a way of encoding it where each tag gets mapped to a pre-defined integer value.
        The language/grammar is as follows:

        Element --> Tag Attributes END Children END
        Attribute --> Tag Value
        END --> 0
        Tag --> some predefined mapping to int
        Value --> string value

        For example, the following XML might be converted into the compressed string below
        (assuming a mapping of family -> 1, person ->2, firstName -> 3, lastName -> 4, state -> 5).

        <family lastName="McDowell" state="CA">
            <person firstName="Gayle">Some Message</person>
        </family>

        Becomes:
        1 4 McDowell 5 CA 0 2 3 Gayle 0 SomeMessage 0 0
        Write code to print the encoded version of an XML element (passed in Element and Attribute objects).
     */

    public static class Element {
        public String name;
        public HashMap<String, String> attributes;
        public List<Element> children;
        public String value;

        public Element(String name, HashMap<String, String> attributes, List<Element> children, String value) {
            this.name = name;
            this.attributes = attributes;
            this.children = children;
        }
    }

    public String encode(Element element) {
        if (element == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map(element.name)).append(" ");

        for (HashMap.Entry<String, String> entry: element.attributes.entrySet()) {
            String tag = entry.getKey();
            String value = entry.getValue();
            sb.append(map(tag)).append(" ");
            sb.append(value).append(" ");
        }

        sb.append("0 ");

        for (Element el : element.children) {
            sb.append(encode(el)).append(" ");
        }

        sb.append(element.value);

        sb.append("0 ");

        return sb.toString().trim();
    }

    private String map(String s) {
        switch (s) {
            case "family": return "1";
            case "person": return "2";
            case "firstName": return "3";
            case "lastName": return "4";
            case "state": return "5";
            default: throw new RuntimeException("Unrecognized string");
        }
    }


}
