import java.util.*;
import java.util.random.RandomGenerator;

public class One {
    public static void main(String[] args) {
        //a) Создайте массив из N случайных чисел от 0 до 100.
        int N = 20;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = RandomGenerator.getDefault().nextInt(0, 101);
        }
        System.out.println("a) " + Arrays.toString(arr) + " - Array");

        //b) На основе массива создайте список List.
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("b) " + list + " - List");

        //c) Отсортируйте список по возрастанию.
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        System.out.println("c) " + sortedList + " - Sorted list");

        //d) Отсортируйте список в обратном порядке.
        List<Integer> reversedList = new ArrayList<>(list);
        Collections.sort(reversedList, Collections.reverseOrder());
        System.out.println("d) " + reversedList + " - Reverse sorted list");

        //e) Перемешайте список.
        List<Integer> shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        System.out.println("e) " + shuffledList + " - Shuffled list");

        //f) Выполните циклический сдвиг на 1 элемент.
        List<Integer> rotatedList = new ArrayList<>(list);
        Collections.rotate(rotatedList, 1);
        System.out.println("f) " + rotatedList + " - Rotated list");

        //g) Оставьте в списке только уникальные элементы.
        List<Integer> uniqueList = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("g) " + uniqueList + " - Unique list");

        //h) Оставьте в списке только дублирующиеся элементы.
        List<Integer> duplicatedList = new ArrayList<>(list);
        duplicatedList.removeIf(num -> Collections.frequency(list, num) == 1);
        System.out.println("h) " + duplicatedList + " - Duplicated list");

        //i) Из списка получите массив.
        Integer[] arr2 = list.toArray(new Integer[0]);
        System.out.println("i) " + Arrays.toString(arr2) + " - Array of list");

        //j) Посчитайте количество вхождений каждого числа в массив и выведите на экран.
        System.out.print("j) ");
        for (Integer num : new TreeSet<>(list)) {
            System.out.print(num + " - " + Collections.frequency(Arrays.asList(arr2), num) + ", ");
        }
    }
}
