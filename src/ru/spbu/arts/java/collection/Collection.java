package ru.spbu.arts.java.collection;

import java.io.*;
import java.util.*;

public class Collection {
    public static void main(String[] args){
        System.out.println(count(5));

        List<String> list1 = List.of("abc", "xyz", "ooo");
        printList(list1);

        List<String> list2 = List.of("abc", "xyz", "ooo");
        printListWithIndices(list2);

        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4);

        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        List<String> list5rev = reverseList(list5);
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);

        reverseListInPlace(list5);
        System.out.println("list5 = " + list5);

        List<Integer> ints = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);

        System.out.println("ints = " + ints);
        System.out.println("ints no even indices = " + filterEvenIndices(ints));
        System.out.println("ints without even = " + filterEven(ints));

        System.out.println(" ============= mutable lists =================== ");

        List<Integer> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts);

        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts);

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        doReadWordsInFile("C:/Users/79218/.1Kate/Java/java 3 sem/src/ru/spbu/arts/java/collection/text.txt", hashSet);
        doReadWordsInFile("C:/Users/79218/.1Kate/Java/java 3 sem/src/ru/spbu/arts/java/collection/text.txt", linkedHashSet);
        doReadWordsInFile("C:/Users/79218/.1Kate/Java/java 3 sem/src/ru/spbu/arts/java/collection/text.txt", treeSet);
    }

    public static List<Integer> count(int n){
        List<Integer>  a = new ArrayList<>();
        for (int x = 1; x <= n; x++)
            a.add(x);
        return a;
    }

    public static void printList(List<String> list1){
        System.out.printf("Элементов в списке: %d\n", list1.size());
        for (String x:list1)
            System.out.println(x);
    }

    public static void printListWithIndices(List<String> list2){
        int i = 1;
        System.out.printf("Элементов в списке: %d\n", list2.size());
        for (String x:list2){
            System.out.printf("%d: %s\n",i, x);
            i++;
        }
    }

    public static List<String> concatenateLists(List<String> list3, List<String> list4){
        List<String> list3plusList4 = new ArrayList<>();
        list3plusList4.addAll(list3);
        list3plusList4.addAll(list4);
        return list3plusList4;
    }

    public static List<String> reverseList(List<String> list5){
        List<String> list5rev = new ArrayList<>();
        for (int x = list5.size(); x >= 1; x--)
            list5rev.add(list5.get(x - 1));
        return list5rev;
    }

    public static void reverseListInPlace(List<String> list5){
        List<String> list5rev = reverseList(list5);
        list5.addAll(list5rev);
        for (String x:list5rev)
            list5.remove(x);
        System.out.println(list5);
    }

    public static List<Integer> filterEvenIndices(List<Integer> inits){
        List<Integer>  a = new ArrayList<>();
        for (int i = 1; i < inits.size(); i += 2)
            a.add(inits.get(i));
        return a;
    }

    public static List<Integer> filterEven(List<Integer> inits){
        List<Integer>  a = new ArrayList<>();
        for (Integer x:inits){
            if (x % 2 != 0)
                a.add(x);
        }
        return a;
    }

    public static void mutableFilterEvenIndices(List<Integer> mutableInts){
        if (mutableInts.size() % 2 != 0){
            for (int i = mutableInts.size() - 1; i >= 0; i -= 2)
                mutableInts.remove(i);
        }
        else for (int i = mutableInts.size() - 2; i >= 0; i -= 2)
                mutableInts.remove(i);
        System.out.println(mutableInts);
    }

    public static void mutableFilterEven(List<Integer> mutableInts){
        for (int i = mutableInts.size() - 1; i >= 0; i--){
            if (mutableInts.get(i) % 2 == 0)
                mutableInts.remove(i);
        }
        System.out.println(mutableInts);
    }

    public static void doReadWordsInFile(String filename, Set<String> set){
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                for (String x:words)
                    set.add(x.toLowerCase());
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(set);
    }
}
