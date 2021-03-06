public class App_AnimalCollection {
    public static void main(String[] args) {
        //создаем экземпляры классов.
        AnimalCollection CatStinky = new AnimalCollection("Cat", "Stinky", 12, 8.4);
        AnimalCollection DogFluffy = new AnimalCollection("Dog", "Fluffy", 3, 26);
        AnimalCollection CatCorry = new AnimalCollection("Cat", "Cory", 2, 2.3);
        AnimalCollection DogLazy = new AnimalCollection("Dog", "Lazy", 5, 33.4);
        AnimalCollection RatHippo = new AnimalCollection("Rat", "Hippo", 1, 0.7);
        AnimalCollection CatLuna = new AnimalCollection("Cat", "Luna", 9, 5.0);

        //выводим всю коллекцию.
        AnimalCollection.printList();
        //выводим информацию по ключу-id.
        AnimalCollection.printSoloInfo(3);
        //выводим информацию по speciesOfAnimal и name.
        AnimalCollection.printSpeciesOfAnimalAndName("Cat", "Cory");
    }
}
