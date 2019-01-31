package lv.officeneeds.cartridges.boundary;

import lv.officeneeds.cartridges.model.CartridgeEntity;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

@ViewScoped
@Named
public class NewCartridgeBean implements Serializable {
    @PersistenceContext
    private EntityManager em;

    private CartridgeEntity cartridge = new CartridgeEntity();
    private boolean created = false;

    @Transactional
    public String createCartridge() {
        System.out.println("Pievienots jauns kārtridžs");
        em.persist(cartridge);
        cartridge = new CartridgeEntity();
        created = true;
        return null;
    }

    public boolean isCreated() {
        return created;
    }

    public CartridgeEntity getCartridge() {
        return cartridge;
    }

    public void setCartridge(CartridgeEntity cartridge) {
        this.cartridge = cartridge;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }
}
