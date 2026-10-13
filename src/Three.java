import java.util.*;

class Human implements Comparable<Human> {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", lastName, firstName, age);
    }

    @Override
    public int compareTo(Human o) {
        int res = this.lastName.compareTo(o.lastName);
        if (res != 0) return res;
        res = this.firstName.compareTo(o.firstName);
        if (res != 0) return res;
        return Integer.compare(this.age, o.age);
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}

public class Three {
    public static void main(String[] args) {
        List<Human> list = new ArrayList<>();
        list.add(new Human("John", "Smith", 30));
        list.add(new Human("Anna", "Baker", 25));
        list.add(new Human("John", "Smith", 30));
        list.add(new Human("Jack", "Smith", 20));
        list.add(new Human("Robert", "Baker", 45));

        System.out.println("Source List");
        for (Human h : list) {
            System.out.println(h);
        }

        // a) HashSet
        System.out.println("\na) HashSet");
        Set<Human> hashSet = new HashSet<>(list);
        for (Human h : hashSet) {
            System.out.println(h);
        }

        // b) LinkedHashSet
        System.out.println("\nb) LinkedHashSet");
        Set<Human> linkedHashSet = new LinkedHashSet<>(list);
        for (Human h : linkedHashSet) {
            System.out.println(h);
        }

        // c) TreeSet с Comparable (Natural Ordering)
        System.out.println("\nc) TreeSet (Natural Ordering)");
        Set<Human> treeSetNatural = new TreeSet<>(list);
        for (Human h : treeSetNatural) {
            System.out.println(h);
        }

        // d) TreeSet с HumanComparatorByLastName
        System.out.println("\nd) TreeSet (By LastName Comparator)");
        Set<Human> treeSetLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetLastName.addAll(list);
        for (Human h : treeSetLastName) {
            System.out.println(h);
        }

        // e) TreeSet с анонимным компаратором по возрасту
        System.out.println("\ne) TreeSet (Anonymous Age Comparator)");
        Set<Human> treeSetAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetAge.addAll(list);
        for (Human h : treeSetAge) {
            System.out.println(h);
        }
    }
}

/*
f) Каждая коллекция семейства Set имеет разную внутреннюю структуру данных и разные правила
определения уникальности/сортировки элементов:
- HashSet и LinkedHashSet используют методы hashCode() и equals() для поиска дубликатов.
- TreeSet полностью игнорирует методы hashCode() и equals(). Вместо них он использует
метод compareTo() интерфейса Comparable или метод compare() переданного Comparator.
Если метод сравнения возвращает 0, TreeSet считает элементы идентичными и не добавляет дубликат.

a) HashSet: Использует хэш-таблицу. Не гарантирует никакой определенный порядок элементов при выводе.
Удаляет полные дубликаты (где совпадают имя, фамилия и возраст), опираясь на equals/hashCode.

b) LinkedHashSet: Расширяет HashSet, но дополнительно поддерживает двусвязный список поверх
хэш-таблицы. Благодаря этому он сохраняет порядок добавления элементов (Insertion Order), при
этом также отсекая полные дубликаты через equals/hashCode.

c) TreeSet (Natural Ordering): Автоматически сортирует элементы по правилам, описанным в compareTo().

d) TreeSet (By LastName Comparator): Использует кастомный компаратор, сравнивающий только по фамилии.
Так как компаратор считает элементы с одинаковой фамилией равными (возвращает 0), в коллекцию
попали только первые уникальные фамилии.

e) TreeSet (Anonymous Age Comparator): Сортирует элементы исключительно по возрасту.
Если у двух людей совпадет возраст, один из них не попадет в коллекцию.
*/

