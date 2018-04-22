package com.gabrielczar.bootmicroservices.validators;

import com.gabrielczar.bootmicroservices.models.ProductDetail;
import com.gabrielczar.bootmicroservices.services.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductDetailValidator implements Validator {
    private final ProductDetailService productDetailService;

    @Autowired
    public ProductDetailValidator(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @Override
    public boolean supports(Class clazz) {
        return ProductDetail.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDetail detail = (ProductDetail) target;
        if (!productDetailService.isValidInventory(detail.getInventoryId())) {
            errors.rejectValue("inventoryId", "inventory.id.invalid", "ID de Estoque inválido");
        }
    }
}