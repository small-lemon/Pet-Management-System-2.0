package com.hopu.day8.entity;


public class Pet {
    private int id;
    private String name;
    private String gender;
    private String type;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    private int age;
    private int price;
    private int weight;


    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public Pet(int id,String name, String gender, String type, int age, int price, int weight) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.age = age;
        this.price = price;
        this.weight = weight;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
