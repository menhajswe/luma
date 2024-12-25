package constants;

/**
 * Luma constants values here saved to avoid redundency.
 */
public enum LumaConstants {
    BASE_URL("https://magento.softwaretestingboard.com"),
    CREATE_USER_URL("https://magento.softwaretestingboard.com/customer/account/create"),
    SIGNIN_URL("https://magento.softwaretestingboard.com/customer/account/login"),
    HOME_PAGE_URL("https://magento.softwaretestingboard.com/"),
    USER_NAME("test"),
    EMAIL(System.getenv("testEmail")),
    PASSWORD(System.getenv("testPassword"));

    private final String value;

    LumaConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
