package com.example.LeaveRestApi.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LeaveRequest {
    private int id;
    private String name;
    private String leaveType;
    private String department;
    private String startDate;
    private String endDate;
    private int noOfDays;

}
