package com.emindsblogapplication.service;

import com.emindsblogapplication.dto.RegisterDto;
import com.emindsblogapplication.exception.DataAlreadyExistsException;

public interface UserService {
    void registerUser(RegisterDto registerDto) throws DataAlreadyExistsException;
}
