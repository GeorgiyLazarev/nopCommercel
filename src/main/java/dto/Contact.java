package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Contact {

    @Builder.Default
    private String firstName = "Gosha";

    @Builder.Default
    private String lastName = "Lazarev";

    @Builder.Default
    private String phone = "899889";

    @Builder.Default
    private String mobile = "89029839318";

    @Builder.Default
    private String site = "classroom.google.com/w/ODUwODg4NTI0MTc5/t/all";

    @Builder.Default
    private String fax = "test";

    @Builder.Default
    private String streetBilling = "Улица Пушкина, дом колотушкина";

    @Builder.Default
    private String streetShipping = "Улица Лермонтова, дом 3";

    @Builder.Default
    private String cityBilling = "Краснодар";

    @Builder.Default
    private String cityShipping = "Москва";

    @Builder.Default
    private String regionBilling = "Moscow";

    @Builder.Default
    private String regionShipping = "Samara";

    @Builder.Default
    private String postalCodeBilling = "3432123";

    @Builder.Default
    private String postalCodeShipping = "3453423";

    @Builder.Default
    private String countryBilling = "Russia";

    @Builder.Default
    private String countryShipping = "USA";

    @Builder.Default
    private String description = "Любой текст";

    @Builder.Default
    private String annualRevenue = "Любой текст";

    @Builder.Default
    private String type = "Любой текст";

    @Builder.Default
    private String industry = "Любой текст";
}
