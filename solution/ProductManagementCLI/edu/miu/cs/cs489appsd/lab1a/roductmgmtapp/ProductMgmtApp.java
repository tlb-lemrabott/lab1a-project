package edu.miu.cs.cs489appsd.lab1a.roductmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.roductmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;

public class ProductMgmtApp {

    public static void main(String[] args) {
        Product[] products = {
                new Product(312887411, "Banana", LocalDate.of(2023,01,24), 124, 0.55),
                new Product(292745826, "Apple", LocalDate.of(2022,12,9), 18, 1.09),
                new Product(918992740, "Carrot", LocalDate.of(2023,03,31), 89, 2.99)
        };

        printProducts(products);
    }

    public static void printProducts(Product[] products) {

        Arrays.sort(products, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        System.out.println("Products in JSON format:");
        System.out.println("[");
        for (Product product : products) {
            System.out.printf("{\"productId\": %d, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f}%n",
                    product.getProductId(), product.getName(), product.getDateSupplied(), product.getQuantityInStock(), product.getUnitPrice());
        }
        System.out.println("]");

        System.out.println("\nProducts in XML format:");
        System.out.println("<products>");
        for (Product product : products) {
            System.out.printf("  <product>%n");
            System.out.printf("    <productId>%d</productId>%n", product.getProductId());
            System.out.printf("    <name>%s</name>%n", product.getName());
            System.out.printf("    <dateSupplied>%s</dateSupplied>%n", product.getDateSupplied());
            System.out.printf("    <quantityInStock>%d</quantityInStock>%n", product.getQuantityInStock());
            System.out.printf("    <unitPrice>%.2f</unitPrice>%n", product.getUnitPrice());
            System.out.printf("  </product>%n");
        }
        System.out.println("</products>");

        System.out.println("\nProducts in CSV format:");
        System.out.println("productId,name,dateSupplied,quantityInStock,unitPrice");
        for (Product product : products) {
            System.out.printf("%d,%s,%s,%d,%.2f%n",
                    product.getProductId(), product.getName(), product.getDateSupplied(), product.getQuantityInStock(), product.getUnitPrice());
        }

    }

}
