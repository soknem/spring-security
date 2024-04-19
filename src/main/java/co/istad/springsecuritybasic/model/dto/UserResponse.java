package co.istad.springsecuritybasic.model.dto;

import java.util.Set;

public record UserResponse(
        String id,
        String email,
        Set<String> roles
) {
}
