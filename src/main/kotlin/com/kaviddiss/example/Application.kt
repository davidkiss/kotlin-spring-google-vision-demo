package com.kaviddiss.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

@SpringBootApplication(scanBasePackages = arrayOf("com.kaviddiss.example"))
class Application: SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(Application::class.java)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}