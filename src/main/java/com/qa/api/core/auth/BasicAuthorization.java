package com.qa.api.core.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicAuthorization {
        String userName;
        String password;
    }

