package ru.market.ejb;

import ru.market.domain.Product;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ProductManagerBean {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Product createProduct (String name, int price, int quantity) {
        Product product = new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductQuantity(quantity);
        entityManager.persist(product);

        return product;
    }

    public List <Product> getAllProduct () {
        TypedQuery <Product> query = entityManager.createQuery("FROM Product",Product.class);
        return query.getResultList();
    }

}
