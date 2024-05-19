package Interface;

import Physics.Coords;
import Physics.GameObject;

public class Bonus extends GameObject {
    public final int HP_GAIN = 5;
    private record LifeSpan(int creationTime, int depletionTime){}
    private final LifeSpan lifeSpan;

    public Bonus(Coords coords, int creationTime, int depletionTime)
    {
        super(coords, 5);
        lifeSpan = new LifeSpan(creationTime, depletionTime);
    }

    public int GetLifeSpan()
    {
        return lifeSpan.depletionTime - GameWorldInterface.getInstance().getCurrentTurn();
    }
}
