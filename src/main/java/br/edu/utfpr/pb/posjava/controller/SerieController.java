package br.edu.utfpr.pb.posjava.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.pb.posjava.model.Serie;
import br.edu.utfpr.pb.posjava.repository.Repository;
import br.edu.utfpr.pb.posjava.repository.SerieRepository;
import javax.inject.Inject;

@Controller
@Path(value = "serie")
public class SerieController extends AbstractController<Serie, Long>{
   
    @Inject
    private SerieRepository serieRepository;
    
    @Override
    protected Repository getRepository(){
        return serieRepository;
    }

    @Override
    @Get
    @Path(value = {"", "/"})
    public void findAll() {
        result.use(Results.json()).withoutRoot()
                .from(getRepository().findAll())
                .include("genero")
                .include("produtora")
                .serialize();
    }

    @Override
    @Get
    @Path(value = "/page/")
    public void findAllPaged(int page, int size) {
        result.use(Results.json()).withoutRoot()
                .from(getRepository().findAll(page, size))
                .include("genero")
                .include("produtora")
                .serialize();
    }
    
    
    
}
