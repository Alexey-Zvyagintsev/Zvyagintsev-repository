package ru.sberbank.jd.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.sberbank.jd.repository.LoginsRepository;
import ru.sberbank.jd.security.model.LoginRolesAuthentication;
import ru.sberbank.jd.security.model.Role;
import java.io.IOException;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class HttpBasedSecurityFilter extends GenericFilter {

    private static final String AUHTORIZATION_HEADER = "Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String login = ((HttpServletRequest) request).getHeader(AUHTORIZATION_HEADER);
        login = login.replace("Basic","").trim();
        byte[] decodedBytes = Base64.getDecoder().decode(login);
        String decodedString = new String(decodedBytes);
        String[] result = decodedString.split(":");
        LoginsRepository loginsRepository = new LoginsRepository();
        Set<Role> roles = new HashSet<>();
        roles.add(loginsRepository.getRole(result[0], result[1]));
        System.out.println(result[0] + ":" + result[1]);
        LoginRolesAuthentication auth = new LoginRolesAuthentication(true, roles, result[0]);
        SecurityContextHolder.getContext().setAuthentication(auth);
        chain.doFilter(request, response);
    }
}
