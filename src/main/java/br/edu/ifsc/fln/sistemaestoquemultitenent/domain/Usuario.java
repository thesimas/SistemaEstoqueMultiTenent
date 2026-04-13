package br.edu.ifsc.fln.sistemaestoquemultitenent.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) /*
Essa anotação irá criar Tabelas separadas para a classe MÂE e as classes Filhas
e irá se comunicar entre elas com as chaves estrangeiras, fazendo joins nas queries.
*/
public abstract class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private ETipoUser tipoUsuario;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ETipoUser getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(ETipoUser tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return getId() == usuario.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
