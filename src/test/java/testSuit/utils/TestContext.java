package testSuit.utils;


import com.qa.api.config.FrameworkConfig;
import com.qa.api.core.response.IResponse;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;
import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@ScenarioScoped
public class TestContext {

    HashMap<String, Response> responseContext  = new HashMap<>();
    HashMap<String, IResponse> newResponseContext  = new HashMap<>();

    HashMap<String, String> reqBodyContext  = new HashMap<>();

    HashMap<String, String> contextValues  = new HashMap<>();

    HashMap<String, RequestSpecification> requestBuilder = new HashMap<>();

//    code related to config reader
    public static FrameworkConfig configUtil = ConfigCache.getOrCreate(FrameworkConfig.class);



    /**
     * auto generate id for creating request specification
     */
    @Setter
    String reqId;

    public String generateReqId()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * Faker instance
     */
    public static Faker faker = new Faker();

    /**
     * Token management
     */
    public String getCookieToken(){
        return (System.getProperty("cookieToken")==null) ? configUtil.getCookieToken() :
                System.getProperty("cookieToken");
    }

    public String getToken(){
        return (System.getProperty("token")==null) ? configUtil.getToken() : System.getProperty("token");
    }

}
