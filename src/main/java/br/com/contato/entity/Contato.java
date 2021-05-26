package br.com.contato.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name="CONTATOS")
public class Contato implements Serializable {

    private static final long serialVersionUID = 5357712845564399596L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable = false)
   // @JsonIgnore
    private Long id;

    private String nome;

    private String telefone;

    private String email;
}
