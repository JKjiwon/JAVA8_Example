package org.example.chapter02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Store {

    public static void main(String[] args) {
        Item itemA = new Item(1L, "A", new BigDecimal("10.00"));
        Item itemB = new Item(2L, "B", new BigDecimal("55.50"));
        Item itemC = new Item(3L, "C", new BigDecimal("17.45"));
        Item itemD = new Item(4L, "D", new BigDecimal("21.00"));
        Item itemE = new Item(5L, "E", new BigDecimal("132.99"));

        Order order = new Order(1L, "on-1234", Arrays.asList(
                new OrderItem(1L, itemA, 2),
                new OrderItem(2L, itemC, 3),
                new OrderItem(3L, itemD, 12)));

        BigDecimal totalPrice = order.getTotalPrice();
        System.out.println("totalPrice = " + totalPrice);
    }

    @AllArgsConstructor
    @Data
    static class Order {
        private Long id;
        private String OrderNumber;
        private List<OrderItem> orderItems;

        private BigDecimal getTotalPrice() {
            return total(orderItems, orderItem -> orderItem.getTotalPrice());
        }
    }

    @AllArgsConstructor
    @Data
    static class OrderItem {
        private Long id;

        private Item item;

        private int quantity;

        private BigDecimal getTotalPrice() {
            return item.getPrice().multiply(new BigDecimal(quantity));
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class Item {

        private Long id;

        private String name;

        private BigDecimal price;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
        BigDecimal total = BigDecimal.ZERO;
        for (T t : list) {
            total = total.add(mapper.apply(t));
        }
        return total;
    }
}
