package main.Logic.ElementSystem;

public class Element {
    public enum DamageType{Physical,Magical,TRUE}
    public enum DamageElement{FIRE,EARTH,AIR,WATER}
    public enum type{DAMAGE,HEAL,BUFF}

    private double fireVS(DamageElement Element){
        if(Element.equals(DamageElement.AIR)){
            return 1;
        }else if(Element.equals(DamageElement.FIRE)){
            return 1;
        }else if(Element.equals(DamageElement.WATER)){
            return 0.5;
        }else if(Element.equals(DamageElement.EARTH)){
            return 2;
        }
        return 0;
    }
    private double waterVS(DamageElement Element){
        if(Element.equals(DamageElement.AIR)){
            return 0.5;
        }else if(Element.equals(DamageElement.FIRE)){
            return 2;
        }else if(Element.equals(DamageElement.WATER)){
            return 1;
        }else if(Element.equals(DamageElement.EARTH)){
            return 1;
        }
        return 0;
    }
    private double earthVS(DamageElement Element){
        if(Element.equals(DamageElement.AIR)){
            return 2;
        }else if(Element.equals(DamageElement.FIRE)){
            return 0.5;
        }else if(Element.equals(DamageElement.WATER)){
            return 1;
        }else if(Element.equals(DamageElement.EARTH)){
            return 1;
        }
        return 0;
    }
    private double airVS(DamageElement Element){
        if(Element.equals(DamageElement.AIR)){
            return 1;
        }else if(Element.equals(DamageElement.FIRE)){
            return 1;
        }else if(Element.equals(DamageElement.WATER)){
            return 2;
        }else if(Element.equals(DamageElement.EARTH)){
            return 0.5;
        }
        return 0;
    }

    public double ElementComparation(DamageElement AttackElement,DamageElement DefenseElement){
        if(AttackElement.equals(DefenseElement.EARTH)){
            return earthVS(DefenseElement);
        }else if(AttackElement.equals(DefenseElement.FIRE)){
            return fireVS(DefenseElement);
        }else if(AttackElement.equals(DefenseElement.AIR)){
            return airVS(DefenseElement);
        }else if(AttackElement.equals(DefenseElement.WATER)){
            return waterVS(DefenseElement);
        }
        return 0;
    }
}
