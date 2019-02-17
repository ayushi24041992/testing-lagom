package com.knoldus.com.impl;
import com.knoldus.DemoService;
import com.knoldus.UserInfo;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DemoServiceImpl implements DemoService {
    List<UserInfo> userDetails = new ArrayList<>();

    @Override
    public ServiceCall<UserInfo, List<UserInfo>> addUser() {
        return request -> {
            //User newUser = new User(request.userId,request.userName,request.qualification,request.trackAssigned);
            UserInfo userInfo = UserInfo
                    .builder()
                    .userId(request.getUserId())
                    .userName(request.getUserName())
                    .qualification(request.getQualification())
                    .trackAssigned(request.getTrackAssigned()).build();

            userDetails.add(userInfo);
            return CompletableFuture.completedFuture(userDetails);

        };
    }
}
