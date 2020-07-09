package com.example.demo.service.impl;

import com.example.demo.model.Account;
import com.example.demo.model.Role;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
//      @Autowired
//      private RoleAccountRepository roleAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);
        if (account == null) {
            System.out.println("Khong tim thay username : " + account);
            throw new UsernameNotFoundException("Khong tim thay tai khoan");
        }
        List<Role> roles = roleRepository.findAllByAccounts(account);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (roles != null) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }

        }
        UserDetails userDetails = new User(account.getUsername(),account.getEncrytedPassword(),authorities);
        return userDetails;
    }
}