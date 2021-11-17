package com.maxrt.data

import com.google.common.base.Predicates
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.builders.{ApiInfoBuilder, PathSelectors}

import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

object SwaggerConfiguration {
  private val SWAGGER_API_VERSION = "1.0"
  private val LICENSE_TEXT = "License"
  private val TITLE = "Spring Boot App (lab6) by maxrt"
  private val DESCRIPTION = "project"
}

@EnableSwagger2
@Configuration
class SwaggerConfiguration {

  private def apiInfo =
    new ApiInfoBuilder()
      .title(SwaggerConfiguration.TITLE)
      .description(SwaggerConfiguration.DESCRIPTION)
      .license(SwaggerConfiguration.LICENSE_TEXT)
      .version(SwaggerConfiguration.SWAGGER_API_VERSION)
      .build

  @Bean
  def decksApi: Docket =
    new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo)
      .pathMapping("/")
      .select
      .paths(PathSelectors.any)
      .build
}
