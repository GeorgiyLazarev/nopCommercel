package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getAccount(String name) {
        Faker faker = new Faker();
        return Account.builder()
                .name(name)
                .phone(faker.phoneNumber().phoneNumber())
                .site(faker.internet().url())
                .fax(faker.phoneNumber().phoneNumber())
                .streetBilling(faker.address().streetAddress())
                .cityBilling(faker.address().city())
                .countryBilling(faker.address().country())
                .description(faker.lorem().fixedString(50))
                .build();
    }
}
