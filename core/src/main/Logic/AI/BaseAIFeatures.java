package Logic.AI;

import main.Logic.ElementSystem.Element;
import main.Logic.Unit.Unit;

public abstract class BaseAIFeatures {

    public int numberOfOffensivAbilitiesAvailableToUse(Unit owner){
        int ret = 0;
        for(int i=0;i<owner.getAbilities().size();++i){
            if(owner.getAbilities().get(i).getType().equals(Element.type.DAMAGE)){
                if(owner.getAbilities().get(i).canUse()){
                    ret++;
                }
            }
        }
        return ret;
    }

    public int numberOfHealingAbilitiesAvailableToUse(Unit owner){
        int ret = 0;
        for(int i=0;i<owner.getAbilities().size();++i){
            if(owner.getAbilities().get(i).getType().equals(Element.type.HEAL)){
                if(owner.getAbilities().get(i).canUse()){
                    ret++;
                }
            }
        }
        return ret;
    }

}
