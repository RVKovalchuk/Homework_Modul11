import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AnimalCollection {
    //создаем hashMap c default initial capacity.
    private static final Map<Integer, AnimalCollection> animalList = new HashMap<>();
    //объявляем необходимые для конструктора переменные.
    private final String speciesOfAnimal;
    private final String name;
    private int age;
    private double weight;

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

    //добавляем getter для возможности получения отдельной информации об экземпляре класса.
    public String getSpeciesOfAnimal() {
        return speciesOfAnimal;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //добавляем setter для возможности изменения переменной информации об экземплярах класса.
    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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