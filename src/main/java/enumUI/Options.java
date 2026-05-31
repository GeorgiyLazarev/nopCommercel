package enumUI;

public enum Options {
    ANALYST("Analyst"),
    COMPETITOR("Competitor"),
    CUSTOMER("Customer"),
    INTEGRATOR("Integrator"),
    INVESTOR("Investor"),
    PARTNER("Partner"),
    PRESS("Press"),
    PROSPECT("Prospect"),
    RESELLER("Reseller"),
    OTHER("Other"),
    APPAREL("Apparel"),
    BANKING("Banking"),
    BIOTECHNOLOGY("Biotechnology"),
    CHEMICALS("Chemicals"),
    COMMUNICATIONS("Communications"),
    CONSTRUCTION("Construction"),
    CONSULTING("Consulting"),
    EDUCATION("Education"),
    ELECTRONICS("Electronics"),
    ENERGY("Energy"),
    ENGINEERING("Engineering"),
    ENTERTAINMENT("Entertainment"),
    ENVIRONMENTAL("Environmental"),
    FINANCE("Finance"),
    GOVERNMENT("Government"),
    HEALTHCARE("Healthcare"),
    HOSPITALITY("Hospitality"),
    INSURANCE("Insurance"),
    MACHINERY("Machinery"),
    MANUFACTURING("Manufacturing"),

    //Contact
    MR("Mr."),
    MS("Ms."),
    MRS("Mrs."),
    MISS("Miss"),
    DR("Dr."),
    PROF("Prof."),
    COLD_CALL("Cold Call"),
    EXISTING_CUSTOMER("Existing Customer"),
    SELF_GENERATED("Self Generated"),
    EMPLOYEE("Employee"),
    PUBLIC_RELATIONS("Public Relations"),
    DIRECT_MAIL("Direct Mail"),
    CONFERENCE("Conference"),
    TRADE_SHOW("Trade Show"),
    WEB_SITE("Web Site"),
    WORD_OF_MOUTH("Word of mouth"),
    EMAIL("Email"),
    CAMPAIGN("Campaign");

    private final String displayName;

    Options(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
