package service;

import model.SocialAccount;

public interface SocialService {

    String getAuthorizeUrl();

    SocialAccount getSocialAccount(String authToken);
}
