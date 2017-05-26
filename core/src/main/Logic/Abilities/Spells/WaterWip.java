package Logic.Abilities.Spells;

import java.util.ArrayList;

import Logic.Abilities.BaseAbilityFunctions;
import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class WaterWip extends BaseAbilityFunctions implements Ability {

        private double WaterWipBaseDamage = 5;
        private double ManaCost = 10;
        private Statistic WaterWipScalingStat = null;
        private double WaterWipHitChance = 85;
        private int WaterWipRange = 15;
        private main.Logic.ElementSystem.Element.DamageElement WaterWipDamageElement = Element.DamageElement.WATER;
        private Unit WaterWipOwner = null;
        private String WaterWipName = "WaterWip";
        private Element elem = new Element();

    public WaterWip(Unit WaterWipOwner) {
        this.WaterWipOwner = WaterWipOwner;
        if(this.WaterWipOwner !=null) {
            this.WaterWipOwner.addAbility(this);
            this.WaterWipScalingStat = this.WaterWipOwner.getINTELIGENCE();
        }
    }

    @Override
    public void AffectTarget(Unit target) {
        if(this.canHitTarget(target)) {
            this.WaterWipOwner.reduceMana(this.ManaCost);
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
        return this.WaterWipBaseDamage;
    }

    @Override
    public int getRange() {
        return this.WaterWipRange;
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
        return this.WaterWipDamageElement;
    }

    @Override
    public Element.DamageType getDamageType() {
        return Element.DamageType.Magical;
    }

    @Override
    public String getName() {
        return this.WaterWipName;
    }

    @Override
    public ArrayList<Element.type> getTraits() {
        return null;
    }

    @Override
    public Unit getOwner() {
        return this.WaterWipOwner;
    }

    @Override
    public Statistic getScalingStat() {
        return this.WaterWipScalingStat;
    }

    @Override
    public double getDamageToTarget(Unit target) {
        double dmg = this.WaterWipBaseDamage;
        dmg*=this.WaterWipScalingStat.EffectiveValue;
        if(target.getAfinity()!=null){
            dmg*=this.elem.ElementComparation(this.WaterWipDamageElement,target.getAfinity());
        }
        double dodge = target.generateDodgeVal();
        if(dodge>this.WaterWipHitChance){
            dmg = 0;
        }else if(dodge == 1){
            dmg*=2;
        }
        dmg-=target.getFireRes();
        if(dmg<0){
            dmg=0;
        }
        return dmg;
    }

    @Override
    public double getHitChance() {
        return this.WaterWipHitChance;
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
        return this.baseCanHitCell(this.WaterWipOwner,cell,this.WaterWipRange);
    }
}
