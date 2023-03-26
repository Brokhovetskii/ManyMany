package com.example.manytomany.Requests;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private String name;
    private Long price;

}
