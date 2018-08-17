package br.edu.utfpr.pb.posjava.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.edu.utfpr.pb.posjava.model.Genero;
import br.edu.utfpr.pb.posjava.repository.GeneroRepository;
import br.edu.utfpr.pb.posjava.repository.Repository;

@Controller
@Path("/genero")
public class GeneroController extends AbstractController<Genero, Long>{

    @Inject
    private GeneroRepository generoRepository;
    
    @Override
    protected Repository getRepository(){
        return generoRepository;
    }
}







