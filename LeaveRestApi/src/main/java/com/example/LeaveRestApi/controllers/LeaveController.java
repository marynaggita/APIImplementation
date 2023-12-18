package com.example.LeaveRestApi.controllers;

import com.example.LeaveRestApi.models.LeaveRequest;
import com.example.LeaveRestApi.services.SearchLeaveService;
import com.example.LeaveRestApi.services.ChangeLeaveService;
import com.example.LeaveRestApi.services.DeleteLeaveService;
import com.example.LeaveRestApi.services.ReturnLeaveRequestsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LeaveController {
    final SearchLeaveService searchLeaveService;
    final ChangeLeaveService changeLeaveService;
    final DeleteLeaveService deleteLeaveService;
    final ReturnLeaveRequestsService returnLeaveRequestsService;

    public LeaveController(SearchLeaveService addLeaveService, SearchLeaveService searchLeaveService, ChangeLeaveService changeLeaveService, DeleteLeaveService deleteLeaveService, ReturnLeaveRequestsService returnLeaveRequestsService) {
        this.searchLeaveService = searchLeaveService;
        this.changeLeaveService = changeLeaveService;
        this.deleteLeaveService = deleteLeaveService;
        this.returnLeaveRequestsService = returnLeaveRequestsService;
    }
    @GetMapping("/leaveRequest")
    public LeaveRequest getLeaveRequest(@RequestParam String name){
        Optional<LeaveRequest> leaveRequest = searchLeaveService.getLeaveRequest(name);
        return (LeaveRequest) leaveRequest.orElse(null);
    }


}

