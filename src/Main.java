import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Weapon> weapons = StandardWeapons.getWeapons();

        for (int weapon = 0; weapon < weapons.size(); weapon++) {
            System.out.println((weapon + 1) +
                    ". " + weapons.get(weapon));
            weapons.get(weapon).attack();
            System.out.println();
        }
    }
}

enum WeaponType {

    FutureLaser("9 Volt Blaster", 5, 100, "Death Ray", 1, 10000),
    FutureRocket("Snot Rocket", 1, 500, "Stupid Awesome Rocket", 250, 50000),
    FutureSonicScrewdriver("Lame Screw Driver", 20, 1, "Awesome Screw Driver", 10, 50),
    FutureMindMeld("Mind Melder 100", 4, 3, "Mind Melder 2000", 800, 10),
    MedievalFist("Sucker Puncher", 30, 10, "Super Fist of Fury", 100, 12),
    MedievalGun("DC9", 10, 10, "Van Helsing's Gun", 500, 5),
    MedievalBooger("Goo Ball", 1, 1, "Super Green Goo Ball with Nose Hair", 2, 2),
    MedievalStinkyFoot("Cheese Foot", 20, 5, "Gangrene Foot", 2, 100);

    final String LOW_POWER_NAME;
    final int LOW_POWER_APM;
    final int LOW_POWER_DAMAGE;

    final String HIGH_POWER_NAME;
    final int HIGH_POWER_APM;
    final int HIGH_POWER_DAMAGE;

    WeaponType(String lowPowerName, int lowPowerAttacksPerMinute, int lowPowerDamage,
               String highPowerName, int highPowerAttacksPerMinute, int highPowerDamage) {
        this.LOW_POWER_NAME = lowPowerName;
        this.LOW_POWER_APM = lowPowerAttacksPerMinute;
        this.LOW_POWER_DAMAGE = lowPowerDamage;
        this.HIGH_POWER_NAME = highPowerName;
        this.HIGH_POWER_APM = highPowerAttacksPerMinute;
        this.HIGH_POWER_DAMAGE = highPowerDamage;
    }
}

enum WeaponPower {
    LOW_POWER,
    HIGH_POWER
}

class WeaponsFactory {
    HashMap<WeaponType, Weapon> Weapons = new HashMap<>();

    Weapon getNormalWeaponDetails(WeaponType wt) {
        switch (wt) {
            case FutureLaser:
                return new WeaponFutureLaser();
            case FutureRocket:
                return new WeaponFutureRocket();
            case FutureMindMeld:
                return new WeapongFutureMindMeld();
            case FutureSonicScrewdriver:
                return new WeaponutureSonicScrewdriver();
            case MedievalGun:
                return new WeaponMedievalGun();
            case MedievalFist:
                return new WeaponMedievalFist();
            case MedievalBooger:
                return new WeaponMedievalBooger();
            case MedievalStinkyFoot:
                return new WeaponMedievalStinkyFoot();
            default:
                return null;
        }
    }

    Weapon ManufactureWeapon(WeaponType weaponType, WeaponPower weaponPower) {
        Weapon w = getNormalWeaponDetails(weaponType);
        if (weaponPower == WeaponPower.LOW_POWER) {
            w.setName(weaponType.LOW_POWER_NAME);
            w.setAttackPerMinute(weaponType.LOW_POWER_APM);
            w.setMaxDamagePoints(weaponType.LOW_POWER_DAMAGE);
            return w;

        } else {
            w.setName(weaponType.HIGH_POWER_NAME);
            w.setAttackPerMinute(weaponType.HIGH_POWER_APM);
            w.setMaxDamagePoints(weaponType.HIGH_POWER_DAMAGE);
            return w;
        }
    }
}

abstract class Weapon {

    private String _name;
    private int _attacksPerMinute;
    private int _maxDamagePoints;

    protected Weapon() {

    }

    protected Weapon(String name, int attacksPerMinute, int maxDamagePoints) {
        _name = name;
        _attacksPerMinute = attacksPerMinute;
        _maxDamagePoints = maxDamagePoints;
    }

    public int getAttacksPerMinute() {
        return _attacksPerMinute;
    }

