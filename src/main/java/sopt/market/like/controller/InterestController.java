package sopt.market.like.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.market.common.dto.SuccessResponse;
import sopt.market.like.dto.response.InterestsGetResponse;
import sopt.market.like.service.InterestService;

import static sopt.market.common.dto.SuccessResponse.success;
import static sopt.market.like.message.SuccessMessage.*;

@RestController
@RequestMapping("/api")
public class InterestController {

    private final InterestService interestService;

    public InterestController(InterestService interestService) {
        this.interestService = interestService;
    }

    @PostMapping("/v1/likes/products/{productId}")
    public ResponseEntity<SuccessResponse<Void>> addInterest(
            @PathVariable long productId,
            @RequestHeader long memberId
    ){
        interestService.addInterest(productId, memberId);
        return ResponseEntity.ok(success(ADD_INTEREST.getMessage(), null));
    }

    @DeleteMapping("/v1/likes/products/{productId}")
    public ResponseEntity<SuccessResponse<Void>> deleteInterest(
            @PathVariable long productId,
            @RequestHeader long memberId
    ){
        interestService.deleteInterest(productId, memberId);
        return ResponseEntity.ok(success(DELETE_INTEREST.getMessage(), null));
    }

    @GetMapping("/v1/likes")
    public ResponseEntity<SuccessResponse<InterestsGetResponse>> getInterests(
            @RequestHeader long memberId
    ){
        InterestsGetResponse likes = interestService.getInterests(memberId);
        return ResponseEntity.ok(success(GET_INTERESTS.getMessage(), likes));
    }
}
