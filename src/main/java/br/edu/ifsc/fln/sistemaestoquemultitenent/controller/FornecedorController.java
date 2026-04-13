package br.edu.ifsc.fln.sistemaestoquemultitenent.controller;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Cliente;
import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Fornecedor;
import br.edu.ifsc.fln.sistemaestoquemultitenent.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping
    public Fornecedor adicionar(@RequestBody Fornecedor fornecedor, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        Cliente clienteLogado = new Cliente();
        clienteLogado.setId(clienteId);
        fornecedor.setCliente(clienteLogado);
        return fornecedorRepository.save(fornecedor);
    }

    @GetMapping
    public List<Fornecedor> listar(@RequestHeader ("id_cliente_logado") Integer clienteId) {
        return fornecedorRepository.findByClienteId(clienteId);
    }

    @GetMapping("/{id}")
    public Fornecedor buscarPorId(@PathVariable Integer id, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        return fornecedorRepository.findByIdAndClienteId(id, clienteId).orElse(null);
    }

    @PutMapping("/{id}")
    public Fornecedor atualizar(@PathVariable Integer id, @RequestHeader ("id_cliente_logado") Integer clienteId, @RequestBody Fornecedor fornecedor) {

        if(fornecedorRepository.findByIdAndClienteId(id, clienteId).isPresent()) {
            Cliente clienteLogado = new Cliente();
            clienteLogado.setId(clienteId);
            fornecedor.setCliente(clienteLogado);
            fornecedor.setId(id);
            return fornecedorRepository.save(fornecedor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        Fornecedor fornecedor = fornecedorRepository.findByIdAndClienteId(id, clienteId).orElse(null);
        if (fornecedor != null) {
            fornecedorRepository.deleteById(id);
        }
    }
}
