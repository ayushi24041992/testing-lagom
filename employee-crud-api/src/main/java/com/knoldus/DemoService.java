package com.knoldus;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import static com.lightbend.lagom.javadsl.api.Service.named;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.List;

import static com.lightbend.lagom.javadsl.api.transport.Method.*;

public interface DemoService extends Service{

    ServiceCall<UserInfo, List<UserInfo>> addUser();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("demo").withCalls(
                Service.restCall(POST, "/api/adddemo", this::addUser)
        ).withAutoAcl(true);
    }
}
