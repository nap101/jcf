package com.brtpawn.mpps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.brtpawn.mpps.mapper")//标记扫描的mapper位置
public class MppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MppsApplication.class, args);
	}

}
