package com.estoque.vendas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tb_vendedor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vendedor implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codVendedor;
    private String nome;
    private LocalDate dataNascimento;
    @Column(unique = true)
    private String email;
    private String password;
    private String telefone;
    private Double salarioBase;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.PERSIST)
    private DadosBancarios dadosBancarios;

    @OneToMany(mappedBy = "vendedor")
    private List<Venda> vendas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_vendedor_role",
            joinColumns = @JoinColumn(name = "vendedor_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasRole(String roleName) {
        for (Role role : roles) {
            if (role.getAuthority().equals(roleName)) {
                return true;
            }
        }
        return false;
    }
}
