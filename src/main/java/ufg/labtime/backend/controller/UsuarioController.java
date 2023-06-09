package ufg.labtime.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufg.labtime.backend.entity.Usuario;
import ufg.labtime.backend.repository.UsuarioRepository;
import ufg.labtime.backend.utils.CSVUtils;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/usuarios"})
@Tag(name = "usuarios", description = "API para manipulação da tabela de usuários")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final String UPDATE_SUCESS = "Base de dados atualizada";
    private final String UPDATE_ERROR = "Erro ao atualizar base de dados";

    @Operation(summary = "Lista todos os usuários")
    @GetMapping
    public List<Usuario> Get(@RequestParam Map<String, String> queryParameters) {
        if (MapUtils.isNotEmpty(queryParameters)) {
            if (!usuarioRepository.findByNomeCompletoContaining(queryParameters.get("filtro")).isEmpty())
                return usuarioRepository.findByNomeCompletoContaining(queryParameters.get("filtro"));
            if (!usuarioRepository.findByNomeSocialContaining(queryParameters.get("filtro")).isEmpty())
                return usuarioRepository.findByNomeSocialContaining(queryParameters.get("filtro"));
            if (!usuarioRepository.findByEmailContaining(queryParameters.get("filtro")).isEmpty())
                return usuarioRepository.findByEmailContaining(queryParameters.get("filtro"));
        }
        return usuarioRepository.findAll();
    }

    @Operation(summary = "Atualiza a base de dados lendo o arquivo csv")
    @GetMapping("/update")
    public String updateDatabase(HttpServletResponse response) {
        List<Usuario> usuarios = CSVUtils.parse();

        if (usuarios != null) {
            usuarioRepository.saveAll(usuarios);
            return UPDATE_SUCESS;
        }
        return UPDATE_ERROR;
    }

    @Operation(summary = "Obter o usuário através do id")
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return usuarioRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Adicionar usuário")
    @PostMapping
    public Usuario create(@RequestBody Usuario user){
        return usuarioRepository.save(user);
    }

    @Operation(summary = "Atualizar informaçoes usuário")
    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Usuario user) {
        return usuarioRepository.findById(id)
                .map(record -> {
                    record.setNomeCompleto(user.getNomeCompleto());
                    record.setNomeSocial(user.getNomeSocial());
                    record.setDataDeNascimento(user.getDataDeNascimento());
                    record.setCodigo(user.getCodigo());
                    record.setSexo(user.getSexo());
                    record.setEmail(user.getEmail());
                    record.setEstado(user.getEstado());
                    record.setMunicipio(user.getMunicipio());
                    record.setNumeroDeAcessos(user.getNumeroDeAcessos());
                    record.setSituacao(user.getSituacao());
                    record.setDataDeVinculo(user.getDataDeVinculo());
                    Usuario updated = usuarioRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar usuário")
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return usuarioRepository.findById(id)
                .map(record -> {
                    usuarioRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
