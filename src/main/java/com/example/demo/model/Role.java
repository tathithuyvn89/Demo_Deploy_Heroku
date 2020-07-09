package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
  public class Role {
      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
      private String  roleName;;
      @ManyToMany
  private List<Account> accounts;
  }