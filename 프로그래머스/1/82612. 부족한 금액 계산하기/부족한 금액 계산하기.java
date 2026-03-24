class Solution {
    public long solution(int price, int money, int count) {

        long total_price = 0;
        for (int i = 1; i <= count; i++) {
            total_price += price *i;
        }
        long answer = total_price-money;
        if (answer < 0) answer = 0;
        return answer;
    }
}