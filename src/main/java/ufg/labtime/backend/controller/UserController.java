package ufg.labtime.backend.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ufg.labtime.backend.entity.Usuario;
import ufg.labtime.backend.repository.UserRepository;
import ufg.labtime.backend.utils.CSVUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final String UPDATE_SUCESS = "Base de dados atualizada";
    private final String UPDATE_ERROR = "Erro ao atualizar base de dados";

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> Get(@RequestParam Map<String, String> queryParameters) {
        if (MapUtils.isNotEmpty(queryParameters)) {
            if (!userRepository.findByFullNameContaining(queryParameters.get("filtro")).isEmpty())
                return userRepository.findByFullNameContaining(queryParameters.get("filtro"));
            if (!userRepository.findBySocialNameContaining(queryParameters.get("filtro")).isEmpty())
                return userRepository.findBySocialNameContaining(queryParameters.get("filtro"));
            if (!userRepository.findByEmailContaining(queryParameters.get("filtro")).isEmpty())
                return userRepository.findByEmailContaining(queryParameters.get("filtro"));
        }
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
