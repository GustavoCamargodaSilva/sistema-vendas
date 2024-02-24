package com.estoque.vendas.Util;

import com.estoque.vendas.dto.EnderecoDTO;
import com.estoque.vendas.exceptions.RuntimeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumoApiCep {

    @Value("${app.key.path-apicep}")
    private String pathApiCep;

    public EnderecoDTO consultarCep(String cep) throws RuntimeException {
            RestTemplate restTemplate = new RestTemplate();
            RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
            restTemplate = restTemplateBuilder.build();

            EnderecoDTO dto = restTemplate.getForObject(pathApiCep.concat(cep) + "/json", EnderecoDTO.class);
            dto.setCep(dto.getCep().replace("-", ""));
            return dto;
    }
}
