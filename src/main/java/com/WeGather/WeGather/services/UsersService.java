package com.WeGather.WeGather.services;


import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public
class UsersService  implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);

        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User "+username+" does not exist");
        }
        return user;
    }
}
