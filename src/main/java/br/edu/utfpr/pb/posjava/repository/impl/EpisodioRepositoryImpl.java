package br.edu.utfpr.pb.posjava.repository.impl;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.edu.utfpr.pb.posjava.model.Episodio;
import br.edu.utfpr.pb.posjava.repository.EpisodioRepository;

@Stateless
public class EpisodioRepositoryImpl 
        extends AbstractRepositoryImpl<Episodio, Long> 
        implements EpisodioRepository {
}