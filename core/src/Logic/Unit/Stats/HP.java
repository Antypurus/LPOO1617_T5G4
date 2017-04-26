package Logic.Unit.Stats;

import Logic.Unit.Statistic;

public class HP extends Statistic{

    private Vitality vit;

    public HP(Vitality vit){
        this.Name = "HP";
        this.vit = vit;
    }

}
