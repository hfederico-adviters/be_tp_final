package com.adviters.bootcamp.TpFinal.entities;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "UserTable")
@Table(name = "user_table")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "fk_user")
    private Long idUser;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "dni")
    private String dni;

    @Column(name = "cuil")
    private String cuil;

    @Column(name = "email")
    private String email;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "address")
    private String address;

    @Column(name = "address_number")
    private Integer addressNumber;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "tower")
    private String tower;

    @Column(name = "floor")
    private String floor;

    @Column(name = "flat")
    private String flat;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "country")
    private String country;

    @Column(name = "holidays")
    private Integer holidays;

    @Column(name = "administrator")
    private Boolean administrator;

    @Enumerated(EnumType.STRING)
    private Role role;

    /*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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
    }*/
}
