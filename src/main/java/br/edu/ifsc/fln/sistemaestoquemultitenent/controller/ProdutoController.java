package br.edu.ifsc.fln.sistemaestoquemultitenent.controller;

import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Cliente;
import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Movimentacao;
import br.edu.ifsc.fln.sistemaestoquemultitenent.domain.Produto;
import br.edu.ifsc.fln.sistemaestoquemultitenent.repository.MovimentacaoRepository;
import br.edu.ifsc.fln.sistemaestoquemultitenent.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto, @RequestHeader ("id_cliente_logado") Integer clienteId) {
        Cliente clienteLogado = new Cliente();
        clienteLogado.setId(clienteId);
        /* Criando um objeto Cliente para garantir que no banco de dados, esse produto seja vinculado ao cliente!*/
        produto.setCliente(clienteLogado);
        Produto produtoCriado = produtoRepository.save(produto);

        // Lógica para registrar a movimentação do produto ao adcionar ele na aplicação!
        if(produtoCriado.getQuantidade() > 0){
            Movimentacao movimentacao = new Movimentacao();
            movimentacao.setDescricao("Entrada Inicial de Produto via Cadastro");
            movimentacao.setQuantidade(produtoCriado.getQuantidade());
            movimentacao.setData(new java.util.Date());
            movimentacao.setProduto(produtoCriado);
            movimentacao.setCliente(clienteLogado);
            movimentacaoRepository.save(movimentacao);
        }
        return produtoCriado;
    }

    @GetMapping
    public List<Produto> listar(@RequestHeader ("id_cliente_logado") Integer clienteId) {
        return produtoRepository.findByClienteId(clienteId);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(
            @PathVariable Integer id,
            @RequestHeader("id_cliente_logado") Integer clienteId) {

        return produtoRepository.findByIdAndClienteId(id, clienteId).orElse(null);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Integer id, @RequestHeader("id_cliente_logado") Integer clienteId, @RequestBody Produto produto) {

        if(produtoRepository.findByIdAndClienteId(id, clienteId).isPresent()) {
            Cliente clienteLogado = new Cliente();
            clienteLogado.setId(clienteId);
            produto.setCliente(clienteLogado);
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        return  null;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id, @RequestHeader("id_cliente_logado") Integer clienteId) {
        /* Criando um objeto do tipo Produto, para executar uma querry e
        garantir que a aquele produto buscado é do cliente que está logado na aplicação.*/

        Produto produto = produtoRepository.findByIdAndClienteId(id, clienteId).orElse(null);

        if (produto != null) {
            produtoRepository.delete(produto);
        }
    }
}
