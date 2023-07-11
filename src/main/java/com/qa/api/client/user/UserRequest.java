package com.qa.api.client.user;

import com.aventstack.extentreports.Status;
import com.qa.api.core.BaseRequest;
import com.qa.api.core.RestResource;
import com.qa.api.core.response.IResponse;
import com.qa.api.enums.MethodType;
import com.qa.api.pojo.Users;
import com.qa.api.utils.GenericUtil;
import com.qa.api.utils.ReporterFactory;

import static com.qa.api.config.FrameworkConfigFactory.getConfig;

/**
 * @author bjha
 */
public class UserRequest {



    public IResponse createUser(Users user) throws Exception {

        String Url =
                getConfig().getProtocol()+ "://" + getConfig().getHost() + UserEndpoints.USERS.getPath();
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"URL: "+Url);

        BaseRequest baseRequest =   BaseRequest.builder(UserEndpoints.USERS.getPath(), MethodType.POST).baseURI(getConfig().getProtocol()+ "://" + getConfig().getHost()).body(user).headers(GenericUtil.getCommonHeader()).build();

        return new RestResource().executeApi(baseRequest);
    }

}
