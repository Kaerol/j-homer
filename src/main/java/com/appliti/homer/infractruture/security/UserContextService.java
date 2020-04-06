package com.appliti.homer.infractruture.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserContextService {

    private static final String FORBIDDEN_ACCESS = "Forbidden access";
    private static final String AUTHORITY_PREFIX = "ROLE_";

    public static String getCallerHeader() {
        final Authentication auth = getAuthentication();
        if (Objects.isNull(auth)) {
            return null;
        }

        final List<String> roles = new ArrayList<>();
        final Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        authorities.forEach(authority -> roles.add(authority.getAuthority()
                                                            .trim()
                                                            .replace(AUTHORITY_PREFIX, "")));

        return String.format("CK-RBA UserId=%s, Roles=%s", auth.getName(), StringUtils.join(roles, ";"));
    }

    private static boolean isUserInRole(final List<String> roles) {
        final Collection<? extends GrantedAuthority> authorities = getAuthorities();

        for (final GrantedAuthority grantedAuthority : authorities) {
            if (roles.contains(grantedAuthority.getAuthority())) {
                return true;
            }
        }

        return false;
    }

    private static String getIdentifier() {
        final Authentication auth = getAuthentication();
        if (auth == null) {
            return null;
        }
        final String userId = auth.getName();
        if (Objects.nonNull(userId)) {
            return userId;
        }
        throw new AccessDeniedException(FORBIDDEN_ACCESS);
    }

    private static Collection<? extends GrantedAuthority> getAuthorities() {
        final Authentication auth = getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            return Collections.emptyList();
        }

        final Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        if (CollectionUtils.isEmpty(authorities)) {
            return Collections.emptyList();
        }

        return authorities;
    }

    private static Authentication getAuthentication() {
        final SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication();
    }
}

