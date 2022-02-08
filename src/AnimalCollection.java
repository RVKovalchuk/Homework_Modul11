import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AnimalCollection {
    //создаем hashMap c default initial capacity.
    private static final Map<Integer, AnimalCollection> animalList = new HashMap<>();
    //объявляем необходимые для конструктора переменные.
    private final String speciesOfAnimal;
    private final String name;
    private  int age;
    private  double weight;

    //создаем конструктор.
    public AnimalCollection(String speciesOfAnimal, String name, int age, double weight) {
        //выдаем исключение при вводе отрицательного возраста или отрицательного веса.
        if (age <= 0 || weight <= 0.0) {
            throw new IllegalArgumentException();
        }
        this.speciesOfAnimal = speciesOfAnimal;
        this.name = name;
        this.age = age;
        this.weight = weight;
        //введеный экземпляр класса кладем в коллекцию.
        animalList.put(setId(), this);
    }

    //создаем метод для вывода всей коллекции.
    public static void printList() {
        for (Map.Entry<Integer, AnimalCollection> map : animalList.entrySet()) {
            System.out.printf("Id: %s - %s \n", map.getKey(), map.getValue().getAllInfo());
        }
    }

    //создаем метод для вывода всей информации по speciesOfAnimal и name (не идеальная ситуация).
    public static void printSpeciesOfAnimalAndName(String speciesOfAnimal, String name) {
        for (Map.Entry<Integer, AnimalCollection> map : animalList.entrySet()) {
            if (map.getValue().getSpeciesOfAnimal().equals(speciesOfAnimal) && map.getValue().getName().equals(name)) {
                System.out.printf("Id: %s - %s \n", map.getKey(), map.getValue().getAllInfo());
            }
        }
    }

    //создаем метод для вывода информации по ключу-id (идеальная ситуация).
    public static void printSoloInfo(int id) {
        System.out.println(animalList.get(id).getAllInfo());
    }

    //добавляем getter для возможности получения отдельной информации об экземпляре класса.
    private String getSpeciesOfAnimal() {
        return speciesOfAnimal;
    }
    private String getName() {
        return name;
    }

    //рассчитываем уникальный id-ключ для экземпляра класса в коллекции.
    private int setId() {
        return animalList.size() + 1;
    }

    //создаем метод для возврата всей информации об экземпляре класса.
    public String getAllInfo() {
        return "[species of animal: " + speciesOfAnimal + ", name: " + name + ", age: " + age +
                ", weight: " + weight + ']';
    }

    //переопределяем метод hashCode().
    @Override
    public int hashCode() {
        return Objects.hash(speciesOfAnimal, name);
    }
}