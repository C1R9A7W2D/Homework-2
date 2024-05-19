package Interface;

import Physics.Coords;
import Physics.Player;

public class EnemyPlayer {
    private Player player;

    public EnemyPlayer(Player player)
    {
        this.player = player;
    }

    public Coords GetCoords()
    {
        return player.GetCoords();
    }

    public int getHp()
    {
        return player.getHp();
    }
}
