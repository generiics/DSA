class Solution {
    public List<String> commonChars(String[] words) {
        int[] freq=new int[26];
        for(char c:words[0].toCharArray()){
            freq[c-'a']++;
        }

        for(int i=1;i<words.length;i++){
            int[] temp=new int[26];
            for(char ch:words[i].toCharArray()){
                temp[ch-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                freq[j] = Math.min(freq[j], temp[j]);
            }
        }
                List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {

            while (freq[i] > 0) {
                ans.add(String.valueOf((char)(i + 'a')));
                freq[i]--;
            }
        }

     return ans;
    }
}