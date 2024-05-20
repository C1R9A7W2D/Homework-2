package Physics;

import Interface.Bonus;
import Interface.EnemyPlayer;
import Interface.PlayerControl;
import Interface.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

public class GameWorld {
    private final Coords WORLD_SIZE = new Coords(2048, 1536);
    private final int PLAYERS_COUNT = 4;
    private final int AMOUNT_OF_TURNS = 2000;
    private static GameWorld instance;
    private int currentTurn;
    private List<Bonus> bonuses = new ArrayList<>();
    private Player[] players = new Player[PLAYERS_COUNT];
    private List<Projectile> projectiles = new ArrayList<>();

    private GameWorld()
    {
        currentTurn = 0;
    }

    public static GameWorld getInstance() {
        return instance;
    }

    public Coords GetWorldSize()
    {
        return WORLD_SIZE;
    }

    public int getCurrentTurn()
    {
        return currentTurn;
    }

    public List<Bonus> GetBonuses() {
        return bonuses;
    }

    public EnemyPlayer[] GetPlayers()
    {
        EnemyPlayer[] res = new EnemyPlayer[PLAYERS_COUNT];

        for (int i = 0; i < PLAYERS_COUNT; i++)
        {
            res[i] = new EnemyPlayer(players[i]);
        }

        return res;
    }

    public PlayerControl GetControlledPlayer(int index)
    {
        return new PlayerControl(players[index]);
    }

    public List<Projectile> GetProjectiles()
    {
        return projectiles;
    }

    public void AddProjectile(Projectile projectile)
    {
        projectiles.add(projectile);
    }

    public int GetCurrentTurn()
    {
        return currentTurn;
    }

    public int GetAmountOfTurns()
    {
        return AMOUNT_OF_TURNS;
    }

    public void Update()
    {
        CheckCollisions();
    }

    private void CheckCollisions() {
        for (int i = 0; i < PLAYERS_COUNT; i++)
        {
            var p = players[i];
            var pCoords = p.GetCoords();
            bonuses.forEach(b ->
                    CheckPlayerAndBonusCollision(b, pCoords, p)
            );
            projectiles.forEach(pr ->
                    CheckPlayerAndProjectileCollision(pr, pCoords, p)
            );

            final int pRad = p.GetRadius();
            if (pCoords.x() + pRad >= WORLD_SIZE.x())
                p.SetCoordsX(WORLD_SIZE.x() - pRad);
            else if (pCoords.x() - pRad <= 0)
                p.SetCoordsX(pRad);

            if (pCoords.y() + p.GetRadius() >= WORLD_SIZE.y())
                p.SetCoordsY(WORLD_SIZE.y() - pRad);
            else if (pCoords.y() - pRad <= 0)
                p.SetCoordsY(pRad);
        }
    }

    private void CheckPlayerAndBonusCollision(Bonus b, Coords pCoords, Player p) {
        var bCoords = b.GetCoords();
        if (pCoords.GetDistance(bCoords) < p.GetRadius() + b.GetRadius()) {
            p.UpdateHp(b.HP_GAIN);
            bonuses.remove(b);
        }
    }

    private void CheckPlayerAndProjectileCollision(Projectile pr, Coords pCoords, Player p) {
        var prCoords = pr.GetCoords();
        if (pCoords.GetDistance(prCoords) < p.GetRadius() + pr.GetRadius()) {
            p.UpdateHp(-1);
            projectiles.remove(pr);
        }
    }
}
