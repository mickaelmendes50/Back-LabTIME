package ufg.labtime.backend.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ufg.labtime.backend.entity.Usuario;
import ufg.labtime.backend.repository.UserRepository;
import ufg.labtime.backend.utils.CSVUtils;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final String UPDATE_SUCESS = "Base de dados atualizada";
    private final String UPDATE_ERROR = "Erro ao atualizar base de dados";

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> Get() {
        return userRepository.findAll();
    }

    @GetMapping("usuarios/update")
    public String updateDatabase(HttpServletResponse response) {
        List<Usuario> usuarios = CSVUtils.parse();

        if (usuarios != null) {
            userRepository.saveAll(usuarios);
            return UPDATE_SUCESS;
        }
        return UPDATE_ERROR;
    }
}
