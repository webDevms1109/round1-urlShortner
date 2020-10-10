/**
 * 
 */
package com.example.cybrilla.service;

import org.springframework.stereotype.Service;

/**
 * @author maneesh.sinha
 *
 */
@Service
public interface UrlShortnerService {
	
	String generateFullUrl(String shortUrl);

	String convertToShortUrl(String fullUrl);

}
