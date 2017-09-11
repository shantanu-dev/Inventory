package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by shantanu on 9/8/16.
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository  userRepository;

    @Transactional
    public List<Roles> findByUsername(String  username)
    {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public List<Roles> RolesDisplay()
    {
        return userRepository.findAll();
    }

    @Transactional
    public boolean RoleInsert(Roles xyz) {
        if(userRepository.save(xyz) != null) {
            return true;
        }
        else
                    return false;
    }




    @Override
    @Transactional

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        // Declare a null Spring User



        // Search database for a user that matches the specified username
        // You can provide a custom DAO to access your persistence layer
        // Or use JDBC to access your database
        // DbUser is our custom domain user. This is not the same as Spring's User
        Roles dbUser = userRepository.findByUsername(username).get(0);

        if (dbUser == null) {
            throw new UsernameNotFoundException("HiMVC Security:: Error in retrieving user(username=" + username + ")");
        }


        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                dbUser.getUsername(),
                dbUser.getPassword(),//here you can put a clear text password
                true,
                true,
                true,
                true,


                loadUserAuthorities(dbUser.getRoles())

        );

        return userDetails;
    }

    public Collection<? extends GrantedAuthority> loadUserAuthorities(String username) {
        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(username));
        return auths;
    }}

