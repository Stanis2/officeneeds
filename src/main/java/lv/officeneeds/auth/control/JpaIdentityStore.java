/*
 * Copyright (c) 2018 Dimitrijs Fedotovs
 * This code is licensed under MIT license
 * (see LICENSE.txt for details)
 */

package lv.officeneeds.auth.control;

import lv.officeneeds.auth.model.Role;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class JpaIdentityStore implements IdentityStore {
    @Inject
    private PasswordHashAlgorithm passwordHash;
    @Inject
    private UserDAO userDAO;

    public CredentialValidationResult validate(UsernamePasswordCredential credential) {
        String caller = credential.getCaller();
        return userDAO.findUser(caller)
                .filter(u -> checkPassword(u.getPasswordHash(), credential.getPassword()))
                .map(u -> new CredentialValidationResult(u.getLoginName(), makeRoles(u.getRoleName())))
                .orElse(CredentialValidationResult.INVALID_RESULT);
    }

    private Set<String> makeRoles(Role role) {
        Set<String> result = new HashSet<>(4, 1);
        switch (role) {
            case ADMIN:
                result.add(Role.ADMIN.toString());
            case MANAGER:
                result.add(Role.MANAGER.toString());
            case USER:
                result.add(Role.USER.toString());
        }
        return result;
    }

    private boolean checkPassword(String hashedPassword, Password password) {
        return passwordHash.get().verify(password.getValue(), hashedPassword);
    }
}
