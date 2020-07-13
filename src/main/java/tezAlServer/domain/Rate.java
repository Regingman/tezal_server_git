package tezAlServer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "rate")
@ToString
@EqualsAndHashCode(of={"id"})
public class Rate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private  Float wholesalePrice;

    @Column(nullable = false)
    private  Float retailPrice;

    @Column(nullable = false)
    private  Float quantityInStock;

    @Column(updatable = false, insertable =  false, nullable = false, name = "rawMaterial_id")
    private  Long rawMaterialId;

    @ManyToOne
    @JoinColumn(name = "rawMaterial_id")
    private RawMaterial rawMaterial;

    @Column(updatable = false, insertable =  false, nullable = false, name = "container_id")
    private  Long containerId;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container container;

    @Column(updatable = false, nullable = false, name="create_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createDate;

    @Column(name="update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updateDate;



    // --------Getter and Setters--------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(Float wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public Float getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Float retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Float getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Float quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Long getRawMaterialId() {
        return rawMaterialId;
    }

    public void setRawMaterialId(Long rawMaterialId) {
        this.rawMaterialId = rawMaterialId;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public Long getContainerId() {
        return containerId;
    }

    public void setContainerId(Long containerId) {
        this.containerId = containerId;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
