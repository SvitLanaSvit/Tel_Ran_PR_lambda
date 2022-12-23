package practice;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String str = """
        Не говори мне о толпе безумной
        Она иной раз вдохновение спугнёт
        Избавь меня от этой давки шумной
        Влекущей мощно в свой водоворот
        Нет тишины ищу я многодумный
        Лишь там поэту радость расцветёт
        Там только там божественною властью
        Любовь и дружба нас приводит к счастью""";

        String[] arrayStr = str.toLowerCase().split("\\P{LD}+");
        System.out.println(Arrays.toString(arrayStr));
        System.out.println((arrayStr.length));
        //Random rnd = new Random();

        List<String> listWord = new ArrayList<>();
        //as RANGE from row 31
//        for (int i = 0; i < 1000; i++) {
//            int index = (int) (Math.random() * 44);
//            listWord.add(arrayStr[index]);
//        }

        IntStream.range(0,1000).forEach(i -> listWord.add(arrayStr[(int)(Math.random() * arrayStr.length)]));

        listWord.forEach(e -> System.out.print(e + " "));

        Map<String, Integer> map = new HashMap<>();
        //as MERGE variant 1
//        for (String word : listWord) {
//            if(!map.containsKey(word)){
//                map.put(word, 1);
//            }
//            else{
//                Integer val = map.get(word);
//                val++;
//                map.put(word, val);
//            }
//        }
        //MERGE throw unanimous class variant 2
//        for (String word : listWord) {
//            map.merge(word, 1, new BiFunction<Integer, Integer, Integer>() {
//                @Override
//                public Integer apply(Integer i1, Integer i2) {
//                    return i2 + i1;
//                }
//            });
//        }

        //MERGE variant 3 with lambda
//        for(String word : listWord){
//            map.merge(word, 1, (i1,i2) -> i1 + i2);
//        }

//        for(String word : listWord){
//            map.merge(word, 1, Integer::sum);
//        }

        //MERGE variant 4 with methode reference
        listWord.forEach(word -> {
            map.merge(word, 1, Integer::sum);
        });

        int sum = 0;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
            sum += m.getValue();
        }

        System.out.println(map.size());
        System.out.println(sum);

        int count = 0;
        for (int i = 0; i < arrayStr.length; i++) {
            if(!listWord.contains(arrayStr[i])){
                count++;
            }
        }

        System.out.println("Count of words which are not exists in list: " + count);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        List<Map.Entry<String,Integer>> listSet = new LinkedList<>(entrySet);

        //Comparator by values and keys from map with unanimous class
//        listSet.sort(new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                int res = o2.getValue() - o1.getValue();
//                if(res == 0)
//                    res = o1.getKey().length() - o2.getKey().length();
//                return res;
//            }
//        });

        listSet.sort((o1,o2) -> {
            int res = o2.getValue() - o1.getValue();
            if(res == 0)
                res = o1.getKey().length() - o2.getKey().length();
            return res;
        });

        for (var l : listSet) {
            System.out.println(l.getKey() + " " + l.getValue());
        }
    }
}
