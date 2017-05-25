package Logic.Abilities.Spells;

import java.util.ArrayList;

import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class WaterWip implements Ability

        private double Damage = 5;
        private double ManaCost = 0;
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
            this.ManaCost = this.owner.getMANA().maxValue;
        }
    }

    @Override
    public void AffectTarget(Unit target) {
        if(this.canHitTarget(target)) {
            this.getManaCost();
            this.owner.reduceMana(this.ManaCost);
            double dmg = this.getDamageToTarget(target);
        }
    }

    @Override
    public boolean canHitTarget(Unit target) {
        return false;
    }

    @Override
    public double getBaseDamage() {
        return 0;
    }

    @Override
    public int getRange() {
        return 0;
    }

    @Override
    public boolean isElemental() {
        return false;
    }

    @Override
    public Element.type getType() {
        return null;
    }

    @Override
    public Element.DamageElement getDamageElement() {
        return null;
    }

    @Override
    public Element.DamageType getDamageType() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public ArrayList<Element.type> getTraits() {
        return null;
    }

    @Override
    public Unit getOwner() {
        return null;
    }

    @Override
    public Statistic getScalingStat() {
        return null;
    }

    @Override
    public double getDamageToTarget(Unit target) {
        return 0;
    }

    @Override
    public double getHitChance() {
        return 0;
    }

    @Override
    public int getAOE() {
        return 0;
    }

    @Override
    public double getManaCost() {
        return 0;
    }

    @Override
    public boolean canHitCell(Cell cell) {
        return false;
    }
}
