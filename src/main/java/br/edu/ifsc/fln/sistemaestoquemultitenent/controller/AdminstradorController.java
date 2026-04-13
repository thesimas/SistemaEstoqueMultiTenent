package br.edu.ifsc.fln.sistemaestoquemultitenent.controller;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Administrador;
import br.edu.ifsc.fln.sistemaestoquemultitenent.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdminstradorController {

    @Autowired
    private AdministradorRepository administradorRepository;

    @PostMapping
    public Administrador adicionar(@RequestBody Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @GetMapping
    public List<Administrador> listar() {
        return administradorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Administrador buscarPorId(@PathVariable Integer id) {
        return administradorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Administrador atualizar(@PathVariable Integer id, @RequestBody Administrador categoria) {
        categoria.setId(id);
        return administradorRepository.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        administradorRepository.deleteById(id);
    }

}
