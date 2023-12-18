package com.example.LeaveRestApi.services;

import com.example.LeaveRestApi.models.LeaveRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//public int id;
//public String name;
//public String leaveType;
//public String department;
//public String startDate;
//public String endDate;
//public String noOfDays;

@Service
public class SearchLeaveService {
   private List<LeaveRequest> leaveRequestList;

   public SearchLeaveService(){
       leaveRequestList = new ArrayList<>();

       LeaveRequest request1 =  new LeaveRequest(1,"Mary","Annual","Engineering","20231214","20231222",7);
       LeaveRequest request2 =  new LeaveRequest(2,"Edgar","Sick","EFT","20230114","20230122",7);
       LeaveRequest request3 =  new LeaveRequest(3,"James","Annual","Engineering","20230114","20230122",7);
       LeaveRequest request4 =  new LeaveRequest(4,"Denis","Partenity","Customer Service","20230414","20230422",7);
       LeaveRequest request5 =  new LeaveRequest(5,"Marvin","Annual","Operations","20230514","20230522",7);
       LeaveRequest request6 =  new LeaveRequest(6,"Naggita","Compassionate","Risk","20230814","20230822",7);
       LeaveRequest request7 =  new LeaveRequest(7,"Kalema","Annual","Architecture","20231014","20231022",7);

       leaveRequestList.addAll(Arrays.asList(request1,request2,request3,request4,request5,request6,request7));

   }
    public Optional<LeaveRequest> getLeaveRequest(String name) {
       Optional optional = Optional.empty();
       for (LeaveRequest leaveRequest:leaveRequestList){
           if (name.equals(leaveRequest.getName())){
               optional = optional.of(leaveRequest);
               return optional;
           }
       }
       return optional;
    }
}
