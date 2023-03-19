package com.krobusiness.service;

import com.krobusiness.model.entities.UserRoleEntity;
import com.krobusiness.model.entities.enums.UserRoleEnum;

public interface UserRoleService {
    UserRoleEntity getUserRoleByEnumName(UserRoleEnum userRoleEnum);

    UserRoleEntity saveRole(UserRoleEntity userRoleEntity);
}
