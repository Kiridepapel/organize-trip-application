package com.organizetrip.organizetripapplication.classes;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {
    // 2
    private String name;
    // 3
    private String destination;
    // 4
    private LocalDate startDate;
    private LocalDate endDate;
    private String transport;
    // 5
    private Integer budgetUSD;
    private Integer companions;
    private Boolean havePlaceToStay;
    private String placeToStay;
    // 6
    private List<String> placesToVisit;
    // 7
    private List<String> reviews;
}
