package Plants;

public class Plants {
    //植物的生命值
    private int health;

    //种植植物所需要花费的阳光数
    private int sunCost;

    //植物的伤害值
    private int damage;

    //植物的攻击速度
    private int attackSpeed;

    private int cdTime;

    public Plants() {
    }

    /*
    下方代码均为set和get方法
     */
    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSunCost() {
        return sunCost;
    }

    public void setSunCost(int sunCost) {
        this.sunCost = sunCost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCdTime() {
        return cdTime;
    }

    public void setCdTime(int cdTime) {
        this.cdTime = cdTime;
    }
}