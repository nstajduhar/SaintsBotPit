package naivgationdrawer;


class StringUtilities {
    StringUtilities() {
    }

    public static String pad(int fieldWidth, char padChar, String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length();
        while (i < fieldWidth) {
            sb.append(padChar);
            ++i;
        }
        sb.append(s);
        return sb.toString();
    }

}
