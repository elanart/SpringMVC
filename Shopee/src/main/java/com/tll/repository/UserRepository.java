package com.tll.repository;

import com.tll.pojo.User;

import java.util.Map;

public interface UserRepository {
    public boolean isUserExist(Map<String, String> params);
}
