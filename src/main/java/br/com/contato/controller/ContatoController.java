package br.com.contato.controller;

import br.com.contato.entity.Contato;
import br.com.contato.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("api/v1/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    //Inserir novo contato
    @PostMapping(name = "Inserir novo contato", consumes = "application/json")
    public ResponseEntity<?> newContato ( @RequestBody Contato contato){
        return new ResponseEntity<Contato>(contatoService.newContato(contato), HttpStatus.CREATED);
    }

    @PutMapping(path = ("/atualizar_por_id"), name = "Atualizar contato por ID", consumes = "application/json")
    public ResponseEntity<?> updateContatoById ( @RequestBody Contato contato, @RequestParam("id") @NotBlank Long id){
        return ResponseEntity.ok().body(contatoService.updateContatoById(contato, id));
    }

    //Deletar contato por Id
    @DeleteMapping(path = "/deletar_por_id", name = "Deletar contato por ID")
    public ResponseEntity<?> deleteContatoById ( @RequestParam("id") @NotBlank Long id){
        contatoService.deleteContatoById(id);
        return ResponseEntity.ok().build();
    }

    //Listar contato por id
    @GetMapping(path = ("/buscar_por_id"), name = "Buscar contato por ID")
    public ResponseEntity<Contato> searchContatoById ( @RequestParam("id") @NotBlank Long id){
        return ResponseEntity.ok().body(contatoService.searchContatoById(id));
    }

    //Listar todos contatos
    @GetMapping(name = "Listar contatos")
    public ResponseEntity<List<Contato>> listContatos(){
        return ResponseEntity.ok().body(contatoService.listContato());
    }
}
