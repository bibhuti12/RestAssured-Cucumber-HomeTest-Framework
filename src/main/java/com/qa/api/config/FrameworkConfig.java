package com.qa.api.config;


import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/Config.properties"
})


public interface FrameworkConfig extends Config {



    @Key("protocol")
    String getProtocol();

    @Key("host")
    String getHost();

    @Key("token")
    String getToken();

    @Key("cookie.token")
    String getCookieToken();
}
