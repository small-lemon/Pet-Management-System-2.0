package com.hopu.day8;

import com.hopu.day8.entity.Pet;
import com.hopu.day8.entity.PetShop;
import com.hopu.day8.mapper.PetMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class PetShopApp {
    public static final String URL = "jdbc:mysql://localhost:3306/petShop?" +
            "serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        //通过驱动管理器获得连接
        try (Connection connection = DriverManager.getConnection(URL,"root","123");){
            System.out.println(connection);
            //创建会话工厂创建器
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //创建工厂
            SqlSessionFactory  factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //创建会话
            SqlSession sqlSession = factory.openSession();
            //获得映射接口对象
            PetMapper mapper = sqlSession.getMapper(PetMapper.class);
            //调用接口
            //执行SQL语句
            String sql = "select * from tb_userName where username = ? and password = ? ";
            //获得命令对象
            PreparedStatement statement = connection.prepareStatement(sql);
            //设置占位符
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            //逐行读取数据
            if(resultSet.next()){
                System.out.println("登录成功！欢迎" +username);
                //创建宠物商店
                PetShop petShop = new PetShop();
                for(;;){

                    System.out.println("--------------------欢迎使用宠物管理系统--------------------");
                    System.out.println("请选择执行的操作： 1.查看所有宠物 2.添加宠物 3.修改宠物 4.查找宠物 " +
                            "5.删除宠物 6.按年龄排序 7.按价格排序 其他：退出");
                    int op = scanner.nextInt();
                    switch(op){
                        case 1:

                            List<Pet> pets = mapper.selectAllPets();
                            for(Pet pet : pets){
                                System.out.println(pet);
                            }
                            break;
                        case 2:

                            Pet pet= petShop.inputPetInfo();
                            // System.out.println(pet);
                            mapper.addPet(pet);
                            sqlSession.commit();

                           // mapper.addPet(new Pet(pet.getId(),pet.getName(),pet.getGender(),pet.getType(),pet.getAge(),pet.getPrice(),pet.getWeight()));
                            break;

                        case 3:

                            System.out.println("请输入修改信息");
                            Pet pet2 = petShop.inputPetInfo();
                            mapper.updatePetByName(pet2);
                            sqlSession.commit();
                            break;
                        case 4:
                            System.out.println("输入要查找的宠物：");
                            String nn= scanner.next();
                            System.out.println("信息如下：");
                            mapper.findPetByName(nn);
                            sqlSession.commit();
                            List<Pet> pet5 = sqlSession.selectList("findPetByName", nn);
                            System.out.println(pet5);

                            break;
                        case 5:
                            System.out.println("请输入要删除的宠物：");
                            String nm= scanner.next();
                            mapper.removePetByName(nm);
                            System.out.println("已删除该宠物！");
                            sqlSession.commit();

                            break;
                        case 6:

                            List<Pet> pet3 = mapper.sortByAge();
                            for(Pet p : pet3){
                                System.out.println(p);
                            }
                            break;
                        case 7:

                            List<Pet> pet4 = mapper.sortByPrice();
                            for(Pet p1 : pet4){
                                System.out.println(p1);
                            }
                            break;
                        default: return;
                    }
                }

            }else{
                System.out.println("账号或密码错误！");
            }

            sqlSession.commit();
        } catch (SQLException | IOException e) { //有异常就执行
            e.printStackTrace();
        }



//        //创建会话工厂创建器
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        //创建工厂
//
//        try {
//           SqlSessionFactory  factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
//            //创建会话
//            SqlSession sqlSession = factory.openSession();
//            //获得映射接口对象
//            PetMapper mapper = sqlSession.getMapper(PetMapper.class);
//            //调用接口
//            mapper.addPet(new Pet(3,"剑齿虎","公","老虎",56,89,49));
//
//            List<Pet> pets = mapper.selectAllPets();
//            for(Pet pet : pets){
//                System.out.println(pet);
//            }
//
//
//            //提交语句
//            sqlSession.commit();
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//
//
    }
}
