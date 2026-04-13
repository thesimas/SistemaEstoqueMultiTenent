package br.edu.ifsc.fln.sistemaestoquemultitenent.controller;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Cliente;
import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Movimentacao;
import br.edu.ifsc.fln.sistemaestoquemultitenent.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @PostMapping
    public Movimentacao adicionar(@RequestBody Movimentacao movimentacao, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        Cliente clienteLogado = new Cliente();
        clienteLogado.setId(clienteId);
        movimentacao.setCliente(clienteLogado);
        return movimentacaoRepository.save(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> listar(@RequestHeader ("id_cliente_logado") Integer clienteId) {
        return movimentacaoRepository.findByClienteId(clienteId);
    }

    @GetMapping("/{id}")
    public Movimentacao buscarPorId(@PathVariable Integer id, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        return movimentacaoRepository.findByIdAndClienteId(id, clienteId).orElse(null);
    }

    @PutMapping("/{id}")
    public Movimentacao atualizar(@PathVariable Integer id, @RequestHeader ("id_cliente_logado") Integer clienteId , @RequestBody Movimentacao movimentacao) {

        if(movimentacaoRepository.findByIdAndClienteId(id, clienteId).isPresent()) {
            Cliente clienteLogado = new Cliente();
            clienteLogado.setId(clienteId);
            movimentacao.setCliente(clienteLogado);
            movimentacao.setId(id);
            return movimentacaoRepository.save(movimentacao);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        Movimentacao movimentacao = movimentacaoRepository.findByIdAndClienteId(id, clienteId).orElse(null);

        if (movimentacao != null) {
            movimentacaoRepository.delete(movimentacao);
        }
    }
}
