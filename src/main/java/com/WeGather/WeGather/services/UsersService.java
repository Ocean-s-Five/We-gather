package com.WeGather.WeGather.services;


import com.WeGather.WeGather.models.*;
import com.WeGather.WeGather.repositories.AdminRepository;
import com.WeGather.WeGather.repositories.EmployeeRepository;
import com.WeGather.WeGather.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public
class UsersService  implements UserDetailsService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = adminRepository.findByUsername(username);
        Employee employee = employeeRepository.findByUsername(username);
        User user = userRepository.findByUsername(username);


        if (admin !=null){
            return new ApplicationAdmin(admin);
        }else if (employee!=null){
            return new ApplicationEmployee(employee);
        }else if (user!=null){
            return new ApplicationUsers(user);
        }

        throw new UsernameNotFoundException("User "+username+" does not exist");
    }
}
