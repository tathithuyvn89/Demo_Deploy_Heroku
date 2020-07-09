package com.example.demo.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
      public static  String encrytePassword(String password){
          BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
          return encoder.encode(password);
      }
//Ham main de lay value cua pass la 123
    public static void main(String[] args) {
        String pass = "123";
        String encoder= encrytePassword(pass);
        System.out.println(encoder);
    }
  }