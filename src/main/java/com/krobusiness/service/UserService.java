package com.krobusiness.service;

import java.util.List;

import com.krobusiness.model.dto.AppClientSignUpDto;
import com.krobusiness.model.dto.BusinessRegisterDto;
import com.krobusiness.model.entities.AppClient;
import com.krobusiness.model.entities.BusinessOwner;
import com.krobusiness.model.entities.Hobby;
import com.krobusiness.model.entities.UserEntity;

public interface UserService {
    List<UserEntity> seedUsersAndUserRoles();

    AppClient register(AppClientSignUpDto user);

    BusinessOwner registerBusiness(BusinessRegisterDto business);

    BusinessOwner saveUpdatedUser(BusinessOwner businessOwner);

    AppClient saveUpdatedUserClient(AppClient appClient);

    UserEntity findUserById(Long userId);

    UserEntity findUserByEmail(String email);

    boolean deleteUser(Long id);

    BusinessOwner findBusinessOwnerById(Long id);

    UserEntity findUserByUsername(String username);

    boolean userExists(String username, String email);

    void saveUserWithUpdatedPassword(UserEntity userEntity);

    AppClient findAppClientById(Long clientId);

    void findAndRemoveHobbyFromClientsRecords(Hobby hobby);
    
    boolean businessExists(String businessName);

    AppClient findAppClientByUsername(String username);

    BusinessOwner findBusinessByUsername(String username);
}


