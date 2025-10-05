// src/main/java/at/edersteiner/backend/config/AdminTokenFilter.java
package at.edersteiner.backend.config;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AdminTokenFilter extends OncePerRequestFilter {

    @Value("${app.admin.token}")
    private String adminToken;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {

        String path = req.getRequestURI();
        if (path.startsWith("/api/admin/")) {
            String header = req.getHeader("X-Admin-Token");
            if (header == null || adminToken == null || !adminToken.equals(header)) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        chain.doFilter(req, res);
    }
}