package enumUI;

public enum EnumContAcc {
    NAME("Name"),
    FIRST_NAME("First Name"),
    OFFICE_PHONE("Office Phone"),
    WEBSITE("Website"),
    FAX("Fax"),
    EMAIL("Email Address"),
    LAST_NAME("Last Name"),
    MOBILE("Mobile"),
    JOB_TITLE("Job Title"),
    DEPARTMENT("Department"),
    BILLING_ADDRESS("Billing Address"),
    PRIMARY_ADDRESS("Primary Address"),
    ADDRESS("Address"),
    OTHER_ADDRESS("Other Address"),
    BILLING_STREET("Street"),
    BILLING_CITY("City"),
    BILLING_STATE_REGION("State/Region"),
    BILLING_POSTAL_CODE("Postal Code"),
    BILLING_COUNTRY("Country"),
    SHIPPING_ADDRESS("Shipping Address"),
    SHIPPING_STREET("Street"),
    SHIPPING_CITY("City"),
    SHIPPING_STATE_REGION("State/Region"),
    SHIPPING_POSTAL_CODE("Postal Code"),
    SHIPPING_COUNTRY("Country"),

    DESCRIPTION("Description"),
    ASSIGNED_TO("Assigned to"),
    TYPE("Type"),
    ANNUAL_REVENUE("Annual Revenue"),
    MEMBER_OF("Member of"),
    CAMPAIGN("Campaign"),
    INDUSTRY("Industry"),
    EMPLOYEES("Employees"),

    //Checkbox
    OPTED_OUT("Opted Out"),
    INVALID("Invalid");

    private final String displayName;

    EnumContAcc(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        if (displayName.equals("Type") || displayName.equals("Industry")) {
            return displayName.toLowerCase();
        } else {
            return displayName;
        }
    }
}
