package com.fst.graphqldemo.dto;

public record ProductRequestDTO(
        String id,
        String name,
        double price,
        int quantity,
        Long categoryId
) {}
