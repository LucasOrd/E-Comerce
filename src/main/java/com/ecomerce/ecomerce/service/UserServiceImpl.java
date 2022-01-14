package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    private ArrayList<User> users = new ArrayList<>();
    private void addUser (){
        this.users.add(new User(1L,"programer","lucas",1234L));
    }

    @Override
    public User updateUser(User user, Long id) {
        for (int i=0;i<users.size();i++){
            if (users.get(i).getId()==id){
                users.get(i).setEmail(user.getEmail());
                users.get(i).setPhone(user.getPhone());
                users.get(i).setRol(user.getRol());
            }
        }

        return user;
    }

//    @Autowired
//    private UserRepository repository;
//
//    @Override
//    public User createUser(User user) {
////        return repository.save(user);
//        return user;
//    }
//
//    @Override
//    public User getUserById(Long id) {
////        return repository.findById(id).get();
//        return ;
//    }
//
//    @Override
//    public User updateUserById(User user, Long id) {
//        user.setId(id);
////        return repository.save(user);
//    }
//
//    @Override
//    public void delete(User user, Long id) {
//        user.setId(id);
////        repository.delete(user);
//    }
//
//    @Override
//    public User findByName(String name) {
////        return repository.findByName(name);
//    }
//
//    @Override
//    public List<User> findByAgeGreaterThan(int age) {
////        return repository.findByAgeGreaterThan(age);
//    }
//
//    @Override
//    public List<User> findAll() {
////        List<User> userList =  new ArrayList<>();
////        repository.findAll().forEach(userList::add);
////        return userList;
//    }
}