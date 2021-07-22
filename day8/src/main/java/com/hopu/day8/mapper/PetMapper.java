package com.hopu.day8.mapper;

import com.hopu.day8.entity.Pet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 宠物管理接口
         */
public interface PetMapper {

    /**
     * 显示所有宠物的信息
     *
     * @return
     *
     */
    List<Pet> selectAllPets();

    /**
     * 按宠物的名字查找宠物
     *
     * @param name
     */
    void findPetByName(String name);

    /**
     * 输入宠物信息
     *
     * @return
     */
    Pet inputPetInfo();

    /**
     * 添加宠物
     *
     * @param pet
     */
    void addPet(Pet pet) throws SQLException, IOException;

    /**
     * 按名字修改宠物
     *
     * @param name
     * @param pet
     */
    void updatePetByName(Pet pet);

    /**
     * 删除宠物
     *
     * @param name
     */
    void removePetByName(String name);

    /**
     * 按年龄排序
     * @return
     */
    List<Pet> sortByAge();

    /**
     * 按价格排序
     * @return
     */
    List<Pet> sortByPrice();

}

