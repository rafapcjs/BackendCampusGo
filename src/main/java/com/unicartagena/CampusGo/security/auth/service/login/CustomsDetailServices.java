package com.unicartagena.CampusGo.security.auth.service.login;


import com.unicartagena.CampusGo.security.auth.factory.AuthUserMapper;
import com.unicartagena.CampusGo.user.persistencie.entities.UserEntity;
import com.unicartagena.CampusGo.user.persistencie.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomsDetailServices implements UserDetailsService {


    private final UserRepository userRepository;
    private final AuthUserMapper authUserMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntityByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return authUserMapper.toUserDetails(userEntity);
    }
}