package ufg.labtime.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ufg.labtime.backend.entity.Usuario;
import ufg.labtime.backend.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> Get() {
        return userRepository.findAll();
    }
}
