package com.naren.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.naren.rest.music.MusicService;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableCaching
@PropertySource({ "classpath:db-mysql.properties" }) // if this commented it
														// will connect to DB2
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@Component
@Order(value = 1)
class UserComponent implements CommandLineRunner {
	
	private static Logger log = Logger.getLogger(Application.class);
	@Autowired
	private MusicService musicService;

	@Autowired
	private CacheManager cacheManager;

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Application Started");
		log.info("Spring Boot Ehcache 2 Caching Example Configuration");
		log.info("using cache manager: " + cacheManager.getClass().getName());

		musicService.clearCache();

		play("trombone");
		play("guitar");
		play("trombone");
		play("bass");
		play("trombone");
	}

	private void play(String instrument) {
		log.info("Calling: " + MusicService.class.getSimpleName() + ".play(\"" + instrument + "\");");
		musicService.play(instrument);
	}

}