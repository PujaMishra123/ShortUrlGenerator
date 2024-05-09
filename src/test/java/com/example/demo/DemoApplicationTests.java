package com.example.demo;

import com.example.demo.services.UrlShortenerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
	@Mock
	private UrlShortenerService service;

	@Test
	private void testShortUrlGenerate()
	{
		String origUrl="https://test-short.url/spring/test-guide/users/profile";
		String result="https://test-short.url/bf5ghj8";
		Mockito.when(service.convertLongToShort(origUrl)).thenReturn(result);
		String url = service.convertLongToShort(origUrl);

		// Verifying the result
		assertEquals(result,url);
	}
	@Test
	private void testLongUrlGenerate()
	{
		String origUrl="https://test-short.url/spring/test-guide/users/profile";
		String result="https://test-short.url/bf5ghj8";
		Mockito.when(service.convertShortToLong(result)).thenReturn(origUrl);
		String url = service.convertLongToShort(result);

		// Verifying the result
		assertEquals(origUrl,url);
	}

}
