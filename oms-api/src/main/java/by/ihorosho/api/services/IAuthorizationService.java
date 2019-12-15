package by.ihorosho.api.services;

import by.ihorosho.api.services.dto.AuthorizationDto;

public interface IAuthorizationService {

    Boolean isExist(String login);

    Long isAuthorized(String token);

    String logIn(AuthorizationDto authorizationDto) throws IllegalAccessException;

    void logOut(String token);
}
