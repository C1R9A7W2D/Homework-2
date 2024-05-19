package Physics;

public record Coords(int x, int y) {
    public double GetDistance(Coords other)
    {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
