package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AccountFactory {

    public static Account get(){
        log.info("Create new Account");
        Faker faker = new Faker();
        return Account.builder().
                accountName(faker.name().name())
                .phone(faker.phoneNumber().phoneNumber())
                .website("onliner.by")
                .employees("80")
                .billingCity(faker.address().city())
                .billingStreet(faker.address().streetAddress())
                .billingState("Minsk")
                .billingCountry("Belarus")
                .billingZipCode("220015")
                .shippingCity("Moscow")
                .shippingCountry("Russia")
                .shippingStreet(faker.address().streetAddress())
                .shippingZipCode("220014")
                .description("Something..")
                .shippingState("Minsk")
                .build();
    }
}
