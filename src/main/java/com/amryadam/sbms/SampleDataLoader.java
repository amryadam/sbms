package com.amryadam.sbms;

import com.amryadam.sbms.models.entities.customers.Customer;
import com.amryadam.sbms.models.entities.operations.Category;
import com.amryadam.sbms.models.entities.operations.Order;
import com.amryadam.sbms.models.entities.operations.OrderDetails;
import com.amryadam.sbms.models.entities.operations.Product;
import com.amryadam.sbms.services.customers.CustomerService;
import com.amryadam.sbms.services.operation.CategoryService;
import com.amryadam.sbms.services.operation.OrderDetailsService;
import com.amryadam.sbms.services.operation.OrderService;
import com.amryadam.sbms.services.operation.ProductService;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@AllArgsConstructor
//@Component
public class SampleDataLoader implements CommandLineRunner {


    private final CustomerService customerService;
    private final OrderService orderService;
    private final OrderDetailsService orderDetailsService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {


        List<Customer> customers = IntStream.rangeClosed(1, 500)
                .mapToObj(i -> new Customer(
                        faker.code().asin(),
                        faker.name().fullName(),
                        faker.internet().emailAddress(),
                        "https://picsum.photos/200",
                        faker.lorem().sentence(10),
                        faker.number().numberBetween(1, 100),
                        faker.number().numberBetween(1, 5),
                        faker.options().option("Discount", "Wandering", "Need-based", "Impulse", "Loyal")
                )).collect(Collectors.toList());
        customerService.save(customers);


        List<Category> category = IntStream.rangeClosed(1, 4)
                .mapToObj(i -> new Category(
                        UUID.randomUUID(),
                        faker.code().gtin8(),
                          Stream.of("Electronics", "Clothing","Fitness","Accessories").collect(Collectors.toList()).get(i-1),
                        null
                )).collect(Collectors.toList());
        categoryService.save(category);

        List<Category> CatList = categoryService.getAll().getLeft();


        List<Product> products = IntStream.rangeClosed(1, 500)
                .mapToObj(i -> new Product(
                        UUID.randomUUID(),
                        faker.code().ean8(),
                        faker.commerce().productName(),
                        faker.number().randomDouble(2, 1, 1000),
                        faker.number().numberBetween(1, 5),
                        "https://loremflickr.com/320/240",
                        faker.lorem().sentence(10),
                        faker.options().option("INSTOCK", "LOWSTOCK", "OUTOFSTOCK"),
                        CatList.subList(faker.number().numberBetween(1, 2), faker.number().numberBetween(3, 4))
                )).collect(Collectors.toList());

        productService.save(products);


        List<Product> PList = productService.getAll().getLeft();
        List<Customer> CList = customerService.getAll().getLeft();

//        List<Order> orderList = IntStream.rangeClosed(1, 500)
//                .mapToObj(i -> new Order(
//                        UUID.randomUUID(),
//                        faker.code().asin(),
//                        faker.number().randomDouble(2, 1, 1000),
//                        faker.number().numberBetween(1, 100),
//                        CList.get(faker.number().numberBetween(1, 500))
//                )).collect(Collectors.toList());
//        orderService.save(orderList);
//
//        List<Order> OList = orderService.getAll().getLeft();
//        List<OrderDetails> details = IntStream.rangeClosed(1, 500)
//                .mapToObj(i -> {
//                    var random = faker.number().numberBetween(1, 500);
//                    var total = faker.number().numberBetween(1, 50);
//                    return new OrderDetails(
//                            UUID.randomUUID(),
//                            PList.get(random),
//                            PList.get(random).getPrice(),
//                            total,
//                            OList.get(random)
//                    );
//                }).collect(Collectors.toList());
//        orderDetailsService.save(details);
    }
}
