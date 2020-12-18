package store.controllers;

import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import store.common.Product;
import store.services.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Transactional
    @RequestMapping(value = "Product/Buy", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void buyProduct(@RequestBody int idProduct, @RequestBody int idUser) {
        productService.buyProduct(idProduct, idUser);
    }

    @Transactional
    @RequestMapping(value = "Product/Sell", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void sellProduct(@RequestBody Product product) {
        productService.sellProduct(product);
    }

    @Transactional
    @RequestMapping(value = "Product/GetAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @Transactional
    @RequestMapping(value = "Product/GetById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @Transactional
    @RequestMapping(value = "Product/Edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void editProduct(@RequestBody Product product) {
        productService.editProduct(product);
    }

}
