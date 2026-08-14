package br.edu.infnet.herick_bispo_aulas.service;

import br.edu.infnet.herick_bispo_aulas.domain.Identificavel;
import br.edu.infnet.herick_bispo_aulas.exception.IdentificadorDuplicadoException;

import java.util.*;

public abstract class BaseService<T extends Identificavel> {

    private final Map<Long, T> dados = new HashMap<Long, T>();


    //Incluir
    public void incluir(T objeto){

        validarObjeto(objeto);

        if(dados.containsKey(objeto.getId())){
            throw new IdentificadorDuplicadoException("Já existe um objeto com este identificador");
        }

        dados.put(objeto.getId(), objeto);
    }

    //Alterar
    public void alterar(T objeto){

        validarObjeto(objeto);

        verificarExistencia(objeto.getId());

        dados.put(objeto.getId(), objeto);
    }

    //Excluir
    public void excluir(Long id){

        verificarExistencia(id);

        dados.remove(id);
    }

    //Obter
    public List<T> obterLista(){

        return new ArrayList<T>(dados.values());
    }

    //Obter por ID
    public T obertPorId(Long id){

        verificarExistencia(id);

        return dados.get(id);
    }

    private void validarObjeto(T objeto){

        if(objeto == null){
            throw new IllegalArgumentException("O objeto não pode ser nulo.");
        }

        if(objeto.getId() == null){
            throw new IllegalArgumentException("O identificador do objeto não pode ser nulo.");
        }
    }

    private void verificarExistencia(Long id){

        if(id == null){
            throw new IllegalArgumentException("O identificador não pode ser nulo.");
        }

        if(!dados.containsKey(id)){
            throw new IllegalArgumentException("Nenhum recurso encontrado para esse identificador" + id + ".");
        }
    }
}
