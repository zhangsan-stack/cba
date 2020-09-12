package com.shop.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Shopkeeper implements Serializable {
	static final long serialVersionUID =1L;
	private Integer id ;
	private String keepername ;
	private String password ;
	private Integer exchange_id ;
	private Integer buyerid ;
	private Integer keepercount ;

	@DateTimeFormat(pattern="yyyy-MM-dd H:i:s")
	private Date exchange_time ;

}
