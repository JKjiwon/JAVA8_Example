package org.example.chapter02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyFunctionalInterface3 {
    public static void main(String[] args) {
        Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        Product productB = new Product(2L, "B", new BigDecimal("55.50"));
        Product productC = new Product(3L, "C", new BigDecimal("30.25"));
        Product productD = new Product(4L, "D", new BigDecimal("21.05"));
        Product productE = new Product(5L, "E", new BigDecimal("132.00"));

        List<Product> products = Arrays.asList(
                productA, productB, productC, productD, productE
        );


        // 기존 방식
        List<Product> oldExpensiveProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice().compareTo(new BigDecimal("50")) >= 0) {
                oldExpensiveProducts.add(product);
            }
        }
        System.out.println("oldExpensiveProducts = " + oldExpensiveProducts);

        // 함수형 프로그래밍
        Predicate<Product> isExpensive = product -> product.getPrice().compareTo(new BigDecimal("50")) >= 0;
        List<Product> newExpensiveProducts = filter(products, isExpensive);
        System.out.println("newExpensiveProducts = " + newExpensiveProducts);


        // 기존 방식
        List<DiscountedProduct> oldDiscountedProducts = new ArrayList<>();
        for (Product product : newExpensiveProducts) {
            oldDiscountedProducts.add(new DiscountedProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        }
        System.out.println("oldDiscountedProducts = " + oldDiscountedProducts);

        // 함수형 프로그래밍
        List<DiscountedProduct> newDiscountedProducts = map(newExpensiveProducts,
                product -> new DiscountedProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        System.out.println("newDiscountedProducts = " + newDiscountedProducts);
        
        
        // 함수형 프로그래밍
        List<DiscountedProduct> expensiveDiscountedProduct= filter(newDiscountedProducts, isExpensive);
        System.out.println("expensiveDiscountedProduct = " + expensiveDiscountedProduct);
        
        
        // 기존 방식 - 상품 가격의 총합 구하기
        BigDecimal result = BigDecimal.ZERO;
        List<BigDecimal> prices = map(products, product -> product.getPrice());
        for (BigDecimal price : prices) {
            result = result.add(price);
        }
        System.out.println("result = " + result);
        System.out.println("total = " + total(products, product -> product.getPrice()));
        System.out.println("total = " + total(expensiveDiscountedProduct, product -> product.getPrice()));
    }

    private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
        BigDecimal total = BigDecimal.ZERO;
        for (T t : list) {
            total = total.add(mapper.apply(t));
        }
        return total;
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Product {

    private Long id;

    private String name;

    private BigDecimal price;
}

@Data
@ToString(callSuper = true)
class DiscountedProduct extends Product {
    public DiscountedProduct(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    public DiscountedProduct() {
    }
}