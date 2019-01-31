package lv.officeneeds.cartridges.boundary;

import lv.officeneeds.cartridges.model.CartridgeEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartridgesListBean implements Serializable {
    @PersistenceContext
    private EntityManager em;

    private String term;

    public List<CartridgeEntity> getCartridges() {
        if (term == null) {
            return em.createQuery("select b from Cartridge b", CartridgeEntity.class).getResultList();
        } else {
            return em.createQuery("select b from Cartridge b where lower(b.name) like :term", CartridgeEntity.class)
                    .setParameter("term", "%" + term.toLowerCase() + "%")
                    .getResultList();
        }
    }

    public void doSearch() {
        System.out.println("Meklējam: " + term);
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
