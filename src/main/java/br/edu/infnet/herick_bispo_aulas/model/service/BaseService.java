package br.edu.infnet.herick_bispo_aulas.model.service;

import br.edu.infnet.herick_bispo_aulas.model.domain.Identificavel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseService<T extends Identificavel> {

    private final Map<Long, T> dados = new HashMap<Long, T>();

    //Incluir
    public void incluir(T objeto){
        dados.put(objeto.getId(), objeto);
    }

    //Alterar
    public void alterar(T objeto){
        dados.put(objeto.getId(), objeto);
    }

    //Excluir
    public void excluir(Long id){
        dados.remove(id);
    }

    //Obter
    public Collection<T> obterLista(){
        return dados.values();
    }

    //Obter por ID
    public T obertPorId(Long id){
        return dados.get(id);
    }
}
