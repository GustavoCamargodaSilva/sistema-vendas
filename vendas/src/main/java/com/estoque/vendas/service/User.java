package com.estoque.vendas.service;

import com.estoque.vendas.dto.*;
import com.estoque.vendas.entities.DadosBancarios;
import com.estoque.vendas.entities.Endereco;
import com.estoque.vendas.entities.Role;
import com.estoque.vendas.exceptions.RuntimeException;
import com.estoque.vendas.projections.VendedorDatailsProjection;
import com.estoque.vendas.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class User implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private DadosBancariosService dadosBancariosService;


    @Transactional
    public List<UserDTO> consultarVendedor() {
        List<com.estoque.vendas.entities.User> list = repository.findAll();
        return list.stream().map(UserDTO::new).toList();
    }

    @Transactional
    public UserDTO consultarVendedorCodvendedor(Long id) {
        com.estoque.vendas.entities.User user = repository.findById(id).orElseThrow();
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, com.estoque.vendas.entities.User entityDTO) {
        com.estoque.vendas.entities.User user = repository.findById(id).orElseThrow();
        BeanUtils.copyProperties(entityDTO, user);
        return new UserDTO(repository.save(user));
    }

    @Transactional
    public UserDTO insert(CadastroVendedorDTO entityDTO) throws RuntimeException {
        EnderecoDTO enderecoDTO = enderecoService.cadastrarEndereco(entityDTO.getCep(), entityDTO.getNumero());
        DadosBancariosDTO dadosBancariosDTO = dadosBancariosService.cadastrarDadosBancarios(entityDTO.getDadosBancarios());

        com.estoque.vendas.entities.User newUser = new com.estoque.vendas.entities.User();
        BeanUtils.copyProperties(entityDTO, newUser);
        newUser.setPassword("123456");
        newUser.setSalarioBase(1500.0);

        newUser.setEndereco(new Endereco(enderecoDTO));
        newUser.setDadosBancarios(new DadosBancarios(dadosBancariosDTO));

        newUser = repository.save(newUser);

        return new UserDTO(newUser);
    }

    @Transactional
    public UserDTO atualizarSenha(AtualizarSenhaDTO dto) {
        com.estoque.vendas.entities.User user = repository.findById(dto.getId()).orElseThrow();
        user.setPassword(dto.getSenha());
        return new UserDTO(repository.save(user));
    }

    @Transactional
    public UserDTO alterarDadosVendedor(AttDadosVendedor dto) throws RuntimeException {
        com.estoque.vendas.entities.User user = repository.findById(dto.getCodVendedor()).orElseThrow();

        BeanUtils.copyProperties(dto, user);

        DadosBancariosDTO dadosBancariosDTO = dadosBancariosService.atualizarDadosBancarios(user.getDadosBancarios().getCodDadosBancarios(), dto.getDadosBancarios());

        EnderecoDTO enderecoDTO = enderecoService.atualizarEndereco(user.getEndereco().getCodEndereco(),new RegisterCepDTO(dto.getCep(),dto.getNumero()));

        user.setEndereco(new Endereco(enderecoDTO));

        return new UserDTO(repository.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<VendedorDatailsProjection> resultado= repository.searchVendedorAndRolesByEmail(username);
        if(resultado.size() == 0){
            throw new UsernameNotFoundException("Email not found");
        }

        com.estoque.vendas.entities.User user = new com.estoque.vendas.entities.User();
        user.setEmail(username);
        user.setPassword(resultado.get(0).getPassword());
        for (VendedorDatailsProjection projection : resultado) {
            user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return user;
    }
}
