package com.hopu.day8.entity;

import com.hopu.day8.mapper.PetMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PetShop implements PetMapper {


    @Override
    public List<Pet> selectAllPets() {

        return null;
    }

    @Override
    public void findPetByName(String name) {


    }

    @Override
    public  Pet inputPetInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入宠物的ID");
        int id = scanner.nextInt();
        System.out.println("输入宠物的名字");
        String name = scanner.next();
        System.out.println("输入宠物的性别");
        String gender = scanner.next();
        System.out.println("输入宠物的类型");
        String type = scanner.next();
        System.out.println("输入宠物的年龄");
        int age = scanner.nextInt();
        System.out.println("输入宠物的价格");
        int price = scanner.nextInt();
        System.out.println("输入宠物的重量");
        int weight = scanner.nextInt();
        return new Pet(id,name, gender, type, age, price, weight);
    }

    @Override
    public void addPet(Pet pet ) throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入宠物的名字");
        pet.setName(scanner.next());
        System.out.println("输入宠物的性别");
        pet.setGender(scanner.next());
        System.out.println("输入宠物的类型");
        pet.setType(scanner.next());
        System.out.println("输入宠物的年龄");
        pet.setAge(scanner.nextInt());
        System.out.println("输入宠物的价格");
        pet.setPrice(scanner.nextInt());
        System.out.println("输入宠物的重量");
        pet.setWeight(scanner.nextInt());

        //创建会话工厂创建器
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //创建工厂
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        //创建会话
        SqlSession sqlSession = factory.openSession();
        //获得映射接口对象
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);
        //调用接口

        mapper.addPet(new Pet(pet.getId(),pet.getName(),pet.getGender(),pet.getType(),pet.getAge(),pet.getPrice(),pet.getWeight()));

    }

    @Override
    public void updatePetByName(Pet pet) {

    }

    @Override
    public void removePetByName(String name) {

    }

    @Override
    public List<Pet> sortByAge() {

        return null;
    }

    @Override
    public List<Pet> sortByPrice() {

        return null;
    }

}


