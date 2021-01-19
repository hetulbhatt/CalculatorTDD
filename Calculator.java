public class Calculator {
    public int add(String numbers) {
        int result = 0;

        if(numbers == null || numbers.isEmpty()) {;}
        else if(numbers.startsWith("//")) {
            String dlmtr = numbers.substring(2,3);
            try {
                result = new Calculator().doSummationGivenDlmtr(numbers.substring(4), dlmtr);
            } catch(NegativesNotAllowedException e) {
                e.printStackTrace();
            }
            
        }
        else if(numbers.contains(",")) {
            String dlmtr = ",|\n";
            try {
                result = new Calculator().doSummationGivenDlmtr(numbers, dlmtr);
            } catch(NegativesNotAllowedException e) {
                e.printStackTrace();
            }
            
        } else {
            result = Integer.parseInt(numbers);
        }
        
        return result;
    }

    public int doSummationGivenDlmtr(String expr, String dlmtr) throws NegativesNotAllowedException {
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

    // public static void main(String[] args) {
    //     new Calculator().add("1\n2,3");
    // }
}