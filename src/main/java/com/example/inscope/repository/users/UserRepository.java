package com.example.inscope.repository.users;

import com.example.inscope.domain.user.Users;
import com.example.inscope.repository.common.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<Users> {

    List<Users> findAllByEmail(String email);

    Optional<Users> getByEmail(String email);
    
}
