package br.com.vitor.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {

    private Long totalAmount;
    private Long totalAmountWithDiscount;
    private Long totalDiscount;
    private List<ProductsResponse> products;

}
