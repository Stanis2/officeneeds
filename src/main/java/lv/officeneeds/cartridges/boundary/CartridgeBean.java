package lv.officeneeds.cartridges.boundary;

import lv.officeneeds.cartridges.model.CartridgeEntity;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;

@ViewScoped
@Named
public class CartridgeBean implements Serializable {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private CurrentCartridge currentCartridge;

    private Long id;
    private CartridgeEntity cartridge;

    public void openCartridge(){
        System.out.println("Cartridge " + id);
        cartridge = em.find(CartridgeEntity.class, id);
    }

    @Transactional
    public void deleteCartridge(Long id) {
        Query query = em.createQuery("DELETE FROM Cartridge c WHERE c.id =" + id);
        query.executeUpdate();
    }

    public CartridgeEntity getCartridge(){
        return cartridge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
