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

    public void SetCoordsX(int x)
    {
        coords = new Coords(x, coords.y());
    }

    public void SetCoordsY(int y)
    {
        coords = new Coords(coords.x(), y);
    }
}
