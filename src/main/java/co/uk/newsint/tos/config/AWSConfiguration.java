package co.uk.newsint.tos.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AWSConfiguration {

    @Bean
    public AWSCredentials awsCredentials(@Value("${aws.key.access}") String accessKey, @Value("${aws.key.secret}") String secretKey) {
        return new BasicAWSCredentials(accessKey, secretKey);
    }
	
}
