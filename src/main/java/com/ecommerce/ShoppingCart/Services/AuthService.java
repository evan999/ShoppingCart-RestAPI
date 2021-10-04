package com.ecommerce.ShoppingCart.Services;

import com.ecommerce.ShoppingCart.Exceptions.AuthenticationFailException;
import com.ecommerce.ShoppingCart.Models.AuthToken;
import com.ecommerce.ShoppingCart.Models.User;
import com.ecommerce.ShoppingCart.Repositories.AuthRepository;
import com.ecommerce.ShoppingCart.Utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;

    public void saveConfirmationToken(AuthToken authToken) {
        authRepository.save(authToken);
    }

    public AuthToken getToken(User user) {
        return authRepository.findTokenByUser(user);
    }

    public User getUser(String token) {
        AuthToken authToken = authRepository.findTokenByToken(token);
        if (Helper.notNull(authToken)) {
            if (Helper.notNull(authToken.getUser())) {
                return authToken.getUser();
            }
        }
        return null;
    }

    public void authenticate(String token) throws AuthenticationFailException {
        if (!Helper.notNull(token)) {
            throw new AuthenticationFailException("No auth token provided. Please try again.");
        }
        if (!Helper.notNull(getUser(token))) {
            throw new AuthenticationFailException("Auth token not valid. Please try again.");
        }
    }
}
