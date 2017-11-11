/**
 * 
 */
package com.naren.rest.music;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author ntanwa
 *
 */
@Service
@CacheConfig(cacheNames = "instruments")
public class MusicService {

	private static Logger log = Logger.getLogger(MusicService.class);

	@CacheEvict(allEntries = true)
	public void clearCache() {
	}

	@Cacheable(condition = "#instrument.equals('trombone')")
	public String play(String instrument) {
		log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
		return "paying " + instrument + "!";
	}

}