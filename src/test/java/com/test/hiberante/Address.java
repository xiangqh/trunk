package com.test.hiberante;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author xiangqh
 *
 */
@Embeddable
public class Address {

	@Column(name = "city")
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
