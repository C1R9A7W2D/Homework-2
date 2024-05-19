package Physics;

public class Player extends GameObject {
    private final int MAX_HP = 10;
    private final int RELOAD_TIME = 10;
    private int hp = MAX_HP;
    private int gunAngle = 0;
    private int speed = 0;
    private int reloadTimer = RELOAD_TIME;
    private boolean loaded = true;
    private boolean destroyed = false;

    public Player(Coords coords)
    {
        super(coords, 20);
    }

    public void Update()
    {
        CheckReloadTimer();
    }

    private void CheckReloadTimer()
    {
        if (!loaded) {
            if (reloadTimer <= 0) {
                reloadTimer = RELOAD_TIME;
                loaded = true;
            }
            else
                reloadTimer--;
        }
    }

    public int getHp()
    {
        return hp;
    }

    public void SetAngle(int gunAngle)
    {
        this.gunAngle = gunAngle;
    }

    public void SetSpeed(int speed)
    {
        this.speed = speed;
    }

    public void Shoot()
    {
        Coords coords = this.GetCoords();
        Projectile projectile = new Projectile(coords);
        GameWorld.getInstance().AddProjectile(projectile);
        loaded = false;
    }

    public int GetReloadTime()
    {
        return reloadTimer;
    }

    public boolean GetIsLoaded() {
        return loaded;
    }

    public void UpdateHp(int amount)
    {
        hp = Math.min(MAX_HP, hp + amount);
        if (hp <= 0)
            Destroy();
    }

    public void Destroy()
    {
        destroyed = true;
    }
}