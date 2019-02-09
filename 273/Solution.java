class Solution {
    String HUNDRED = "Hundred";
    String THOUSAND = "Thousand";
    String MILLION = "Million";
    String BILLION = "Billion";
    
    String[] str = new String[20];
    String[] doubleDigit = new String[10];
    
    public String numberToWords(int num) {
        str[0] = "Zero";
        str[1] = "One";
        str[2] = "Two";
        str[3] = "Three";
        str[4] = "Four";
        str[5] = "Five";
        str[6] = "Six";
        str[7] = "Seven";
        str[8] = "Eight";
        str[9] = "Nine";
        str[10] = "Ten";
        str[11] = "Eleven";
        str[12] = "Twelve";
        str[13] = "Thirteen";
        str[14] = "Fourteen";
        str[15] = "Fifteen";
        str[16] = "Sixteen";
        str[17] = "Seventeen";
        str[18] = "Eighteen";
        str[19] = "Nineteen";
        
        doubleDigit[2] = "Twenty";
        doubleDigit[3] = "Thirty";
        doubleDigit[4] = "Forty";
        doubleDigit[5] = "Fifty";
        doubleDigit[6] = "Sixty";
        doubleDigit[7] = "Seventy";
        doubleDigit[8] = "Eighty";
        doubleDigit[9] = "Ninety";
        
        if (num == 0) return str[0];
        String tmp;
        String ret = "";
        
        tmp = lessThanThousand(num%1000);
        if (tmp != str[0]) ret = tmp;
        if (num < 1000) return ret;
        
        tmp = lessThanThousand((num%1000000)/1000);
        if (tmp != str[0]) {
            if (ret == "") ret = tmp+" "+THOUSAND;
            else ret = tmp+" "+THOUSAND+" "+ret;
        } // Invariant: ret does not contain Zero
        if (num/1000000 == 0) return ret;
        
        tmp = lessThanThousand((num%1000000000)/1000000);
        if (tmp != str[0]) {
            if (ret == "") ret = tmp+" "+MILLION;
            else ret = tmp+" "+MILLION+" "+ret;
        } // Invariant: ret does not contain Zero
        if (num/1000000000 == 0) return ret;
        
        tmp = lessThanThousand(num/1000000000);
        if (tmp != str[0]) {
            if (ret == "") ret = tmp+" "+BILLION;
            else ret = tmp+" "+BILLION+" "+ret;
        } // Invariant: ret does not contain Zero
        return ret;
    }
    
    String lessThanHundred(int num) {
        assert (num < 100);
        if (num < 20) return str[num];
        else {
            int d1 = num/10;
            int d2 = num%10;
            if (d2 == 0) return doubleDigit[d1]; // e.g. 50
            else return doubleDigit[d1]+" "+str[d2]; // e.g. 55
        }
    }
    
    String lessThanThousand(int num) {
        assert (num < 1000);
        if (num < 100) return lessThanHundred(num);
        int d1 = num/100;
        int d2 = num%100;
        if (d2 == 0) return str[d1]+" "+HUNDRED;
        else return str[d1]+" "+HUNDRED+" "+lessThanHundred(d2);
    }
}

// Your runtime beats 72.91 % of java submissions.
