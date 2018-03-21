package com.guige.springbootdemo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.guige.springbootdemo.entity.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;
    
    @Test
    public void testInsert() {
        Role role = new Role();
        role.setName("管理员");
        role.setDescr("测试");
        Role result = this.roleRepository.save(role);
        System.out.println(result);
    }
    
    @Test
    public void testFindOne() {
        Role role = this.roleRepository.findOne(1);
        System.out.println(role);
    }
    
    @Test
    public void testUpdate() {
        Role role = new Role();
        role.setId(1);
        role.setName("管理员");
        role.setDescr("控制权限");
        Role result = this.roleRepository.save(role);
        System.out.println(result);
    }
    
    @Test
    public void testDelete() {
        this.roleRepository.delete(1);
    }
}