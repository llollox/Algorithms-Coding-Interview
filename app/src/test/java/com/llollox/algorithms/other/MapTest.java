package com.llollox.algorithms.other;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;

public class MapTest {

    @Test
    public void mapTest() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        Collection<String> values = map.values();
        values.remove("1");
        values.remove("2");
    }
}
