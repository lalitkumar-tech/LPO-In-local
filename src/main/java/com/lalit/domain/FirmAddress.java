package com.lalit.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class FirmAddress extends BaseEntity{

	 
		private static final long serialVersionUID = -2993891404645409128L;

		@OneToOne
		private Country country;

		@OneToOne
		private State state;

		@OneToOne
		private City city;

		private String zipCode;

		private String address_one;

		private String address_two;

		public FirmAddress() {
			super();
		}

		public FirmAddress(Country country, State state, String address_one, String address_two) {
			super();
			this.country = country;
			this.state = state;
			this.address_one = address_one;
			this.address_two = address_two;
		}

		public FirmAddress(Country country, State state, City city, String zipCode, String address_one,
				String address_two) {
			super();
			this.country = country;
			this.state = state;
			this.city = city;
			this.zipCode = zipCode;
			this.address_one = address_one;
			this.address_two = address_two;
		}

		public Country getCountry() {
			return country;
		}

		public void setCountry(Country country) {
			this.country = country;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
		}

		public String getAddress_one() {
			return address_one;
		}

		public void setAddress_one(String address_one) {
			this.address_one = address_one;
		}

		public String getAddress_two() {
			return address_two;
		}

		public void setAddress_two(String address_two) {
			this.address_two = address_two;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		@Override
		public String toString() {
			return "FirmAddress [country=" + country + ", state=" + state + ", city=" + city + ", zipCode=" + zipCode
					+ ", address_one=" + address_one + ", address_two=" + address_two + "]";
		}
}
