/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.librarymanagement.security;

import com.mycompany.librarymanagement.entity.User;
import com.mycompany.librarymanagement.entity.UserRole;
import com.mycompany.librarymanagement.services.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author ASUS
 */

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;
    
    
    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
                    String email = a.getName();
        String password = a.getCredentials().toString();
        User userEntity = userService.findbyEmailandPassword(email, password);
        
        
        if(userEntity != null){
            List<UserRole> listUR = (List<UserRole>) userEntity.getUserRoleCollection();
            List<GrantedAuthority> authorities = new ArrayList<>();
            for(UserRole role : listUR){
                String roleName = role.getRole().toString();
                authorities.add(new SimpleGrantedAuthority(roleName));
            }return new UsernamePasswordAuthenticationToken(
                    userEntity, email, authorities);
            
        }else {
            return null;
        }
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
} 
