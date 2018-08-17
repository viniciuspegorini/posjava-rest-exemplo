package br.edu.utfpr.pb.posjava.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.edu.utfpr.pb.posjava.model.Produtora;
import br.edu.utfpr.pb.posjava.repository.ProdutoraRepository;
import br.edu.utfpr.pb.posjava.repository.Repository;
import javax.inject.Inject;

@Controller
@Path("produtora")
public class ProdutoraController extends AbstractController<Produtora, Long>{

    @Inject
    private ProdutoraRepository produtoraRepository;
    
    @Override
    protected Repository getRepository(){
        return produtoraRepository;
    }
}
