package org.itstep;
public class StringCalculator {
    public static int add(String s) throws SpliterFormatException {
        if (s == null || "".equals(s)) { // equ - сравнение
            return 0;
        } else { // kata 9
            if (s.contains("-")) {
                int n;
                try {
                    n = Integer.parseInt(s.trim());
                } catch (Exception ex) {
                    throw new SpliterFormatException(ex);
                }
            }
            int sum = 0;

            if (s.startsWith("//")) { // kata 5
                if(s.indexOf("[")!=-1 && s.indexOf("]")!=-1){
                    char[]temp = s.toCharArray();
                    if(s.indexOf("*")!=-1)
                    {   for(int i = 0; i < temp.length; i++) {
                        if (temp[i] == '*') {
                            temp[i] = 'd';
                        }
                    }
                    }
                    s = "";
                    for (int i = 0; i < temp.length; i++) {
                        s +=Character.toString(temp[i]);
                    }
                    String del = "";
                    for (int i = 0; i < s.length(); i++) {
                        if(s.charAt(i)=='['){
                            for (int j = i+1;s.charAt(j)!=']'; j++) {
                                del += Character.toString(s.charAt(j));
                            }
                            del += "|";
                        }
                    }
                    String[] arr = s.split(del);
                    for (int i = 0; i < arr.length; i++) {
                        if(!"".equals(arr[i])){
                            if(checkString(arr[i])!=false) {
                                sum += Integer.parseInt(arr[i]);
                            }
                        }
                    }
                    return sum;
                }
                else {
                    String[] parts = s.split("\\n");
                    String d = parts[0].substring(2).trim();
                    d = d.replace("*", "\\D");
                    String[] arr = parts[1].split(d);
                    for (int i = 0; i < arr.length; i++) {
                        int n;
                        try {
                            n = Integer.parseInt(arr[i].trim());
                        } catch (Exception ex) {
                            throw new SpliterFormatException(ex);
                        }
                        if (n > 1000) continue;
                        sum += n;
                    }
                }
            } else { // kata 1-4
                String d = ",|\\n";
                String[] arr = s.split(d);
                for (int i = 0; i < arr.length; i++) {
                    int n = Integer.parseInt(arr[i].trim());
                    if (n > 1000) continue;
                    sum += n;
                }
            }
            return sum;
        }
    }
    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}