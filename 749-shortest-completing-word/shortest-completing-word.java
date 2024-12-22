class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] count = new int[26];
        String ans = "*****************";

        // System.out.println("licensePlate. "+licensePlate);

        for(Character ch: licensePlate.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                count[ch-'a'] += 1;
            }
        }

        for(String word: words) {
            // System.out.println("word. "+word+"\ncount  + "+Arrays.toString(count)+"\ncount2 + "+Arrays.toString(getCount(word)));
            
            if(word.length() < ans.length() && isCompleteWord(count, getCount(word))) {
                ans = word;
            }
        }

        return ans;
    }

    public boolean isCompleteWord(int[] word1, int[] word2) {
        for(int i=0; i<26; i++) {
            if(word1[i] > word2[i])
                return false;
        }
        return true;
    }

    public int[] getCount(String word) {
        int[] count = new int[26];
        
        for(Character ch: word.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                count[ch-'a'] += 1;
            }
        }

        return count;
    }
}