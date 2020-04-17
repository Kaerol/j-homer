package com.appliti.homer.infractruture.http.filter.authenticate;

import lombok.RequiredArgsConstructor;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.appliti.homer.bussiness.incoming.user.logout.LogoutFacade;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LogoutListener implements ApplicationListener<SessionDestroyedEvent> {

    private final LogoutFacade logoutFacade;

    @Override
    public void onApplicationEvent(final SessionDestroyedEvent event) {
        final List<SecurityContext> lstSecurityContext = event.getSecurityContexts();
        UserDetails userDetails;
        for (final SecurityContext securityContext : lstSecurityContext) {
            userDetails = (UserDetails) securityContext.getAuthentication()
                                                       .getPrincipal();

            logoutFacade.logoutByLogin(userDetails.getUsername());
        }
    }
}
