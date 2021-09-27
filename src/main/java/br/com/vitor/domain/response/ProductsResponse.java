package br.com.vitor.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponse {

    private Integer id;
    private Integer quantity;
    private Long unitAmount;
    private Long totalAmount;
    private float discount;
    private Boolean isGift;
}
