package dataStructure.stackANDqueue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * 实现一个猫狗队列的结构
 * 思路1：构造含时间戳属性的PetInstance类，当有Cat或Dog进入队列时，生成一个时间戳，出队时按照时间戳大小，小的先出队
 * @author prd-fuy
 * @version $Id: CatDogQueue.java, v 0.1 2019年8月20日 上午9:09:01 prd-fuy Exp $
 */
public class CatDogQueue {
    class Pet {
        private String type;
        
        public Pet(String type) {
            this.type = type;
        }
        
        public String getType() {
            return type;
        }
    }
    
    class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }
    
    class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }
    
    class PetInstance {
        private Pet  pet;
        private long count;
        
        public PetInstance(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }
        
        public Pet getPet() {
            return this.pet;
        }
        
        public long getPetCount() {
            return this.count;
        }
        
        public String getPetType() {
            return this.pet.getType();
        }
        
    }
    
    private Queue<PetInstance> DogQueue;
    private Queue<PetInstance> CatQueue;
    private long               count;
    
    public CatDogQueue() {
        this.DogQueue = new LinkedList<PetInstance>();
        this.CatQueue = new LinkedList<PetInstance>();
        this.count = 0;
    }
    
    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            DogQueue.add(new PetInstance(pet, this.count++));
        } else if (pet.getType().equals("cat")) {
            CatQueue.add(new PetInstance(pet, this.count++));
        } else
            throw new RuntimeException("Pet type error");
    }
    
    public Pet pollAll() {
        if (!this.DogQueue.isEmpty() && !this.CatQueue.isEmpty()) {
            if (this.DogQueue.peek().count < this.CatQueue.peek().count)
                return DogQueue.poll().getPet();
            else if (this.DogQueue.peek().count > this.CatQueue.peek().count)
                return CatQueue.poll().getPet();
            else
                throw new RuntimeException("Count Error");
        } else if (!this.DogQueue.isEmpty()) {
            return DogQueue.poll().getPet();
        } else if (!this.CatQueue.isEmpty()) {
            return CatQueue.poll().getPet();
        } else
            throw new RuntimeException("PetQueue is null");
    }
    
    public Dog pollDog() {
        if (!this.DogQueue.isEmpty()) {
            return (Dog) DogQueue.poll().getPet();
        } else
            throw new RuntimeException("DogQueue is null");
    }
    
    public Cat pollCat() {
        if (!this.CatQueue.isEmpty()) {
            return (Cat) CatQueue.poll().getPet();
        } else
            throw new RuntimeException("CatQueue is null");
    }
    
    public boolean isEmpty() {
        if (this.DogQueue.isEmpty() && this.CatQueue.isEmpty())
            return true;
        else
            return false;
    }
    
    public boolean isDogEmpty() {
        if (this.DogQueue.isEmpty())
            return true;
        else
            return false;
    }
    
    public boolean isCatEmpty() {
        if (this.CatQueue.isEmpty())
            return true;
        else
            return false;
    }
    
    @Test
    public void test1() {
        CatDogQueue queue = new CatDogQueue();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        queue.add(dog1);
        queue.add(dog2);
        queue.add(cat1);
        queue.add(dog3);
        queue.add(cat2);
        
        System.out.println("Queue Poll : " + queue.pollAll().getType());
        System.out.println("Queue Poll : " + queue.pollAll().getType());
        System.out.println("Queue Poll : " + queue.pollAll().getType());
        System.out.println("Queue Poll : " + queue.pollAll().getType());
        System.out.println("Queue Poll : " + queue.pollAll().getType());
        System.out.println("Queue Poll : " + queue.pollAll().getType());
    }
}
