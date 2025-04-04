package com.unicartagena.CampusGo.user.service.implementation;

import com.unicartagena.CampusGo.user.factory.UserFactory;
import com.unicartagena.CampusGo.user.persistencie.repositories.UserRepository;
import com.unicartagena.CampusGo.user.service.interfaces.IUserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements IUserServices {

    private final UserRepository userRepository;
    private final UserFactory userFactory;




}