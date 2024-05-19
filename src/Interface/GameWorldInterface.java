package Interface;

import Physics.Coords;
import Physics.GameWorld;
import Physics.Projectile;

import java.util.List;

public interface GameWorldInterface {
    static GameWorld getInstance(){
        return GameWorld.getInstance();
    }
    Coords GetWorldSize();
    int getCurrentTurn();
    List<Bonus> GetBonuses();
    EnemyPlayer[] GetPlayers();
    PlayerControl GetControlledPlayer(int index);
    List<Projectile> GetProjectiles();
    int GetCurrentTurn();
    int GetAmountOfTurns();
}
