package br.com.vitor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductJson {

    private Integer id;
    private String title;
    private String description;
    private Long amount;
    @JsonProperty("is_gift")
    private Boolean isGift;

}
