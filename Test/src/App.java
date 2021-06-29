import java.util.Arrays;
import java.util.Optional;

public class App {

    /**
     * (- / & space)
     */
    protected static final String ALPHANUMERIC_WITH_SPL_CHARS = "^[a-zA-Z0-9-/&\\s]*$";

    /**
     * (-?:().,'+Space)
     */
    protected static final String ALPHANUMERIC_WITH_SPL_CHARS_2 = "^[a-zA-Z0-9-\\?\\:\\(\\)\\.,'\\+\\s]*$";

    protected boolean isAlphaNumericWithSpecialChar(final String value) {
        return value.matches(ALPHANUMERIC_WITH_SPL_CHARS);
    }

    /**
     * @param swiftId                   {@link String}
     * @param alphanumericWithSplChars2
     * @return
     */
    protected boolean isAlphaNumericWithSpecialChar(final String value, final String regex) {
        return value.matches(regex);
    }

    /**
     * Valid codes are "P" Public or "I" Private
     * 
     * @param value {@link String}
     * @return {@link Boolean}
     */
    protected boolean isVisibilityValid(final String value) {
        return "P".equals(value) || "I".equals(value);
    }

    /**
     * Valid country should not be blank and length should be less then equal to 35.
     * 
     * @param value {@link String}
     * @return {@link Boolean}
     */
    protected boolean isCountryValid(final String value) {
        return !"".equals(value.trim()) && value.length() <= 35;
    }

    /**
     * Valid address should be alphanumeric and length should be less then or equal
     * to 35.
     * 
     * @param value {@link String}
     * @return {@link Boolean}
     */
    protected boolean isBeneficiaryAddressValid(final String value) {
        return value.length() <= 35 && isAlphaNumericWithSpecialChar(value);
    }

    /**
     * Valid name should be {@link #isAlphaNumericWithSpecialChar AlphaNumeric} and
     * length should be less then or equal to 35.
     * 
     * @param value {@link String}
     * @return {@link Boolean}
     */
    protected boolean isBeneficiaryNameValid(final String value) {
        return value.length() <= 35 && isAlphaNumericWithSpecialChar(value);
    }

    /**
     * Swift code should be of length 11, alphanumeric with special characters
     * (-?:().,'+Space)
     * 
     * @param swiftId {@link String}
     * @return {@link Boolean}
     */
    protected boolean isBICCodeValid(String swiftId) {
        return swiftId.length() <= 11 && isAlphaNumericWithSpecialChar(swiftId, ALPHANUMERIC_WITH_SPL_CHARS_2);
    }

    protected boolean isTransactionTypeValid(String otherPartyMaintenanceTransactionMap) {
        final char[] requiredChars = { 'B', 'C', 'I', 'L', 'S' };
        char[] charArray = otherPartyMaintenanceTransactionMap.toUpperCase().toCharArray();
        Arrays.sort(charArray);

        for (int i = 0; i < charArray.length; i++) {
            if (Arrays.binarySearch(requiredChars, charArray[i]) < 0) {
                return false;
            }
            if ((i < charArray.length - 1) && (charArray[i] == charArray[i + 1])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // App obj = new App();

        // System.out.println(obj.isTransactionTypeValid("L"));
        // System.out.println(obj.isTransactionTypeValid("LL"));
        // System.out.println(obj.isTransactionTypeValid("LBC"));
        // System.out.println(obj.isTransactionTypeValid("LBL"));
        // System.out.println(obj.isTransactionTypeValid("LCSLCS"));
        // System.out.println(obj.isTransactionTypeValid("LSS"));
        // System.out.println(obj.isTransactionTypeValid("LCSL"));

        // System.out.println(obj.isAlphaNumericWithSpecialChar("Motilal Nagar 1"));
        // System.out.println(obj.isAlphaNumericWithSpecialChar("Motilal Nagar 1, "));

        // System.out.println(obj.isBICCodeValid("CITIGB2LXXX"));
        // System.out.println(obj.isAlphaNumericWithSpecialChar("CITIGB2LXXX:?<script>",
        // ALPHANUMERIC_WITH_SPL_CHARS_2));

        // System.out.println(obj.isBeneficiaryAddressValid("Motilal Nagar 1"));

        // System.out.println(obj.isBeneficiaryNameValid("Manoj : Kamat"));

        // System.out.println(obj.isCountryValid("India"));

        // System.out.println(obj.isVisibilityValid("P"));
        // System.out.println(obj.isVisibilityValid("IP"));

        // if
        // ((Optional.ofNullable("fileUploadOtherPartyMaintenanceBusinessPolicyData.getName()").orElse("").length()
        // +
        // Optional.ofNullable("fileUploadOtherPartyMaintenanceBusinessPolicyData.getAddressLine1()")
        // .orElse("").length()
        // + Optional.ofNullable("")
        // .orElse("").length()
        // + Optional.ofNullable("")
        // .orElse("").length()
        // + Optional.ofNullable("getCountry()").orElse("")
        // .length()) > 140) {
        // System.out.println("Error....");
        // }

        String SWIFT = "^[a-zA-Z0-9-+:,)(.'?/]*$";
        String SWIFT_X = "^[A-Za-z0-9/\\-?:().,'+\\s\\r\\n]*$";
        String SWIFT_Y = "^[A-Za-z0-9/\\-?:().,'+\\s=!\"%&*<>;]*$";
        String SWIFT_Z = "^[A-Za-z0-9/\\-?:().,'+\\s_=!\"%&*<>;@#{\\r\\n]*$";

        System.out.println("Aasd-B7?:(4).,/'".matches(SWIFT));
        System.out.println("Aasd-B7?:(4).,'/".matches(SWIFT_X));
        System.out.println(" (<sda>;!=)%&".matches(SWIFT_Y));
        System.out.println(" (<sda>;!=)%&*{".matches(SWIFT_Z));
    }
}
