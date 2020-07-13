package tezAlServer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@ToString
@EqualsAndHashCode(of={"id"})
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(updatable = false, insertable =  false, nullable = false, name = "ordersStatus_id")
    private  Long ordersStatusId;

    @ManyToOne
    @JoinColumn(name = "ordersStatus_id")
    private OrderStatus ordersStatus;

    @Column(updatable = false, insertable =  false, nullable = false, name = "client_id")
    private  Long clientId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;


    @Column(updatable = false, insertable =  false, nullable = false, name = "container_id")
    private  Long containerId;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container container;

    @Column(updatable = false, nullable = false, name="create_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createDate;

    @Column(updatable = false, nullable = false, name="deadline_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime deadlineDate;

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

    public Long getOrdersStatusId() {
        return ordersStatusId;
    }

    public void setOrdersStatusId(Long orderStatusId) {
        this.ordersStatusId = orderStatusId;
    }

    public OrderStatus getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(OrderStatus ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalDateTime getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDateTime deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
