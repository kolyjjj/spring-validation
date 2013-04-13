package li.koly.domain;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class guavaPractice {
    public void map(){
        Map<String, Map<Long, List<String>>> map = new HashMap<String, Map<Long, List<String>>>();
        //guava
        Map<String, Map<Long, List<String>>> guavaMap = Maps.newHashMap();
    }

    private void list(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        //guava
        ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");
        ImmutableMap<String, String> map = ImmutableMap.of("key1", "value2", "key2", "value2");
    }

    private void readFile(){
        File file = new File(getClass().getResource("/test.txt").getFile());
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void comparePrimitive(){
        int compare = Ints.compare(1, 3);
        double c = Double.compare(3, 4);
    }

    private void charMatcher(){
        String result89983 = CharMatcher.DIGIT.retainFrom("some text 89983 and more");
        String resultSomeTextAndMore = CharMatcher.DIGIT.removeFrom("some text 89983 and more");
    }

    private void joiner(){
        int[] numbers = {1, 2, 3, 4, 5};
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
    }
}
