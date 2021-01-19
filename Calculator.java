public class Calculator {
    public int add(String numbers) {
        int result = 0;

        if(numbers == null || numbers.isEmpty()) {;}
        else if(numbers.contains(",")) {
            String[] nums = numbers.split(",|\n");
            for(String str : nums) {
                result += Integer.parseInt(str);
            }
        } else {
            result = Integer.parseInt(numbers);
        }

        return result;
    }
}