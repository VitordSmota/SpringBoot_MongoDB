package com.vitormota.workshopmongo.services;

import com.vitormota.workshopmongo.domain.User;
import com.vitormota.workshopmongo.dto.UserDTO;
import com.vitormota.workshopmongo.repository.UserRepository;
import com.vitormota.workshopmongo.resources.exception.StandardError;
import com.vitormota.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }
    public Optional<User> findById(String Id){
        Optional<User> user = repository.findById(Id);
        if (user.isEmpty()) throw new ObjectNotFoundException("Objeto não encontrado");
        return user;
    }
    public User insert(User obj){
        return repository.insert(obj);
    }

    public void delete(String id){
        repository.deleteById(id);
    }
    public User update(User obj){
        User newObj = repository.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Não encontrado" + obj));
        updateData(newObj,obj);
        return repository.save(newObj);
    }

    public void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }


}
