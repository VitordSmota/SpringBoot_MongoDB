package com.vitormota.workshopmongo.services;

import com.vitormota.workshopmongo.domain.Post;
import com.vitormota.workshopmongo.domain.User;
import com.vitormota.workshopmongo.repository.PostRepository;
import com.vitormota.workshopmongo.repository.UserRepository;
import com.vitormota.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String Id){
        Post post = repository.findById(Id).orElseThrow(() -> new  ObjectNotFoundException("Objeto não encontrado"));
        return post;
    }



}
