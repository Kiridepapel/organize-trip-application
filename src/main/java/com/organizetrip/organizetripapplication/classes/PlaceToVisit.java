package com.organizetrip.organizetripapplication.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceToVisit {
    private String name;
    private String imgPath;
    private String description;
}
