package com.example.cybrilla.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cybrilla.entity.Url;
import com.example.cybrilla.repository.UrlRepository;

/**
 * @author maneesh.sinha
 *
 */
public class UrlShortnerServiceImpl implements UrlShortnerService {
	
	@Autowired
	private UrlRepository urlRepository;
	
	@Autowired
	private  BaseConversionService conversion;

	@Override
	public String generateFullUrl(String shortUrl) {
		long id = (int) conversion.decode(shortUrl);
		Object url = urlRepository.findById(id);
		if(url == null) {
			throw new RuntimeException("Url does not exist");
		}
		return ((Url) url).getLongUrl();
	}

	@Override
	public String convertToShortUrl(String fullUrl) {
		Url url = new Url();
        url.setLongUrl(fullUrl);
        Url savedUrl =  urlRepository.save(url);

        return conversion.encode(savedUrl.getId());
	}

}
