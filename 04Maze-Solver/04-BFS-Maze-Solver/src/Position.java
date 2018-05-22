/**
 * Created by ${laotizi} on 2018-05-22.
 */
public class Position {

    private int x;
    private int y;
    private Position prev;

    public Position(int x, int y,Position prev) {
        this.x = x;
        this.y = y;
        this.prev = prev;
    }

    public Position(int x,int y){
        this(x,y,null);
    }


    public Position getPrev() {
        return prev;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
