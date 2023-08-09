import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class letterCompination {
   public List<String> letterCombinations(String digits) {
        
		List<String> result=new ArrayList<>();
		if(digits.isEmpty()) return result;
		String[] dir = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		result.add("");
		for(int i =0; i<digits.length();i++){
			int ch = Character.getNumericValue(digits.charAt(i));
			while(result.get(0).length()==i){
				String str = result.remove(0);
				for(char c: dir[ch].toCharArray())
					result.add(str+c);
			}
		}
		return result;
	}

    //Optimal solution
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> result=new LinkedList<>();
        if(digits.isEmpty()) return result;
        String[] dir = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};
        result.add("");
        for(int i =0; i<digits.length();i++){
            int ch = Character.getNumericValue(digits.charAt(i));
            while(result.peek().length()==i){
                String str = result.remove();
                for(char c: dir[ch].toCharArray())
                    result.add(str+c);
            }
        }
        return result;
    }
    //Recursive solution
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        public List<String> letterCombinations3(String digits) {
            List<String> result = new ArrayList<>();
            if(digits.length() == 0){
                return result;
            }
            recurs(digits, new StringBuilder(), 0, result);
            return result;
            
        }
    
        void recurs(String digits, StringBuilder s, int begin, List<String> result){
            if(s.length() == digits.length()){
                result.add(s.toString());
                return;
            }
            for(int i=0; i<letters[digits.charAt(begin)-'0'].length(); i++){
                s.append(letters[digits.charAt(begin)-'0'].charAt(i));
                recurs(digits, s, begin+1, result);
                s.deleteCharAt(s.length()-1);
            }
        }
    
    public static void main(String[] args) {
        letterCompination obj=new letterCompination();
        String str="23";
        System.out.println(obj.letterCombinations(str));
    }
}
