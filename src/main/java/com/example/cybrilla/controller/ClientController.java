package com.example.cybrilla.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cybrilla.service.UrlShortnerService;

@RestController
@RequestMapping("/url")
public class ClientController {
	
	@Autowired
	private UrlShortnerService urlService;
	
	@GetMapping("map/{shortUrl}")
	public ResponseEntity<Void> getMappedLongUrl(@PathVariable String shortUrl) {
		String redirectUrl = "";
		if(shortUrl.length() >= 10) {
			redirectUrl = urlService.generateFullUrl(shortUrl);
		} else {
			throw new RuntimeException("Url entered is not of valid length");
		}
		
		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(redirectUrl))
				.build();
	}
	
	@PostMapping("/convertToShort")
	public String convertToShortUrl(@RequestParam String fullUrl) {
		return urlService.convertToShortUrl(fullUrl);
	}
}
