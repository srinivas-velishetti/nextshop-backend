package com.nextshop.user.service;

import com.nextshop.user.dto.*;
import com.nextshop.user.entity.User;
import com.nextshop.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public List<UserProfileResponse> getAllUsers() {
        return userRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public UserProfileResponse getUserById(Long id) {
        return userRepository.findById(id).map(this::toResponse)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserProfileResponse getCurrentUser(String token) {
        String jwt = token.replace("Bearer ", "");
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody();
        String username = claims.getSubject();
        return userRepository.findByUsername(username).map(this::toResponse)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void updateUser(Long id, UpdateUserRequest req) {
        User user = userRepository.findById(id).orElseThrow();
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setAddress(req.getAddress());
        userRepository.save(user);
    }

    public void updatePreferences(Long id, UserPreferencesDto prefs) {
        User user = userRepository.findById(id).orElseThrow();
        user.setCurrency(prefs.getCurrency());
        user.setTheme(prefs.getTheme());
        user.setLocale(prefs.getLocale());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserProfileResponse toResponse(User user) {
        UserProfileResponse res = new UserProfileResponse();
        res.setId(user.getId());
        res.setUsername(user.getUsername());
        res.setEmail(user.getEmail());
        res.setRole(user.getRole());

        UserPreferencesDto prefs = new UserPreferencesDto();
        prefs.setCurrency(user.getCurrency());
        prefs.setTheme(user.getTheme());
        prefs.setLocale(user.getLocale());
        res.setPreferences(prefs);

        return res;
    }
}
