package edu.eci.cvds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.eci.cvds.service.ConfigurationService;

import javax.activation.DataSource;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.ecci.cvds.guess","edu.eci.cvds.repository","edu.eci.cvds.service","edu.eci.cvds.user"})
@EnableJpaRepositories(basePackages = "edu.eci.cvds.repository")
public class Main{

  public static void main (String[] args) {
      SpringApplication.run(Main.class, args);
  }

  @Bean
  ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
      //spring boot only works if this is set
      servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

      //registration
      ServletRegistrationBean srb = new ServletRegistrationBean();
      srb.setServlet(new FacesServlet());
      srb.setUrlMappings(Arrays.asList("*.xhtml"));
      srb.setLoadOnStartup(1);
      return srb;
  }
}
