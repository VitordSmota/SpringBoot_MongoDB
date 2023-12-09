package com.vitormota.workshopmongo.services;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vitormota.workshopmongo.domain.User;
import com.vitormota.workshopmongo.dto.UserDTO;
import com.vitormota.workshopmongo.repository.UserRepository;
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


}
