package br.edu.utfpr.pb.posjava.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.pb.posjava.model.AbstractModel;
import br.edu.utfpr.pb.posjava.repository.Repository;
import java.io.Serializable;
import javax.inject.Inject;
import javax.validation.Valid;

public abstract class AbstractController<T extends AbstractModel, ID extends Serializable> {

    protected abstract Repository getRepository();
    @Inject
    protected Result result;
    @Inject
    protected Validator validator;

    @Get
    @Path(value = {"", "/"})
    public void findAll() {
        result.use(Results.json())
                .withoutRoot()
                .from(getRepository().findAll())
                .serialize();
    }

    @Get
    @Path(value = {"/page/"})
    public void findAllPaged(int page, int size) {
        result.use(Results.json()).withoutRoot()
                .from(getRepository().findAll(page, size))
                .serialize();
    }

    @Get
    @Path(value = "/total/")
    public void getTotalRecords() {
        result.use(Results.json()).withoutRoot()
                .from(getRepository().getTotalRecords())
                .serialize();
    }

    @Get
    @Path(value = "/{id}")
    public void findOne(ID id) {
        AbstractModel model = getRepository().findOne(id);
        if (model == null) {
            result.use(Results.status()).ok();
        } else {
            result.use(Results.json()).withoutRoot()
                    .from(model).serialize();
        }
    }

    @Delete
    @Path(value = "/{id}")
    public void remove(ID id) {
        try {
            getRepository().remove(id);
            result.use(Results.status()).ok();
        } catch (Exception e) {
            result.use(Results.status()).badRequest("Erro ao remover registro");
        }

    }

    @Delete
    @Path(value = "/")
    @Consumes(value = "application/json", options = WithoutRoot.class)
    public void remove(T entity) {
        getRepository().remove(entity.getId());
        result.use(Results.status()).ok();
    }
    
    @Post
    @Path(value = {"","/"})
    @Consumes(value = "application/json", options = WithoutRoot.class)
    public void save(@Valid T entity){
        validator.onErrorSendBadRequest();
        
        getRepository().save(entity);
        
        result.use(Results.status()).ok();
        //result.use(Results.json()).withoutRoot().from(entity).serialize();
    }

}
