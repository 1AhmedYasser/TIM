package ee.eesti.authentication.constant;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * properties relating to jwt. string from @ConfigurationProperties is used as prefix in properties files.
 * Field names as properties names in properties files.
 */
@ConfigurationProperties("jwt-integration.signature")
@Data
@Component
public class JwtSignatureConfig {

    private Resource keyStore;
    private String keyStorePassword;
    private String keyStoreType;
    private String keyAlias;
    private String issuer;

    private String cookieName;

}
