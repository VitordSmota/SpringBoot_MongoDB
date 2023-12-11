package com.vitormota.workshopmongo.resources;

import com.vitormota.workshopmongo.domain.Post;
import com.vitormota.workshopmongo.domain.User;
import com.vitormota.workshopmongo.dto.UserDTO;
import com.vitormota.workshopmongo.services.PostService;
import com.vitormota.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }


}
