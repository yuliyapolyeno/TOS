package co.uk.newsint.tos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import javax.servlet.Filter;
import java.util.*;

@Configuration
public class SecurityConfiguration {

/**	
    @Bean
    @Autowired
    public UserDetailsService userDetails(@Value("${service.username}")String username, @Value("${service.password}") String password) {
        User user = new User(username, password, Collections.<GrantedAuthority>emptyList());
        return new InMemoryUserDetailsManager(Arrays.<UserDetails>asList(user));
    }

    @Bean
    public DigestAuthenticationEntryPoint digestAuthenticationEntryPoint() {
        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
        digestAuthenticationEntryPoint.setKey("newsint");
        digestAuthenticationEntryPoint.setRealmName("TOS Service");
        return digestAuthenticationEntryPoint;
    }

    @Bean
    @Autowired
    public DigestAuthenticationFilter digestAuthenticationFilter(DigestAuthenticationEntryPoint digestAuthenticationEntryPoint, UserDetailsService userDetailsService) {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint);
        digestAuthenticationFilter.setUserDetailsService(userDetailsService);
        return digestAuthenticationFilter;

    }

    @Bean
    public AnonymousAuthenticationFilter anonymousAuthenticationFilter() {
        return new AnonymousAuthenticationFilter("newsint");
    }

    @Bean
    @Autowired
    public ExceptionTranslationFilter exceptionTranslationFilter(AuthenticationEntryPoint entryPoint) {
        return new ExceptionTranslationFilter(entryPoint);
    }

    @Bean
    @Autowired
    public FilterSecurityInterceptor filterSecurityInterceptor(AuthenticationManager authenticationManager) {
        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
        filterSecurityInterceptor.setAuthenticationManager(authenticationManager);
        filterSecurityInterceptor.setAccessDecisionManager(new AffirmativeBased(Arrays.<AccessDecisionVoter>asList(new AuthenticatedVoter())));
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> securityConfiguration = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        securityConfiguration.put(new AntPathRequestMatcher("/health-check"), Arrays.<ConfigAttribute>asList(new SecurityConfig("IS_AUTHENTICATED_ANONYMOUSLY")));
        securityConfiguration.put(new AntPathRequestMatcher("/**"), Arrays.<ConfigAttribute>asList(new SecurityConfig("IS_AUTHENTICATED_FULLY")));
        FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource = new DefaultFilterInvocationSecurityMetadataSource(securityConfiguration);
        filterSecurityInterceptor.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
        return filterSecurityInterceptor;
    }

    @Bean
    @Autowired
    public AuthenticationManager authenticationManager(AuthenticationProvider[] providers) {
        return new ProviderManager(Arrays.asList(providers));
    }

    @Bean
    @Autowired
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    @Autowired
    public FilterChainProxy filterChainProxy(DigestAuthenticationFilter digestAuthenticationFilter,
                                             AnonymousAuthenticationFilter anonymousAuthenticationFilter,
                                             ExceptionTranslationFilter exceptionTranslationFilter,
                                             FilterSecurityInterceptor filterSecurityInterceptor) {
        SecurityFilterChain securityFilterChain = new DefaultSecurityFilterChain(new AntPathRequestMatcher("/**"),
                Arrays.<Filter>asList(
                        digestAuthenticationFilter,
                        anonymousAuthenticationFilter,
                        exceptionTranslationFilter,
                        filterSecurityInterceptor));
        return new FilterChainProxy(securityFilterChain);
    }
*/
}
