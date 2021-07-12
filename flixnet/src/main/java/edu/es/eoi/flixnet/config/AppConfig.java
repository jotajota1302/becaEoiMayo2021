package edu.es.eoi.flixnet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.es.eoi.flixnet.MainApp;

@Configuration
@ComponentScan(basePackageClasses = MainApp.class)
public class AppConfig {

}
