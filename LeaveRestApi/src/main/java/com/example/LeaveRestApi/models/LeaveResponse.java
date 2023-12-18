package com.example.LeaveRestApi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LeaveResponse {
    public int id;
    public String requestReference;
    public String statusCode;
    public String statusDesc;
    public String name;
    public String approver;
}
