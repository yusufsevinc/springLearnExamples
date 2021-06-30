package com.spring.aop.around.repository;

import com.spring.aop.around.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryAround {

    private List<Product> products = new ArrayList<Product>();

    public void saveProduct(Product product){

        System.out.println("Ürün eklendi");
        this.products.add(product);
        System.out.println(product);
    }

    public void deleteProduct(Product product){
        this.products.remove(product);

    }

    public Product findProduct(int index){
        Product product = this.products.get(index);
        return product;
    }

    public void findProducts(){

        for (Product product: products
             ) {
            System.out.println(product);
        }
    }

}
