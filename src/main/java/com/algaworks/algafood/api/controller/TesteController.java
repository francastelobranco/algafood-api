package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial,
                                                      BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorNome(String nome) {
        return restauranteRepository.findByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/por-nome-e-cozinha-id")
    public List<Restaurante> restaurantesPorNomeECozinhaId(String nome, Long id) {
        return restauranteRepository.findByNomeContainingAndCozinhaId(nome, id);
    }
}
