package com.sp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import com.sp.database.seeders.CardSeeder;
import com.sp.repository.CardRepository;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@EnableFeignClients
public class SpAppHero implements WebApplicationInitializer {

        public static void main(String[] args) {
                SpringApplication.run(SpAppHero.class, args);
        }

        public void onStartup(ServletContext servletContext) throws ServletException {
                AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
                ctx.register(SpAppHero.class);
                ctx.setServletContext(servletContext);
                Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
                dynamic.addMapping("/");
                dynamic.setLoadOnStartup(1);
        }
}
