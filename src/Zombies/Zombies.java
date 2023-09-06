package Zombies;

public class Zombies {
    //僵尸的生命值
    private int health;

    //僵尸的伤害
    private int damage;

    //僵尸的行走速度
    private int speed;

    //僵尸的攻击速度
    private int attackSpeed;

    public Zombies() {
    }

    /*
    下方代码均为set和get方法
     */

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
