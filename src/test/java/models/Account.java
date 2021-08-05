package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    String accountName;
    String phone;
    String website;
    String employees;
    String billingCity;
    String billingState;
    String shippingCity;
    String shippingState;
    String billingZipCode;
    String billingCountry;
    String shippingZipCode;
    String shippingCountry;
    String description;
    String billingStreet;
    String shippingStreet;
    String type;
    String industry;

}

