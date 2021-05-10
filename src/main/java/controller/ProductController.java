package controller;


import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;

//no jsp!!!!!
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseBody
    @RequestMapping(value = "/product/list")
    public List<Product> getProductList(){
        List<Product> list = productService.getProducts();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/product/list", method = RequestMethod.POST)
    public String saveProduct(@RequestBody Product product) throws SQLException {
        if(product != null)
            productService.save(product);
        return "redirect:/product/list";
    }

    @ResponseBody
    @RequestMapping(value = "/product/list", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Product product){
        if(product != null)
            productService.update(product);
        return "redirect:/product/list";
    }

    @ResponseBody
    @RequestMapping(value = "/product/list", method = RequestMethod.DELETE)
    public String deleteProduct(@RequestParam("id") int id){
        productService.delete(id);
        return "redirect:/product/list";
    }
}