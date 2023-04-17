package ufg.labtime.backend.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ufg.labtime.backend.entity.Usuario;
import ufg.labtime.backend.repository.UsuarioRepository;
import ufg.labtime.backend.utils.CSVUtils;

import java.util.List;
import java.util.Map;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final String UPDATE_SUCESS = "Base de dados atualizada";
    private final String UPDATE_ERROR = "Erro ao atualizar base de dados";

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> Get(@RequestParam Map<String, String> queryParameters) {
        if (MapUtils.isNotEmpty(queryParameters)) {
            if (!usuarioRepository.findByFullNameContaining(queryParameters.get("filtro")).isEmpty())
                return usuarioRepository.findByFullNameContaining(queryParameters.get("filtro"));
            if (!usuarioRepository.findBySocialNameContaining(queryParameters.get("filtro")).isEmpty())
                return usuarioRepository.findBySocialNameContaining(queryParameters.get("filtro"));
            if (!usuarioRepository.findByEmailContaining(queryParameters.get("filtro")).isEmpty())
                return usuarioRepository.findByEmailContaining(queryParameters.get("filtro"));
        }
        return usuarioRepository.findAll();
    }

    @GetMapping("usuarios/update")
    public String updateDatabase(HttpServletResponse response) {
        List<Usuario> usuarios = CSVUtils.parse();

        if (usuarios != null) {
            usuarioRepository.saveAll(usuarios);
            return UPDATE_SUCESS;
        }
        return UPDATE_ERROR;
    }
}
