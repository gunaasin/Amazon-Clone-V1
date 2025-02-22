package com.clone.amazon.review;

import lombok.Builder;

@Builder
public record ReviewDTO(
        String name,
        int rating,
        String title,
        String content,
        String date,
        int helpful,
        boolean verified
) {
}
