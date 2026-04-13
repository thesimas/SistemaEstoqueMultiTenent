package br.edu.ifsc.fln.sistemaestoquemultitenent.controller;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Categoria;
import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Cliente;
import br.edu.ifsc.fln.sistemaestoquemultitenent.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public Categoria adicionar(@RequestBody Categoria categoria, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        Cliente clienteLogado = new Cliente();
        clienteLogado.setId(clienteId);
        categoria.setCliente(clienteLogado);
        return categoriaRepository.save(categoria);
    }

    @GetMapping
    public List<Categoria> listar(@RequestHeader ("id_cliente_logado") Integer clienteId) {
        return categoriaRepository.findByClienteId(clienteId);
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Integer id, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        return categoriaRepository.findByIdAndClienteId(id, clienteId).orElse(null);
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Integer id, @RequestHeader ("id_cliente_logado") Integer clienteId, @RequestBody Categoria categoria) {
        if(categoriaRepository.findByIdAndClienteId(id, clienteId).isPresent()) {
            Cliente clienteLogado = new Cliente();
            clienteLogado.setId(clienteId);
            categoria.setCliente(clienteLogado);
            categoria.setId(id);
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        Categoria categoria = categoriaRepository.findByIdAndClienteId(id, clienteId).orElse(null);

        if (categoria != null) {
            categoriaRepository.delete(categoria);
        }
    }
}