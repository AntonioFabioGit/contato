package br.com.contato.controller;

import br.com.contato.entity.Contato;
import br.com.contato.service.ContatoService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Inserir novo contato")
    @PostMapping( consumes = "application/json")
    public ResponseEntity<?> newContato ( @RequestBody Contato contato){
        return new ResponseEntity<Contato>(contatoService.newContato(contato), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualizar contato por ID")
    @PutMapping(path = ("/atualizar_por_id"), consumes = "application/json")
    public ResponseEntity<?> updateContatoById ( @RequestBody Contato contato, @RequestParam("id") @NotBlank Long id){
        return ResponseEntity.ok().body(contatoService.updateContatoById(contato, id));
    }

    @ApiOperation(value = "Deletar contato por ID")
    @DeleteMapping(path = "/deletar_por_id", name = "Deletar contato por ID")
    public ResponseEntity<?> deleteContatoById ( @RequestParam("id") @NotBlank Long id){
        contatoService.deleteContatoById(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Buscar contato por ID")
    @GetMapping(path = ("/buscar_por_id"))
    public ResponseEntity<Contato> searchContatoById ( @RequestParam("id") @NotBlank Long id){
        return ResponseEntity.ok().body(contatoService.searchContatoById(id));
    }

    @ApiOperation(value = "Listar todos contatos")
    @GetMapping
    public ResponseEntity<List<Contato>> listContatos(){
        return ResponseEntity.ok().body(contatoService.listContato());
    }
}
