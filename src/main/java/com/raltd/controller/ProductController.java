package com.raltd.controller;

import com.raltd.Utils;
import com.raltd.model.Product;
import com.raltd.model.ProductsPage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/product")
@RestController
public class ProductController {

    static List<Product> prods = Utils.getList(500);

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ProductsPage all(@RequestParam("page") int page) {
        int startPage = page < 1 ? 0 : (page - 1) * 25;
        return new ProductsPage(page, prods.stream().skip(startPage).limit(25).collect(Collectors.toList()), 500);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> all() {
        return prods;
    }
}