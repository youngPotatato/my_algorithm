class Cat extends Animal {

    public Cat (String name, int age) {
        super(name,age);
        noise = "Meow";
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }

    public static void main(String [] args){
        Cat aa = new Cat("kitty",7);
        Cat a = new Cat("kitty2",3);
        aa.greet();
        a.greet();
    }
}
