package ufg.labtime.backend.controller;

import com.opencsv.CSVParser;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ufg.labtime.backend.entity.Usuario;
import ufg.labtime.backend.repository.UserRepository;
import ufg.labtime.backend.utils.CSVUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final String UPDATE = "Base de dados atualizada";

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> Get() {
        return userRepository.findAll();
    }

    @GetMapping("usuarios/update")
    public String updateDatabase(HttpServletResponse response) throws IOException {
        List<Usuario> usuarios = CSVUtils.parse();
        userRepository.saveAll(usuarios);
        return UPDATE;
    }
}
