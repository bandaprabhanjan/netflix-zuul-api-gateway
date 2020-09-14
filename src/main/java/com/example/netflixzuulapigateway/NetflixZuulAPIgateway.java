package com.example.netflixzuulapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulAPIgateway {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulAPIgateway.class, args);
		System.out.println("Prabhanjan-Netflix-zuul-api");
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}

//every micro service call should be intercepted by zuul api gateway
//Netflix provides zuul api implementation

//If we want to trace all the requests then we should create bean for "Always Sampler"