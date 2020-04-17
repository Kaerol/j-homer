package com.appliti.homer.bussiness.incoming.user.logout;

public interface LogoutFacade {

    void logout(final String authorization);
    void logoutByLogin(final String authorization);
}
