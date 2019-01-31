package lv.officeneeds.cartridges.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity(name = "Cartridge")
@Table(name = "cartridges")
public class CartridgeEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Column(name = "cartridge_manufacturer", nullable = false)
    private String manufacturer;

    @NotEmpty
    @Column(name = "cartridge_name", unique = true, nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "cartridge_description", nullable = false)
    private String description;

    @NotEmpty
    @Column(name = "cartridge_cost", nullable = false)
    private String cost;

    @NotEmpty
    @Column(name = "cartridge_image", nullable = false)
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String title) {
        this.manufacturer = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String author) {
        this.name = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CartridgeEntity{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost='" + cost + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
