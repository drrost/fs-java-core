package com.rdruzhchenko.fsjavacore;

public class FSStringUtils {
    public static String trimAll(String s) {
        if (s == null) {
            return null;
        }
        return s.trim().replaceAll("\\s+", " ");
    }

    public static String trimLeading(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceFirst("^\\s+", "");
    }

    public static String trimAllAndColon(String s) {
        return trimAll(trimLeadingColon(s));
    }

    public static String trimLeadingColon(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("^:", "");
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    public static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String decapitalize(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }

    public static String charAt(String s,int i) {
        char ch = s.charAt(i);
        return ch + "";
    }

    public static String trunkTillLength(String s, int length) {
        if (s.length() <= length) {
            return s;
        } else {
            return s.substring(0, length);
        }
    }

    public static String getLast(String unit) {
        if (unit != null) {
            return unit.substring(unit.length() - 1, unit.length());
        }
        return null;
    }

    public static Character getLastChar(String s) {
        if (s == null) {
            throw new RuntimeException("passed string is `null`");
        }

        var lastString = getLast(s);
        return lastString.charAt(0);
    }

    public static boolean nullOrEmpty(String s) {
        if (s == null) {
            return true;
        }

        return s.trim().equals("");
    }

    public static String dropFirstWord(String s) {
        s = FSStringUtils.trimLeading(s);

        int index = s.indexOf(" ");
        if (index > -1) {
            return s.substring(index + 1);
        }

        return "";
    }

    public static String trim(String s, String toTrim) {
        if (s.endsWith(toTrim)) {
            return s.substring(0, s.length() - toTrim.length());
        }
        return s;
    }

    public String removeNewlines(String s) {
        s = s.replace("\r\n", "");
        return s.replace("\n", "");
    }

    /**
     * Splits a full filename into name and extension.
     *
     * @param fileName Full file name
     * @return An array with [name, extension]. If no extension is found,
     *         extension will be an empty string.
     */
    public static String[] splitFileName(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            String name = fileName.substring(0, dotIndex);
            String extension = fileName.substring(dotIndex + 1);
            return new String[] {name, extension};
        }
        return new String[] {fileName, ""};
    }
}