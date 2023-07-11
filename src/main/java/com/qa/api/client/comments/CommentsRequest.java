package com.qa.api.client.comments;

import com.aventstack.extentreports.Status;
import com.qa.api.client.posts.PostsEndpoints;
import com.qa.api.client.user.UserEndpoints;
import com.qa.api.core.BaseRequest;
import com.qa.api.core.RestResource;
import com.qa.api.core.response.IResponse;
import com.qa.api.enums.MethodType;
import com.qa.api.pojo.Comments;
import com.qa.api.pojo.Posts;
import com.qa.api.utils.GenericUtil;
import com.qa.api.utils.ReporterFactory;

import static com.qa.api.config.FrameworkConfigFactory.getConfig;

/**
 * @author bjha
 */
public class CommentsRequest {


    public IResponse createComment(Comments comments) throws Exception {

        String Url =
                getConfig().getProtocol()+ "://" + getConfig().getHost() + PostsEndpoints.POSTS.getPath();
        ReporterFactory.getInstance().getExtentTest().log(Status.INFO,"URL: "+Url);

        BaseRequest baseRequest =   BaseRequest.builder(CommentsEndpoints.COMMENTS.getPath(), MethodType.POST).baseURI(getConfig().getProtocol()+ "://" + getConfig().getHost()).body(comments).headers(GenericUtil.getCommonHeader()).build();

        return new RestResource().executeApi(baseRequest);
    }

}
