package com.llollox.algorithms.problems.crack.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    /*
        Animal Shelter:
        An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out" basis.
        People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
        or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
        They cannot select which specific animal they would like. Create the data structures to maintain this
        system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
        You may use the built in Linkedlist data structure.
     */


    /*
        LinkedList with three pointers:
            - oldest
            - oldestDog
            - oldestCat
     */


    public static class Animal {
        public String name;
        private int order;
        public Animal(String name, int order) { this.name = name; this.order = order; }

        public boolean isOlderThan(Animal animal) {
            return this.order < animal.order;
        }
    }

    public static class Dog extends Animal {
        public Dog(String name, int order) { super(name, order); }
    }

    public static class Cat extends Animal {
        public Cat(String name, int order) { super(name, order); }
    }


    private Queue<Dog> dogs = new LinkedList<>();
    private Queue<Cat> cats = new LinkedList<>();


    public void enqueue(Animal animal) {

        if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
        else if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        }
    }

    public Animal dequeueAny() {

        if (this.dogs.isEmpty() && this.cats.isEmpty()) {
            throw new RuntimeException("No animals");
        }
        else if (this.dogs.isEmpty()) {
            return this.cats.poll();
        }
        else if (this.cats.isEmpty()) {
            return this.dogs.poll();
        }
        else {

            Dog dog = this.dogs.peek();
            Cat cat = this.cats.peek();

            if (dog.isOlderThan(cat)) {
                return this.dogs.poll();
            }
            else {
                return this.cats.poll();
            }
        }
    }

    public Animal dequeueCat() {

        if (this.cats.isEmpty()) {
            throw new RuntimeException("No cat into the queue");
        }

        return this.cats.poll();
    }

    public Animal dequeueDog() {
        if (this.dogs.isEmpty()) {
            throw new RuntimeException("No cat into the queue");
        }

        return this.dogs.poll();
    }
}
