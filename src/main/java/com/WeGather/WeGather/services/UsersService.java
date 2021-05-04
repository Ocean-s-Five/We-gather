package com.WeGather.WeGather.services;


import com.WeGather.WeGather.models.*;
import com.WeGather.WeGather.repositories.AdminRepository;
import com.WeGather.WeGather.repositories.EmployeeRepository;
import com.WeGather.WeGather.repositories.UserRepository;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public
class UsersService  implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder cryptPasswordEncoder;
    @Override
    public
    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Admin admin = (Admin) usersRepository.findByUsername(userName);
        Employee employee = (Employee) usersRepository.findByUsername(userName);
        User user = (User) usersRepository.findByUsername(userName);

        String pwd= cryptPasswordEncoder.encode("ksdfjhkashl");

        if (admin !=null){
            return new ApplicationUsers(admin);
        }else if (employee!=null){
            return new ApplicationUsers(employee);
        }else if (user!=null){
            return new ApplicationUsers(user);
        }

        throw new UsernameNotFoundException("User "+userName+" does not exist");
    }
}
