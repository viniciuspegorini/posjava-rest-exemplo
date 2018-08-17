package br.edu.utfpr.pb.posjava.repository.impl;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.edu.utfpr.pb.posjava.model.Genero;
import br.edu.utfpr.pb.posjava.repository.GeneroRepository;

@Stateless
public class GeneroRepositoryImpl 
        extends AbstractRepositoryImpl<Genero, Long> 
        implements GeneroRepository {
}