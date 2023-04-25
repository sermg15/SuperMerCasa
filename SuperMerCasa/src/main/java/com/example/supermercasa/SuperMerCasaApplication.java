package com.example.supermercasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@SpringBootApplication
@EnableHazelcastHttpSession
public class
SuperMerCasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperMerCasaApplication.class, args);
	}

	@Bean
	public Config config() {

		Config config = new Config();

		JoinConfig joinConfig = config.getNetworkConfig().getJoin();

		joinConfig.getMulticastConfig().setEnabled(false);
		joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("192.168.20.90"));

		return config;
	}

}
