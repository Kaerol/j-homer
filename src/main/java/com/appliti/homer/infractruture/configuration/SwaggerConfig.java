package com.appliti.homer.infractruture.configuration;

import io.swagger.models.auth.In;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@EnableSwagger2
@Configuration
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SwaggerConfig {

    private static final String DESCRIPTION = "Authorization header:\n\n" + "\t<Your apiKey>\n\n" + "Build: {0}";

    private static final String AUTHORIZATION_KEY = "Authorization key";
    private static final String CALLER_KEY = "Caller header (CK-RBA)";
    private static final String HTTP_HEADER_CALLER_KEY = "Caller";
    private static final String BASE_PACKAGE = "com.appliti.homer";

    @Bean
    static UiConfiguration uiConfig() {
        return new UiConfiguration(null);
    }

    private static List<SecurityReference> defaultAuth() {
        return Arrays.asList(new SecurityReference(AUTHORIZATION_KEY, new AuthorizationScope[0]),
                             new SecurityReference(CALLER_KEY, new AuthorizationScope[0]));
    }

    private static Predicate<RequestHandler> homerApi() {
        return RequestHandlerSelectors.basePackage(BASE_PACKAGE);
    }

    private static Predicate<String> homerPaths() {
        return Predicates.not(Predicates.or(PathSelectors.regex("/error.*"), PathSelectors.regex("/oauth.*")));
    }

    private static List<ApiKey> getApiKeys() {
        return Arrays.asList(apiKey(), callerKey());
    }

    private static ApiKey apiKey() {
        return new ApiKey(AUTHORIZATION_KEY, HttpHeaders.AUTHORIZATION, In.HEADER.name());
    }

    private static ApiKey callerKey() {
        return new ApiKey(CALLER_KEY, HTTP_HEADER_CALLER_KEY, In.HEADER.name());
    }

    private static ImmutableList<SecurityContext> securityContext() {
        return ImmutableList.of(SecurityContext.builder()
                                               .securityReferences(defaultAuth())
                                               .forPaths(PathSelectors.regex("/.*"))
                                               .build());
    }

    private static List<ResponseMessage> globalResponseGetMessages() {
        final List<ResponseMessage> responseMessages = Lists.newArrayList(getResponseMessage(HttpStatus.OK));
        return getResponseMessages(responseMessages);
    }

    private static List<ResponseMessage> globalResponsePostMessages() {
        final List<ResponseMessage> responseMessages = Lists.newArrayList(getResponseMessage(HttpStatus.CREATED),
                                                                          getResponseMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE));
        return getResponseMessages(responseMessages);
    }

    private static List<ResponseMessage> globalResponsePutMessages() {
        final List<ResponseMessage> responseMessages = Lists.newArrayList(getResponseMessage(HttpStatus.NO_CONTENT),
                                                                          getResponseMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE));
        return getResponseMessages(responseMessages);
    }

    private static List<ResponseMessage> getResponseMessages(final List<ResponseMessage> responseMessages) {
        responseMessages.add(getResponseMessage(HttpStatus.BAD_REQUEST));
        responseMessages.add(getResponseMessage(HttpStatus.METHOD_NOT_ALLOWED));
        responseMessages.add(getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR));
        responseMessages.add(getResponseMessage(HttpStatus.SERVICE_UNAVAILABLE));

        return responseMessages;
    }

    private static ResponseMessage getResponseMessage(final HttpStatus status) {
        return new ResponseMessageBuilder().code(status.value())
                                           .message(status.getReasonPhrase())
                                           .build();
    }

    @Bean
    Docket cardsSwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(cardsManagerApiInfo())
                                                      .directModelSubstitute(ZonedDateTime.class, Date.class)
                                                      .globalResponseMessage(RequestMethod.POST,
                                                                             globalResponsePostMessages())
                                                      .globalResponseMessage(RequestMethod.GET,
                                                                             globalResponseGetMessages())
                                                      .globalResponseMessage(RequestMethod.PUT,
                                                                             globalResponsePutMessages())
                                                      .useDefaultResponseMessages(false)
                                                      .securitySchemes(getApiKeys())
                                                      .securityContexts(securityContext())
                                                      .select()
                                                      .apis(Predicates.or(homerApi()))
                                                      .paths(homerPaths())
                                                      .build();
    }

    private ApiInfo cardsManagerApiInfo() {
        return new ApiInfoBuilder().title("Homer")
                                   .description(DESCRIPTION)
                                   .build();
    }
}
