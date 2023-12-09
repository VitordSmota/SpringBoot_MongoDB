package com.vitormota.workshopmongo.resources;

import com.vitormota.workshopmongo.domain.User;
import com.vitormota.workshopmongo.dto.UserDTO;
import com.vitormota.workshopmongo.services.UserService;
import com.vitormota.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        Optional<User> user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user.get()));
    }
}
