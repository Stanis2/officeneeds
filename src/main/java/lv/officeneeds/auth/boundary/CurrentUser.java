/*
 * Copyright (c) 2018 Dimitrijs Fedotovs
 * This code is licensed under MIT license
 * (see LICENSE.txt for details)
 */

package lv.officeneeds.auth.boundary;


import lv.officeneeds.auth.model.UserEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class CurrentUser implements Serializable {
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
