package tezAlServer.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tezAlServer.domain.*;
import tezAlServer.repo.*;
import tezAlServer.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersRepo ordersRepo;
    @Autowired
    SalesRepo salesRepo;
    @Autowired
    ContainersRepo containersRepo;
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    OrdersStatusRepo ordersStatusRepo;
    @Autowired
    RatesRepo ratesRepo;

    @Override
    public List<Order> findAll() {
        return ordersRepo.findAll();
    }

    @Override
    public List<Order> findAllById(Long id) {
        return ordersRepo.getOrderByRateId(id);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return ordersRepo.findById(id);
    }

    @Override
    public Order save(Order order) {
        Container container = containersRepo.findById(order.getContainerId()).orElse(null);
        order.setContainer(container);
        User user = usersRepo.findById(order.getClientId()).orElse(null);
        order.setUser(user);
        OrderStatus orderStatus = ordersStatusRepo.findById(order.getOrdersStatusId()).orElse(null);
        order.setOrdersStatus(orderStatus);
        order.setCreateDate(LocalDateTime.now());
        order.setUpdateDate(LocalDateTime.now());
        return ordersRepo.save(order);
    }



    @Override
    public void deleteById(Long id) {
        ordersRepo.deleteById(id);
    }

    @Override
    public void proceedToCheckout(List<Sale> sale) {
        for(int i = 0; i <= sale.size();i++){
            salesRepo.save(sale.get(i));
        }
    }

    @Override
    public void createCart(Long containerId, Long clientId, Sale sale) {
        Order order = new Order();
        OrderStatus orderStatus = ordersStatusRepo.findById(1l).orElse(null);
        Container container = containersRepo.findById(containerId).orElse(null);
        User user = usersRepo.findById(clientId).orElse(null);
        order.setClientId(clientId);
        order.setUser(user);
        order.setOrdersStatus(orderStatus);
        order.setContainerId(containerId);
        order.setContainer(container);
        order.setDeadlineDate(LocalDateTime.now());
        order.setCreateDate(LocalDateTime.now());
        order.setUpdateDate(LocalDateTime.now());
        order.setOrdersStatusId(1l);
        ordersRepo.save(order);
        Rate rate = ratesRepo.findById(sale.getRateId()).orElse(null);
        sale.setOrdersId(order.getId());
        sale.setOrders(order);
        sale.setRate(rate);
        sale.setCreateDate(LocalDateTime.now());
        sale.setUpdateDate(LocalDateTime.now());
        salesRepo.save(sale);
    }

    @Override
    public List<Sale> allRateInCart(Long orderId) {
        return salesRepo.allRawMaterialInCart(orderId);
    }

    @Override
    public void clearAllRateInCart(Long orderId) {
        List<Sale> sales = salesRepo.allRawMaterialInCart(orderId);
        for(int i =0;i<sales.size();i++){
            salesRepo.delete(sales.get(i));
        }
        ordersRepo.deleteById(orderId);
    }

}
