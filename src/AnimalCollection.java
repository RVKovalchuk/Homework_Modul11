import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AnimalCollection {
    private static final Map<Integer, AnimalCollection> animalList = new HashMap<>();

    private final String speciesOfAnimal;
    private final String name;
    private final int age;
    private final double weight;

    public AnimalCollection(String speciesOfAnimal, String name, int age, double weight) {
        this.speciesOfAnimal = speciesOfAnimal;
        this.name = name;
        this.age = age;
        this.weight = weight;
        animalList.put(setId(), this);
    }

    public int setId() {
        return animalList.size() + 1;
    }

    public String getAllInfo() {
        return "[species of animal: " + speciesOfAnimal + ", name: " + name + ", age: " + age +
                ", weight: " + weight + ']';
    }

    public static void printList() {
        for (Map.Entry<Integer, AnimalCollection> map : animalList.entrySet()) {
            System.out.printf("Id: %s - %s \n", map.getKey(),  map.getValue().getAllInfo());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalCollection that = (AnimalCollection) o;
        return Objects.equals(speciesOfAnimal, that.speciesOfAnimal) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speciesOfAnimal, name);
    }
}