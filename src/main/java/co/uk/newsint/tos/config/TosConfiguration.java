package co.uk.newsint.tos.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import co.uk.newsint.tos.config.validator.RuntimeEnvironmentPropertiesConfigurer;

@Configuration
public class TosConfiguration {

	@Bean
	public RuntimeEnvironmentPropertiesConfigurer strictRuntimeEnvironmentPropertiesConfigurer() {

		RuntimeEnvironmentPropertiesConfigurer propertyPlaceholderConfigurer = new RuntimeEnvironmentPropertiesConfigurer();

		propertyPlaceholderConfigurer.setPropertyLocations(Collections.<Resource> singleton(new ClassPathResource("runtime-properties/")));
		propertyPlaceholderConfigurer.setDefaultEnvironment("local");

		Set<String> environmentsList = new HashSet<String>();
		environmentsList.add("local");
		environmentsList.add("integration");
		environmentsList.add("production");
		propertyPlaceholderConfigurer.setEnvironments(environmentsList);

		return propertyPlaceholderConfigurer;
	}

}
