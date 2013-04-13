package li.koly.domain;

import com.google.common.base.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import com.sun.istack.internal.Nullable;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class guavaPracticeTest {
    
    @Test
    public void should_create_new_map(){
        Map<String, Map<Long, List<String>>> map = new HashMap<String, Map<Long, List<String>>>();
        Map<String, Map<Long, List<String>>> guavaMap = Maps.newHashMap();
    }
    
    @Test
    public void should_create_immutable_list(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        //guava
        ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");
        ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");

    }

    @Ignore
    @Test
    public void should_read_file(){
        File file = new File(getClass().getResource("resources/test.txt").getFile());
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_compare_primitive_types(){
        int compare = Ints.compare(1, 3);
        int result = Doubles.compare(3, 4);

        assertThat(compare, is(-1));
        assertThat(result, is(-1));

    }

    @Test
    public void should_remove_digit_using_charmatcher(){
        assertEquals("89983", CharMatcher.DIGIT.retainFrom("some text 89983 and more"));
        assertEquals("some text  and more", CharMatcher.DIGIT.removeFrom("some text 89983 and more"));
    }

    @Test
    public void should_join_using_joiner(){
        int[] numbers = {1, 2, 3, 4, 5};
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));

        assertThat(numbersAsString, is("1;2;3;4;5"));
    }

    @Test
    public void should_spilt_string_using_splitter(){
        int[] numbers = {1, 2, 3, 4, 5};
        String numbersAsString = Joiner.on(",").join(Ints.asList(numbers));
        Iterable split = Splitter.on(",").split(numbersAsString);

        String splitResult = getSplittedString(split);
        assertThat(splitResult, is("12345"));
    }

    @Test
    public void should_split_string_and_trim(){
        String test = "foo , what,,,more,";
        Iterable<String> split = Splitter.on(",").omitEmptyStrings().trimResults().
                split(test);
        String result = getSplittedString(split);
        assertThat(result, is("foowhatmore"));
    }

    @Test
    public void should_have_basic_operations_for_ints(){
        int[] array = {1, 2, 3, 4, 5};
        int a = 4;
        boolean contains = Ints.contains(array, a);
        int indexOf = Ints.indexOf(array, a);
        int max = Ints.max(array);
        int min = Ints.min(array);
        int[] array1 = {6, 7, 8, 9, 10};
        int[] concat = Ints.concat(array, array1);

        assertThat(contains, is(true));
        assertThat(indexOf, is(3));
        assertThat(max, is(5));
        assertThat(min, is(1));
        assertThat(Joiner.on(",").join(Ints.asList(concat)), is("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_verify(){
        int count = 0;
        if (count < 0){
            throw new IllegalArgumentException("must be positive, " + count);
        }

        Preconditions.checkArgument(count > 0, "must be positive : %s", count);


        Function<String, Integer> testFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(@Nullable String s) {
                return 1;
            }
        };

        addMe(testFunction);
        assertThat(addMe(testFunction), is(2));
    }

    private Integer addMe(Function<String, Integer> function) {
        return function.apply("") + 1;
    }

    private String getSplittedString(Iterable split) {
        String splitResult = "";
        Iterator iterator = split.iterator();
        while (iterator.hasNext()){
            splitResult += iterator.next();
        }
        return splitResult;
    }
}
