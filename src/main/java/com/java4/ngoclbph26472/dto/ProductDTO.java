package com.java4.ngoclbph26472.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {
    private Long id;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
    private String createdUser;
    private LocalDateTime createDate;
    private String description;
    private Boolean deleted;
    private String lastModifiedUser;
    private LocalDateTime lastModifiedDate;
    private String shape;
    private Boolean taste;
}
