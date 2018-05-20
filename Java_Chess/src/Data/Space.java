package Data;

public class Space {

    private int x = 0;
    private int y = 0;

    public Space(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Space space = (Space) o;

        if (x != space.x) return false;
        return y == space.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
