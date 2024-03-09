package com.estoque.vendas.service;

import com.estoque.vendas.dto.*;
import com.estoque.vendas.entities.DadosBancarios;
import com.estoque.vendas.entities.Endereco;
import com.estoque.vendas.entities.Role;
import com.estoque.vendas.entities.Vendedor;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.projections.VendedorDatailsProjection;
import com.estoque.vendas.repository.VendedorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendedorService implements UserDetailsService {

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
        newVendedor.setSalarioBase(1500.0);

        newVendedor.setEndereco(new Endereco(enderecoDTO));
        newVendedor.setDadosBancarios(new DadosBancarios(dadosBancariosDTO));

        newVendedor = repository.save(newVendedor);

        return new VendedorDTO(newVendedor);
    }

    @Transactional
    public VendedorDTO atualizarSenha(AtualizarSenhaDTO dto) {
        Vendedor vendedor = repository.findById(dto.getCodVendedor()).orElseThrow();
        vendedor.setSenha(dto.getSenha());
        return new VendedorDTO(repository.save(vendedor));
    }

    @Transactional
    public VendedorDTO alterarDadosVendedor(AttDadosVendedor dto) throws RuntimeException {
        Vendedor vendedor = repository.findById(dto.getCodVendedor()).orElseThrow();

        BeanUtils.copyProperties(dto, vendedor);

        DadosBancariosDTO dadosBancariosDTO = dadosBancariosService.atualizarDadosBancarios(vendedor.getDadosBancarios().getCodDadosBancarios(), dto.getDadosBancarios());

        EnderecoDTO enderecoDTO = enderecoService.atualizarEndereco(vendedor.getEndereco().getCodEndereco(),new RegisterCepDTO(dto.getCep(),dto.getNumero()));

        vendedor.setEndereco(new Endereco(enderecoDTO));

        return new VendedorDTO(repository.save(vendedor));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<VendedorDatailsProjection> resultado= repository.searchVendedorAndRolesByEmail(username);
        if(resultado.size() == 0){
            throw new UsernameNotFoundException("Email not found");
        }

        Vendedor vendedor = new Vendedor();
        vendedor.setEmail(username);
        vendedor.setSenha(resultado.get(0).getSenha());
        for (VendedorDatailsProjection projection : resultado) {
            vendedor.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return vendedor;
    }
}
