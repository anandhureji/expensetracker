package com.ExpenseTrackerApp.ExpenseTracker.service;

import com.ExpenseTrackerApp.ExpenseTracker.Exception.ExpenseNotFoundException;
import com.ExpenseTrackerApp.ExpenseTracker.Exception.ItemAlreadyExistsException;
import com.ExpenseTrackerApp.ExpenseTracker.Repository.UserRepository;
import com.ExpenseTrackerApp.ExpenseTracker.entity.User;
import com.ExpenseTrackerApp.ExpenseTracker.entity.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(UserModel userModel) {
        if(userRepository.existsByEmail(userModel.getEmail())){
            throw new ItemAlreadyExistsException("User is already registered with email:"+userModel.getEmail());
        }
        if(userRepository.existsByMobile(userModel.getMobile())){
            throw new ItemAlreadyExistsException("User is already registered with mobile no:"+userModel.getMobile());
        }
        User user = new User();
        BeanUtils.copyProperties(userModel,user);
        return userRepository.save(user);
    }

    @Override
    public User read(Long id) throws ExpenseNotFoundException {
        return userRepository.findById(id).orElseThrow(()->new ExpenseNotFoundException("User not Found for the id:"+id));
    }

    @Override
    public User update(User user, Long id) {
        User user1 = read(id);
        user1.setName(user.getName()!=null?user.getName():user1.getName());
        user1.setEmail(user.getEmail()!=null?user.getEmail():user1.getEmail());
        user1.setPassword(user.getPassword()!=null?user.getPassword():user1.getPassword());
        user1.setAge(user.getAge()!=null?user.getAge():user1.getAge());
        return userRepository.save(user1);
    }

    @Override
    public void delete(Long id) {
        User user = read(id);
        userRepository.delete(user);

    }
}
