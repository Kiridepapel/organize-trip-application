package com.organizetrip.organizetripapplication.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    private String imgUrl;
    private String name;
    private String comment;
    private Integer rating;
    private String date;
    private String time;
}
