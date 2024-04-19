package co.istad.springsecuritybasic.service;

import co.istad.springsecuritybasic.model.dto.UserRequest;
import co.istad.springsecuritybasic.model.dto.UserResponse;
import co.istad.springsecuritybasic.repository.UserRepository;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
