package br.com.devcompleto;

import java.util.HashMap;
import java.util.Map;

public class MapMerging {
    public static void main(String[] args) {

        // first map author to book
        Map<String, String> firstMap = new HashMap<String, String>();
        firstMap.put("joshbloch", "Joshua");
        firstMap.put("cutting", "Doug");
        firstMap.put("BrianGoetz", "Brian");
        firstMap.put("springrod", "Rod");
        System.out.println("first map: " + firstMap);

        // second map - author to book
        Map<String, String> secondMap = new HashMap<>();
        secondMap.put("joshbloch", "Bloch");
        secondMap.put("mjpt777", "Thompson");
        secondMap.put("springrod", "Johnson");
        secondMap.put("odersky", "Odersky");
        secondMap.put("seriouspony", "Sierra");
        System.out.println("second map: " + secondMap);


        // when you merge map, it would contains mapping
        // from the two maps, but for duplicate keys
        // you have choice. You can specify what do you want
        // to do with values e.g. overwriting or just concatenating them
        // you can choose any map to source and destination
        // for example, in below code, autorToBook map
        // will contain combined value but authorToBook2 will
        // not be changed.
        for (Map.Entry<String, String> entry : secondMap.entrySet()) {
            firstMap.merge(entry.getKey(), entry.getValue(), (v1, v2) -> v1);
        }
        System.out.println("merged with values retained from first map in case of duplicate keys: " + firstMap);


        // you can either use for loop or forEach method to merge two maps
        // here we are keeping value from second map in case of clash of keys
        secondMap.forEach((key, value) -> firstMap.merge(key, value, (v1, v2) -> v2)); 
        System.out.println("merged with values retained from second map in case of duplicate keys: " + firstMap);

        // combining value with a space from both the map if key is same
        secondMap.forEach((key, value) -> firstMap.merge(key, value, (v1, v2) -> (v1 + " " + v2))); 
        System.out.println("merged with values retained from second map in case of duplicate keys: " + firstMap);

        // btw, you can also throw unchecked exception or error in case of 
        // key clash
//        secondMap.forEach((key, value) -> firstMap.merge(key, value, (v1, v2) -> {
//            throw new AssertionError("duplicate values for key: " + key);
//        }));

    }
}
