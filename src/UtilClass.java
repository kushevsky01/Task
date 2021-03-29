import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Exceptions.Exceptions;
import Exceptions.IllegalArgumentException;

public class UtilClass {

    public static <T> boolean isBlank(List<T> list) {
        if (list == null)
            return true;
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static <T> T getLastElem(List<T> list) throws Exceptions {
        if (list == null) {
            throw new IllegalArgumentException("Список равен null");
        }
        T LastElement = list.get(list.size() - 1);

        return LastElement;

    }


    public static <E> E findElem(List<E> list, E elem) throws Exceptions {
        if ((list == null) | (elem == null)) {
            throw new IllegalArgumentException("Список равен null");
        }
        Boolean isFind = false;
        for (int i = 0; i < list.size(); i++) {
            if (elem.equals(list.get(i))) {
//                E element = elem;
                isFind = true;
            }
        }
        if (isFind) {
            return elem;
        }
        return null;
    }


    public static <E, T> List union(List<E> list1, List<T> list2) throws Exceptions {
        if ((list1 == null) | (list2 == null)) {
            throw new IllegalArgumentException("Список(и) равен null");
        }

        List<Object> newlist = new ArrayList<Object>();
        newlist.addAll(list1);
        newlist.addAll(list2);
        return newlist;
    }

    public static <E, T> List<E> removeAll(List<E> list1, List<T> list2) throws Exceptions {
        if ((list1 == null) | (list2 == null)) {
            throw new IllegalArgumentException("Список(и) равен null");
        }
        List<E> newlist = new ArrayList<E>(list1);
        for (int i = 0; i < list1.size(); i++)
            for (int j = 0; j < list2.size(); j++)
                if (list1.get(i).equals(list2.get(j))) {
                    newlist.remove(i);
                }
        return newlist;
    }


    public static <T, E> double sum(List<E> list1, List<T> list2) throws Exceptions {
        if ((list1 == null) | (list2 == null)) {
            throw new IllegalArgumentException("Список(и) равен null");
        }

        Number summa;
        double sum = 0;

        for (int i = 0; i < list1.size(); i++) {
            summa = (Number) list1.get(i);
            sum += summa.doubleValue();
        }
        for (int i = 0; i < list1.size(); i++) {
            summa = (Number) list2.get(i);
            sum += summa.doubleValue();
        }
        return sum;


    }

    public static void main(String[] args) throws Exceptions {
        List<String> group1 = new ArrayList<>(Arrays.asList("Анастасия", "Ксения", "Юрий"));
        List<String> group2 = new ArrayList<>(Arrays.asList("Антон", "Ксения", "Юлия"));
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Double> numbers2 = new ArrayList<>(Arrays.asList(1.5, 2.5, 3.5));
        List<String> nullList = null;
        List<String> emptyList = new ArrayList<>();

        boolean isBlank;

        isBlank = UtilClass.isBlank(nullList);
        if (!isBlank) {
            throw new AssertionError("Должно быть значение true");
        }

        isBlank = UtilClass.isBlank(emptyList);

        if (!isBlank) {
            throw new AssertionError("Должно быть значение true");
        }

        isBlank = UtilClass.isBlank(group1);

        if (isBlank) {
            throw new AssertionError("Должно быть значение false");
        }

        String lastElem = (String) UtilClass.getLastElem(group1);

        if (!"Юрий".equals(lastElem)) {
            throw new AssertionError("Последний в списке должен быть Юрий");
        }

        double lastNum = (double) UtilClass.getLastElem(numbers1);

        if (lastNum != 3) {
            throw new AssertionError("Последним в списке должен быть 3");
        }

        String name = (String) UtilClass.findElem(group1, "Ксения");

        if (!"Ксения".equals(name)) {
            throw new AssertionError("Найденным должна быть Ксения");
        }

        int num = (int) UtilClass.findElem(numbers1, 2);

        if (num != 2) {
            throw new AssertionError("Найденным должна быть 2");
        }

        String nullName = (String) UtilClass.findElem(group1, "Кирилл");

        if (nullName != null) {
            throw new AssertionError("Кирилла в списке нет, должен вернуться null");
        }

        List<String> union = UtilClass.union(group1, group2);

        if (group1.size() != 3 || group2.size() != 3) {
            throw new AssertionError("Изначальные списки не должны измениться");
        }

        if (union.size() != 6
                || !union.containsAll(Arrays.asList("Анастасия", "Ксения", "Юрий", "Антон", "Ксения", "Юлия"))
        ) {
            throw new AssertionError("ответ union содержит неправильный список имен");
        }

        List<String> cutGroup = UtilClass.removeAll(group1, group2);

        if (group1.size() != 3 || group2.size() != 3) {
            throw new AssertionError("Изначальные списки не должны измениться");
        }

        if (cutGroup.size() != 2
                || !cutGroup.containsAll(Arrays.asList("Анастасия", "Юрий"))
                || cutGroup.contains("Ксения")) {
            throw new AssertionError("Ответ cutGroup содержит неправильный список имен");
        }

        double sum = UtilClass.sum(numbers1, numbers2);

        if (sum != 13.5) {
            throw new AssertionError("Ответ должен быть 13.5");
        }

        System.out.print("Поздравляю! Задание выполнено");
    }

}

