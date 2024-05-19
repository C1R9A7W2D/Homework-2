package Physics;

public class GameObject {
    private Coords coords;
    private final int RADIUS;

    public GameObject(Coords coords, int radius)
    {
        this.coords = coords;
        this.RADIUS = radius;
    }

    public Coords GetCoords()
    {
        return coords;
    }

    public int GetRadius()
    {
        return RADIUS;
    }
}
