package by.ihorosho.web.rest;

import by.ihorosho.api.services.IAuthorizationService;
import by.ihorosho.api.services.dto.AuthorizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthorizationController {
    private IAuthorizationService authorizationService;

    @Autowired
    public void setAuthorizationService(IAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("login")
    public String login(@RequestBody AuthorizationDto dto) throws IllegalAccessException {
        return authorizationService.logIn(dto);
    }
}
