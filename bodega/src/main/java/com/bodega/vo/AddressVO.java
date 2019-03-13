package com.bodega.vo;

public class AddressVO {

	private String addressName;
	private String addressUserName;
	private String addressUserLastName;
	private String addressStreet;
	private String addressOutNumber;
	private String addressInnerNumber;
	private String addressZipcode;
	private String addressNeighbornhood;
	private String addressReferenceOne;
	private String addressReferenceTwo;
	private String addressPhoneOption;
	private String addressPhone;

	public AddressVO(String addressName, String addressUserName, String addressUserLastName, String addressStreet,
			String addressOutNumber, String addressInnerNumber, String addressZipcode, String addressNeighbornhood,
			String addressReferenceOne, String addressReferenceTwo, String addressPhoneOption, String addressPhone) {
		super();
		this.addressName = addressName;
		this.addressUserName = addressUserName;
		this.addressUserLastName = addressUserLastName;
		this.addressStreet = addressStreet;
		this.addressOutNumber = addressOutNumber;
		this.addressInnerNumber = addressInnerNumber;
		this.addressZipcode = addressZipcode;
		this.addressNeighbornhood = addressNeighbornhood;
		this.addressReferenceOne = addressReferenceOne;
		this.addressReferenceTwo = addressReferenceTwo;
		this.addressPhoneOption = addressPhoneOption;
		this.addressPhone = addressPhone;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressUserName() {
		return addressUserName;
	}

	public void setAddressUserName(String addressUserName) {
		this.addressUserName = addressUserName;
	}

	public String getAddressUserLastName() {
		return addressUserLastName;
	}

	public void setAddressUserLastName(String addressUserLastName) {
		this.addressUserLastName = addressUserLastName;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressOutNumber() {
		return addressOutNumber;
	}

	public void setAddressOutNumber(String addressOutNumber) {
		this.addressOutNumber = addressOutNumber;
	}

	public String getAddressInnerNumber() {
		return addressInnerNumber;
	}

	public void setAddressInnerNumber(String addressInnerNumber) {
		this.addressInnerNumber = addressInnerNumber;
	}

	public String getAddressZipcode() {
		return addressZipcode;
	}

	public void setAddressZipcode(String addressZipcode) {
		this.addressZipcode = addressZipcode;
	}

	public String getAddressNeighbornhood() {
		return addressNeighbornhood;
	}

	public void setAddressNeighbornhood(String addressNeighbornhood) {
		this.addressNeighbornhood = addressNeighbornhood;
	}

	public String getAddressReferenceOne() {
		return addressReferenceOne;
	}

	public void setAddressReferenceOne(String addressReferenceOne) {
		this.addressReferenceOne = addressReferenceOne;
	}

	public String getAddressReferenceTwo() {
		return addressReferenceTwo;
	}

	public void setAddressReferenceTwo(String addressReferenceTwo) {
		this.addressReferenceTwo = addressReferenceTwo;
	}

	public String getAddressPhoneOption() {
		return addressPhoneOption;
	}

	public void setAddressPhoneOption(String addressPhoneOption) {
		this.addressPhoneOption = addressPhoneOption;
	}

	public String getAddressPhone() {
		return addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}
}
