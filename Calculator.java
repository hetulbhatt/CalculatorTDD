import java.util.Set;
import java.util.TreeSet;

public class Calculator {
    Set<Character> specialCharacters;

    Calculator() {
        this.specialCharacters = new TreeSet<>();
        this.specialCharacters.add('.');
        this.specialCharacters.add('+');
        this.specialCharacters.add('*');
        this.specialCharacters.add('?');
        this.specialCharacters.add('^');
        this.specialCharacters.add('$');
        this.specialCharacters.add('(');
        this.specialCharacters.add(')');
        this.specialCharacters.add('[');
        this.specialCharacters.add(']');
        this.specialCharacters.add('{');
        this.specialCharacters.add('}');
        this.specialCharacters.add('\\');
    }

    public int add(String numbers) {
        int result = 0;
        
        if(numbers == null || numbers.isEmpty()) {;}
        else if(numbers.startsWith("//")) {
            String dlmtr = "";
            if(numbers.contains("[")) {
                dlmtr = extractDlmtrs(numbers);
                numbers = numbers.substring(numbers.lastIndexOf("]")+2);
            } else {
                dlmtr = numbers.substring(2,3);
                numbers = numbers.substring(4);
            }
            try {
                result = doSummationGivenDlmtr(numbers, dlmtr);
            } catch(NegativesNotAllowedException e) {
                e.printStackTrace();
            }
            
        } else if(numbers.contains(",")) {
            String dlmtr = ",|\n";
            try {
                result = doSummationGivenDlmtr(numbers, dlmtr);
            } catch(NegativesNotAllowedException e) {
                e.printStackTrace();
            }    
        } else {
            result = Integer.parseInt(numbers);
        }
        return result;
    }

    private String extractDlmtrs(String numbers) {
        StringBuilder sbr = new StringBuilder();
        String[] delims = numbers.substring(3, numbers.lastIndexOf("]")).split("\\]\\[");
        if(delims.length > 0) {
            for(String s : delims) {
                sbr.append(s+"|");
            }
            sbr.delete(sbr.length()-1, sbr.length());
        }
        String intermediateDlmtr = sbr.toString();
        StringBuilder finalDlmtr = new StringBuilder();
        for(char c : intermediateDlmtr.toCharArray()) {
            if(this.specialCharacters.contains(c)) {
                finalDlmtr.append("\\" + c);
            } else {
                finalDlmtr.append("" + c);
            }
        }
        return finalDlmtr.toString();
    }

    private int doSummationGivenDlmtr(String expr, String dlmtr) throws NegativesNotAllowedException {
        int result = 0;
        String[] nums = expr.split(dlmtr);
        StringBuilder exceptionMessage = new StringBuilder();
        for(String str : nums) {
            int num = Integer.parseInt(str);
            if(num < 0) {
                exceptionMessage.append(String.valueOf(num)+" ");
            }
            if(num > 1000) {
                continue;
            }
            result += num;
        }
        if(exceptionMessage.length() > 0) {
            throw new NegativesNotAllowedException(exceptionMessage.toString());
        }
        return result;
    }
}