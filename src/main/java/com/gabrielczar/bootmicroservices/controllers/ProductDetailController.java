package com.gabrielczar.bootmicroservices.controllers;

import com.gabrielczar.bootmicroservices.exceptions.ProductNotFoundException;
import com.gabrielczar.bootmicroservices.models.ProductDetail;
import com.gabrielczar.bootmicroservices.repositories.ProductDetailRepository;
import com.gabrielczar.bootmicroservices.validators.ProductDetailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductDetailController {
    private final ProductDetailRepository repository;
    private final ProductDetailValidator validator;

    @Autowired
    public ProductDetailController(ProductDetailRepository repository, ProductDetailValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @GetMapping
    public ResponseEntity<Iterable> findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                           @RequestParam(value = "count", defaultValue = "10", required = false) int count,
                                           @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
                                           @RequestParam(value = "sort", defaultValue = "productName", required = false) String sortProperty) {
        Page result = repository.findAll(PageRequest.of(page, count, new Sort(direction, sortProperty)));
        return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDetail> create(@RequestBody @Valid ProductDetail detail) {
        return new ResponseEntity<>(repository.save(detail), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDetail> find(@PathVariable String id) {
        Optional<ProductDetail> detail = repository.findById(id);
        if (!detail.isPresent()) {
            throw new ProductNotFoundException();
        }
        return new ResponseEntity<>(detail.get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDetail> update(@RequestBody @Valid ProductDetail productDetail) {
        @Valid ProductDetail updated = repository.save(productDetail);
        return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public HttpEntity delete(@PathVariable String id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
