/*
 * Copyright (c) 2018 Dimitrijs Fedotovs
 * This code is licensed under MIT license
 * (see LICENSE.txt for details)
 */

package lv.officeneeds.cartridges.boundary;

import lv.officeneeds.cartridges.model.CartridgeEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class CurrentCartridge implements Serializable {
    private CartridgeEntity cartridge;

    public CartridgeEntity getCartridge() {
        return cartridge;
    }

    public void setUser(CartridgeEntity cartridge) {
        this.cartridge = cartridge;
    }

    @Override
    public String toString() {
        return "CurrentCartridge{" +
                "cartridge=" + cartridge +
                '}';
    }
}