    public int getMaxDamagePoints() {
        return _maxDamagePoints;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setAttackPerMinute(int apm) {
        _attacksPerMinute = apm;
    }

    public void setMaxDamagePoints(int mdp) {
        _maxDamagePoints = mdp;
    }

    public abstract void attack();

    @Override
    public String toString() {
        return
                this.getClass().getSimpleName() +
                        " -- " + getName() +
                        " -- Attacks Per Minute: " + getAttacksPerMinute() +
                        " -- MaxDamagePoints: " + getMaxDamagePoints();
    }
}

class WeaponFutureLaser extends Weapon {
    public WeaponFutureLaser() {
    }

    public WeaponFutureLaser(String name, int attacksPerMinute, int maxDamagePoints) {
        super(name, attacksPerMinute, maxDamagePoints);
    }

    @Override
    public void attack() {
        System.out.println("Zap");
    }
}

class WeaponFutureRocket extends Weapon {
    public WeaponFutureRocket() {
    }

    public WeaponFutureRocket(String name, int attacksPerMinute, int maxDamagePoints) {
        super(name, attacksPerMinute, maxDamagePoints);
    }

    @Override
    public void attack() {
        System.out.println("Rumble rumble BOOM!");
    }
}

class WeaponutureSonicScrewdriver extends Weapon {
    public WeaponutureSonicScrewdriver() {
    }

    public WeaponutureSonicScrewdriver(String name, int attacksPerMinute, int maxDamagePoints) {
        super(name, attacksPerMinute, maxDamagePoints);
    }

    @Override
    public void attack() {
        System.out.println("Cha ching ching ching!");
    }
}

class WeapongFutureMindMeld extends Weapon {
    public WeapongFutureMindMeld() {
    }

    public WeapongFutureMindMeld(String name, int attacksPerMinute, int maxDamagePoints) {
        super(name, attacksPerMinute, maxDamagePoints);
    }

    @Override
    public void attack() {
        System.out.println("Do do do do!");
    }
}

class WeaponMedievalFist extends Weapon {
    public WeaponMedievalFist() {
    }

    public WeaponMedievalFist(String name, int attacksPerMinute, int maxDamagePoints) {
        super(name, attacksPerMinute, maxDamagePoints);
    }

    @Override
    public void attack() {
        System.out.println("KA POW!");
    }
}

class WeaponMedievalGun extends Weapon {
    public WeaponMedievalGun() {
    }

    public WeaponMedievalGun(String name, int attacksPerMinute, int maxDamagePoints) {
        super(name, attacksPerMinute, maxDamagePoints);
    }

    @Override
    public void attack() {
        System.out.println("POWWWWW!");
    }
}

class WeaponMedievalBooger extends Weapon {
    public WeaponMedievalBooger() {
    }

    public WeaponMedievalBooger(String name, int attacksPerMinute, int maxDamagePoints) {
        super(name, attacksPerMinute, maxDamagePoints);
    }

    @Override
    public void attack() {
        System.out.println("TUCHHH!");
    }
}

class WeaponMedievalStinkyFoot extends Weapon {
    public WeaponMedievalStinkyFoot() {
    }

    public WeaponMedievalStinkyFoot(String name, int attacksPerMinute, int maxDamagePoints) {
        super(name, attacksPerMinute, maxDamagePoints);
    }

    @Override
    public void attack() {
        System.out.println("HAZAAAAA!");
    }
}

final class StandardWeapons {
    private static final Object syncLock = new Object();
    private static volatile List<Weapon> _swl;

    private StandardWeapons() {
    }

    public static List<Weapon> getWeapons() {
        if (_swl == null) {
            synchronized (syncLock) {
                if (_swl == null) {
                    List<Weapon> temp = new ArrayList<>();
                    WeaponsFactory weaponsFactory = new WeaponsFactory();
                    for (WeaponType weaponType : WeaponType.values()) {
                        for (WeaponPower powerSetting : WeaponPower.values()) {
                            temp.add(weaponsFactory.ManufactureWeapon(weaponType, powerSetting));
                        }
                    }
                    _swl = temp;
                    _swl = Collections.unmodifiableList(_swl);
                }
            }
        }
        return _swl;
    }
}