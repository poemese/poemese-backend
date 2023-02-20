package com.poemese.poemese.daos;

import com.poemese.poemese.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UserRepository<T, ID extends Serializable> extends JpaRepository<User, String> { }
