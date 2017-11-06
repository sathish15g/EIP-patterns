package com.example.demo;

public class BusBooking {
	
	private String pnrNo;
	
	private String customerName;

	private BookingStatus bookingStatus;

	
	public BusBooking(String pnrNo, String customerName, BookingStatus bookingStatus) {
		super();
		this.pnrNo = pnrNo;
		this.customerName = customerName;
		this.bookingStatus = bookingStatus;
	}


	public String getPnrNo() {
		return pnrNo;
	}


	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Override
	public String toString() {
		return "BusBooking [pnrNo=" + pnrNo + ", customerName=" + customerName + ", bookingStatus=" + bookingStatus
				+ "]";
	}


	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	
	
}
enum BookingStatus{
	BOOKED,
	CANCELED,
	PENDING;
}
