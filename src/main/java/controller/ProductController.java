package controller;


import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

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
    public String saveProduct(@RequestBody Product product){
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





























/*
    //기본적으로 RequestMethod.GET 메서드일껄? : 맞음
    @RequestMapping(value = "/football")
    public String football(){
        return "football";
    }

    @RequestMapping(value = "/link", method = RequestMethod.GET)
    public String linkPage(){
        return "link";
    }


    @RequestMapping(value = "/interest")
    public String interest(){
        return "interest";
    }

    @ResponseBody
    @RequestMapping(value = "/rpbody")
    public String rpResponse(){
        return "this return @ResponseBody. \n it's just a test :)" +
                "\n if you don't put @ResponseBody on your method, and then when VIEWRESOLVER couldn't match name.jsp, then error rises.";
    }
 */
