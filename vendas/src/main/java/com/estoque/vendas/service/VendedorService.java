package com.estoque.vendas.service;

import com.estoque.vendas.dto.CadastroVendedorDTO;
import com.estoque.vendas.dto.DadosBancariosDTO;
import com.estoque.vendas.dto.EnderecoDTO;
import com.estoque.vendas.dto.VendedorDTO;
import com.estoque.vendas.entities.DadosBancarios;
import com.estoque.vendas.entities.Endereco;
import com.estoque.vendas.entities.Vendedor;
import com.estoque.vendas.enums.UserRole;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.repository.VendedorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private DadosBancariosService dadosBancariosService;

    @Transactional
    public List<VendedorDTO> consultarVendedor() {
        List<Vendedor> list = repository.findAll();
        return list.stream().map(VendedorDTO::new).toList();
    }

    @Transactional
    public VendedorDTO consultarVendedorCodvendedor(Long id) {
        Vendedor vendedor = repository.findById(id).orElseThrow();
        return new VendedorDTO(vendedor);
    }

    @Transactional
    public VendedorDTO update(Long id, Vendedor entityDTO) {
        Vendedor vendedor = repository.findById(id).orElseThrow();
        BeanUtils.copyProperties(entityDTO, vendedor);
        return new VendedorDTO(repository.save(vendedor));
    }

    @Transactional
    public VendedorDTO insert(CadastroVendedorDTO entityDTO) throws RuntimeException {
        EnderecoDTO enderecoDTO = enderecoService.cadastrarEndereco(entityDTO.getCep(), entityDTO.getNumero());
        DadosBancariosDTO dadosBancariosDTO = dadosBancariosService.cadastrarDadosBancarios(entityDTO.getDadosBancarios());

        Vendedor newVendedor = new Vendedor();
        BeanUtils.copyProperties(entityDTO, newVendedor);
        newVendedor.setSenha("123456");
        newVendedor.setRole(UserRole.VENDEDOR);
        newVendedor.setSalarioBase(1500.0);



        newVendedor.setEndereco(new Endereco(enderecoDTO));
        newVendedor.setDadosBancarios(new DadosBancarios(dadosBancariosDTO));

        newVendedor = repository.save(newVendedor);

        return new VendedorDTO(newVendedor);
    }

}
