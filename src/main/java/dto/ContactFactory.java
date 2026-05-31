package dto;

import com.github.javafaker.Faker;

public class ContactFactory {
    public static Contact getContact() {
        Faker faker = new Faker();
        return Contact.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .phone(faker.phoneNumber().phoneNumber())
                .mobile(faker.phoneNumber().cellPhone())
                .site(faker.internet().url())
                .fax(faker.phoneNumber().phoneNumber())
                .streetBilling(faker.address().streetAddress())
                .streetShipping(faker.address().streetAddress())
                .cityBilling(faker.address().city())
                .cityShipping(faker.address().city())
                .regionBilling(faker.address().state())
                .regionShipping(faker.address().state())
                .postalCodeBilling(faker.address().zipCode())
                .postalCodeShipping(faker.address().zipCode())
                .countryBilling(faker.address().country())
                .countryShipping(faker.address().country())
                .description(faker.lorem().sentence())
                .annualRevenue(String.valueOf(faker.number().numberBetween(10000, 10000000)))
                .type(faker.company().industry())
                .industry(faker.company().profession())
                .build();
    }
}
