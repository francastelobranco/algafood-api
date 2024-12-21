package com.algaworks.algafood.infraestructure.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {


    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> listar() {
        return manager.createQuery("from Cozinha", Restaurante.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Restaurante salvar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    public Restaurante buscar(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Override
    @Transactional
    public void remover(Restaurante restaurante){
        restaurante = buscar(restaurante.getId());
        manager.remove(restaurante);
    }
}
