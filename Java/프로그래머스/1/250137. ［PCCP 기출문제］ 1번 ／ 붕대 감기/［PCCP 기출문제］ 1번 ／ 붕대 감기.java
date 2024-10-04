class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attackIndex = 0;
        int life = health;
        int heal = 0;
        
        for(int i=0; i <= attacks[attacks.length-1][0]; i++){
            if(i != attacks[attackIndex][0]){
                life += bandage[1];
                heal++;
                if(heal == bandage[0]){
                    life += bandage[2];
                    heal = 0;
                }
                if(life > health){
                    life = health;
                }
            }else{
                heal = 0;
                life -= attacks[attackIndex][1];
                attackIndex++;
                if(life <= 0){
                    return -1;
                }
            }
            
        }
        return life;
    }
}