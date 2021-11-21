package com.salesianostriana.dam.Proyecto3SpringSecurity.users.services;

import com.salesianostriana.dam.Proyecto3SpringSecurity.services.base.BaseService;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserRole;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.repository.UserEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.repositorio.findFirstByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(email + " no encontrado"));
    }

    public UserEntity save (CreatedUserDto newUser) {
        if (newUser.getPassword().contentEquals(newUser.getPassword2())) {
            UserEntity userEntity = UserEntity.builder()
                    .password(passwordEncoder.encode(newUser.getPassword()))
                    .avatar(newUser.getAvatar())
                    .fullName(newUser.getFullName())
                    .email(newUser.getEmail())
                    .role(UserRole.USER)
                    .build();
            return save(userEntity);
        } else {
            return null;
        }
    }
}
