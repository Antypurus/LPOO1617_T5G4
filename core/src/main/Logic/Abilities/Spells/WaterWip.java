package Logic.Abilities.Spells;

import java.util.ArrayList;

import Logic.Abilities.BaseAbilityFunctions;
import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class WaterWip extends BaseAbilityFunctions implements Ability {

        private double Damage = 5;
        private double ManaCost = 10;
        private Statistic scalingStat = null;
        private int AOE = 0;
        private double Chance = 85;
        private int range  = 15;
        private main.Logic.ElementSystem.Element.DamageElement dmgElem = Element.DamageElement.WATER;
        private Unit owner = null;
        private String name = "WaterWip";
        private Element elem = new Element();

    public WaterWip(Unit owner) {
        this.owner = owner;
        if(this.owner!=null) {
            this.owner.addAbility(this);
            this.scalingStat = this.owner.getINTELIGENCE();
        }
    }

    @Override
    public void AffectTarget(Unit target) {
        if(this.canHitTarget(target)) {
            this.owner.reduceMana(this.ManaCost);
            double dmg = this.getDamageToTarget(target);
            target.takeDamage(dmg);
        }
    }

    @Override
    public boolean canHitTarget(Unit target) {
        return this.baseCanHitTarget(this,target);
    }

    @Override
    public double getBaseDamage() {
        return this.Damage;
    }

    @Override
    public int getRange() {
        return this.range;
    }

    @Override
    public boolean isElemental() {
        return true;
    }

    @Override
    public Element.type getType() {
        return Element.type.DAMAGE;
    }

    @Override
    public Element.DamageElement getDamageElement() {
        return this.dmgElem;
    }

    @Override
    public Element.DamageType getDamageType() {
        return Element.DamageType.Magical;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Element.type> getTraits() {
        return null;
    }

    @Override
    public Unit getOwner() {
        return this.owner;
    }

    @Override
    public Statistic getScalingStat() {
        return this.scalingStat;
    }

    @Override
    public double getDamageToTarget(Unit target) {
        return 0;
    }

    @Override
    public double getHitChance() {
        return this.Chance;
    }

    @Override
    public int getAOE() {
        return 0;
    }

    @Override
    public double getManaCost() {
        return this.ManaCost;
    }

    @Override
    public boolean canHitCell(Cell cell) {
        return this.baseCanHitCell(this.owner,cell,this.range);
    }
}
