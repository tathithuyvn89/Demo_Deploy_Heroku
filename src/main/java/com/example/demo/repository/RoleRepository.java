package com.example.demo.repository;
import com.example.demo.model.Account;
import com.example.demo.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role,Long> {
    List<Role> findAllByAccounts(Account account);
}
