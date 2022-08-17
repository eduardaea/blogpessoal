package com.generation.blogpessoalduda.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI sptingBlogPesssoalOpenAPI() {
		return new OpenAPI()
				.info(new Info()
					.title("Projeto Blog Pessoal de Eduarda")
					.description("Projeto Blog Pessoal Eduarda")
					.version("V0.0.1")
				.license(new License()
					.name("Generation Brasil")
					.url("https://Brazil.generation.org/"))
				.contact(new Contact()
					.name("Conteudo Generation")
					.url("https://github.com/eduardaea/blogpessoal")
					.email("eduarda.albuquerque@hotmail.com")))
				.externalDocs(new ExternalDocumentation()
					.description("Github")
					.url("https://github.com/conteudoGeneration/"));								
	}
	
		@Bean
		public  OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
			return openApi -> {
				openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation ->{
					ApiResponses apiReponses = operation.getResponses();
					
					apiReponses.addApiResponse("200", createApiResponse("Sucesso!"));
					apiReponses.addApiResponse("201", createApiResponse("Objeto Pesistido!"));
					apiReponses.addApiResponse("204", createApiResponse("Objeto Excluido!"));
					apiReponses.addApiResponse("400", createApiResponse("Erro na Requisição"));
					apiReponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
					apiReponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
					apiReponses.addApiResponse("500", createApiResponse("Erro na Aplicação"));
					
				}));
			};		
				
		}
		
		private ApiResponse createApiResponse(String message) {
			return new ApiResponse().description(message);
		}
	
}
