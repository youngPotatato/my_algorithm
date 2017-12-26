public class TestAnimals {
    public static void main(String [] args){
       Animal a = new Animal("pu",10);
       Cat c = new Cat("gar",6);
       Dog d = new Dog("fi",4);
        a.greet();
        c.greet();
        d.greet();

        a = c;
        ((Cat)a).greet();
        a.greet();

        a = new Dog("spo",10);
        d = (Dog)a;

    }

}
