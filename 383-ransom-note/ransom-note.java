class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomArr = ransomNote.toCharArray();
        char[] magazineArr = magazine.toCharArray();
        Arrays.sort(ransomArr);
        Arrays.sort(magazineArr);

        int i = 0, len = magazineArr.length;
        for(Character j: ransomArr) {
            while(i<len && magazineArr[i] < j) i++;

            if(i >= len || magazineArr[i] != j) return false;
            i++;
        }

        return true;
    }
}