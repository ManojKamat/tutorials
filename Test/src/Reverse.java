public class Reverse {
    public static void main(String[] args) {
        String rev = "";
        String s = "Hello World";
        byte[] revBytes = new byte[s.length()];

        byte[] bytes = s.getBytes();
        for (int i = s.length() - 1, j=0; i >= 0; i--,j++) {
            // rev += s.charAt(i);
            revBytes[j] = bytes[i];
        }
        // System.out.println(rev);
        System.out.println(new String(revBytes));
    }
}
