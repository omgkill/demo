package com.example.demo;

import com.example.demo.mapper.CountryMapper;
import com.example.demo.mapper.UserLuckyMapper;
import com.example.demo.model.Country;
import com.example.demo.model.UserLucky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan(basePackages = "com.example.demo.mapper")
@SpringBootApplication
public class DemoApplication  {

	@Autowired
	private UserLuckyMapper userLuckyMapper;

//	@Autowired
//	private CountryMapper countryMapper;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		List<UserLucky> countries = userLuckyMapper.selectAll();
//		for (UserLucky country : countries) {
//			System.out.println("Country Name: " + country.getUid());
//		}
//
////		List<Country> countries = countryMapper.selectAll();
////		for (Country country : countries) {
////			System.out.println("Country Name: " + country.getCountryname());
////		}
//	}
}
