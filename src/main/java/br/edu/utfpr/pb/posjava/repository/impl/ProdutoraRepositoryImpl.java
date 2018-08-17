package br.edu.utfpr.pb.posjava.repository.impl;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.edu.utfpr.pb.posjava.model.Produtora;
import br.edu.utfpr.pb.posjava.repository.ProdutoraRepository;

@Stateless
public class ProdutoraRepositoryImpl 
        extends AbstractRepositoryImpl<Produtora, Long> 
        implements ProdutoraRepository {
}