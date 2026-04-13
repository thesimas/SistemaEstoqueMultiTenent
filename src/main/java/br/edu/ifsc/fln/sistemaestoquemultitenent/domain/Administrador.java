package br.edu.ifsc.fln.sistemaestoquemultitenent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonPropertyOrder({"id","nome", "tipoUsuario" ,"cliente"})
public class Administrador extends Usuario {

    // Vai deletar em modo cascata, vai deletar todos os clientes.
    //@OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "administrador")
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
