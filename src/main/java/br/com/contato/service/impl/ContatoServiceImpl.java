package br.com.contato.service.impl;

import br.com.contato.entity.Contato;
import br.com.contato.exception.ContatoNotFoundException;
import br.com.contato.repository.ContatoRepository;
import br.com.contato.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    @Override
    public Contato newContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Optional<Contato> updateContatoById(Contato contato, Long id) {
        return contatoRepository
                .findById(id)
                .map(updateContato -> {
                    updateContato.setNome(contato.getNome());
                    updateContato.setTelefone(contato.getTelefone());
                    updateContato.setEmail(contato.getEmail());
                    contatoRepository.save(updateContato);
                    return contatoRepository.findById(id);
                }).orElseThrow(()-> new ContatoNotFoundException("Id nao localizado"));
    }

    @Override
    public Contato searchContatoById(Long id) {
        return contatoRepository.findById(id).orElseThrow(()->new ContatoNotFoundException("Id nao localizado"));
    }

    @Override
    public List<Contato> listContato() {
        List<Contato> listContatos = new ArrayList<>();
        contatoRepository.findAll().forEach(listContatos::add);
        return listContatos;
    }

    @Override
    public void deleteContatoById(Long id) {
        contatoRepository.findById(id).orElseThrow(()-> new ContatoNotFoundException("Id nao localizado"));
        contatoRepository.deleteById(id);
    }
}
