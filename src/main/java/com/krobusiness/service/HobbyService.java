package com.krobusiness.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.krobusiness.model.entities.AppClient;
import com.krobusiness.model.entities.Hobby;

public interface HobbyService {
    Hobby findHobbieById(Long id);

    void saveUpdatedHobby(Hobby hobby) throws Exception;

    boolean deleteHobby(long id) throws Exception;

    Set<Hobby> findHobbyMatches(String username);

    boolean saveHobbyForClient(Hobby hobby, String username);

    boolean removeHobbyForClient(Hobby hobby, String username);

    boolean isHobbySaved(Long hobbyId, String username);

    List<Hobby> findSavedHobbies(AppClient appClient);

    Set<Hobby> getAllHobbiesForBusiness(String username);
    
    Set<Hobby> getAllHobbieMatchesForClient(String username);

    void createHobby(Hobby offer);
}
