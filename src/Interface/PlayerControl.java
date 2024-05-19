package Interface;

import Physics.Coords;
import Physics.Player;

public class PlayerControl implements PlayerInterface {
    private Player player;

    public PlayerControl(Player player)
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

    public void SetAngle(int gunAngle)
    {
        player.SetAngle(gunAngle);
    }

    public void SetSpeed(int speed)
    {
        player.SetSpeed(speed);
    }

    public void Shoot()
    {
        player.Shoot();
    }

    public int GetReloadTime()
    {
        return player.GetReloadTime();
    }

    public boolean GetIsLoaded() {
        return player.GetIsLoaded();
    }
}
