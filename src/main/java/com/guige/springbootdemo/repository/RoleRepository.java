package com.guige.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guige.springbootdemo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}