package com.appliti.homer.infractruture.http.filter;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.appliti.homer.bussiness.incoming.home.GetHomesFacade;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizationTokenFilter extends OncePerRequestFilter {

    private static final Map<String, String> INCLUDE_URL = new HashMap<String, String>() {{
        put("/events", "POST");
    }};

    private final GetHomesFacade getHomesFacade;

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
        final String method = request.getMethod();
        final String servletPath = request.getServletPath();

        boolean anyMatch = false;
        if (INCLUDE_URL.containsKey(servletPath)) {
            final String m = INCLUDE_URL.get(servletPath);
            anyMatch = m.equals(method);
        }

        if (anyMatch) {
            final String token = request.getHeader("token");
            if (token != null) {
                if (isAccessable(token)) {
                    filterChain.doFilter(request, response);
                } else {
                    throw new AccessDeniedException("Provided token doesn't match to any resource.");
                }
            } else {
                throw new BadCredentialsException("Wrong auth parameters: missing `token` header.");
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private boolean isAccessable(final String token) {
        return getHomesFacade.homeExist(token);
    }
}

