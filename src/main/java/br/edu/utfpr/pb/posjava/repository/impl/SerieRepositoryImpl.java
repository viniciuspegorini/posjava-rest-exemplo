package br.edu.utfpr.pb.posjava.repository.impl;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.edu.utfpr.pb.posjava.model.Serie;
import br.edu.utfpr.pb.posjava.repository.SerieRepository;

@Stateless
public class SerieRepositoryImpl 
        extends AbstractRepositoryImpl<Serie, Long> 
        implements SerieRepository {
}