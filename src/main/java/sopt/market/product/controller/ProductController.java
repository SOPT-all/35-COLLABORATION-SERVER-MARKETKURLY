package sopt.market.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.market.common.dto.SuccessResponse;
import sopt.market.product.dto.response.DetailDataGetResponse;
import sopt.market.product.dto.response.MainDataGetResponse;
import sopt.market.product.service.ProductService;

import static sopt.market.common.dto.SuccessResponse.success;
import static sopt.market.product.message.SuccessMessage.GET_DETAILDATAS;
import static sopt.market.product.message.SuccessMessage.GET_MAINDATAS;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/v1/products/main")
    public ResponseEntity<SuccessResponse<MainDataGetResponse>> getMainData(){

        MainDataGetResponse mainData = productService.getMainData();
        return ResponseEntity.ok().body(success(GET_MAINDATAS.getMessage(), mainData));

    }

    @GetMapping("/v1/products/{productId}")
    public ResponseEntity<SuccessResponse<DetailDataGetResponse>> getDetailData
            (@PathVariable long productId, @RequestHeader long memberId)
    {
        DetailDataGetResponse detailData = productService.getDetailData(productId, memberId);
        return ResponseEntity.ok().body(success(GET_DETAILDATAS.getMessage(), detailData));
    }
}
