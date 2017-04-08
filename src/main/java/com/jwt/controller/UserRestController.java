package com.jwt.controller;

import com.jwt.model.security.Authority;
import com.jwt.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;
import com.jwt.security.JwtTokenUtil;
import com.jwt.security.JwtUser;
import com.jwt.security.service.UserService;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private UserService userService;
            
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("user")
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println(jwtTokenUtil.getExpirationDateFromToken(token));
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;//new ResponseEntity(user, HttpStatus.OK);
    }
    
    
     @PostMapping("register")
    public String register( @RequestBody User user) {
        User userDB=userService.findByUniqueField("email",user.getEmail());
        if(userDB==null)
        {
            Authority authority=new Authority();
            List<User> users=new ArrayList<>();
            users.add(user);
            authority.setUsers(users);
            authority.setId(1L);
            List<Authority> authorities=new ArrayList<>();
            authorities.add(authority);
            user.setAuthorities(authorities);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.persist(user);
        return "Registration Completed. Please Login";}
        return "User Account Already Registered";
        
    }

}
