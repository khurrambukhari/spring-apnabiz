package com.krobusiness.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.krobusiness.model.entities.Hobby;
import com.krobusiness.model.entities.UserEntity;
import com.krobusiness.model.entities.enums.UserRoleEnum;
import com.krobusiness.service.HobbyService;
import com.krobusiness.service.UserRoleService;
import com.krobusiness.service.UserService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {
    private final HobbyService hobbyService;

    @Autowired
    public HomeController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @GetMapping("/home")
    @Operation(summary = "Show client/business homepage", security = @SecurityRequirement(name = "bearerAuth"))
    public Set<Hobby> hobbiesShow(@RequestParam String username, @RequestParam String role) {
        if (role.equals("user")) {
            return this.hobbyService.getAllHobbieMatchesForClient(username);
        }
        return this.hobbyService.getAllHobbiesForBusiness(username);
    }
}
