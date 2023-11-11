package com.example.simpleStore.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.simpleStore.repositories.ClienteRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterOrderAuth extends OncePerRequestFilter {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var serveletPath = request.getServletPath();
        System.out.println("PATH: " + serveletPath);
        if (serveletPath.startsWith("/api/v1/orders/")) {
            var Auth = request.getHeader("Authorization");
            var authEncoded = Auth.substring("Basic".length()).trim();

            byte[] authDecode = Base64.getDecoder().decode(authEncoded);
            var authString = new String(authDecode);

            String[] credenciais = authString.split(":");
            String nameCLient = credenciais[0];
            String password = credenciais[1];

            System.out.println(nameCLient);
            System.out.println(password);

            var client = this.clienteRepository.findByNameClient(nameCLient);
            if (client == null) {
                response.sendError(401);
            } else {
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), client.getPassword());

                if (passwordVerify.verified) {
                    request.setAttribute("Id", client.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

}

