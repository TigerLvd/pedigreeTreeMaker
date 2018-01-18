import java.util.ArrayList;

public class Generation {
    private ArrayList<Men> members;
    private Men father;
    private Men mather;
    private int x;
    private int y;
    private int windth;
    private int hight;

    public Generation () {
        this.members = new ArrayList<Men>();
    }

    public void setFather(Men father) {
        this.father = father;
    }

    public Men getFather() {
        return father;
    }

    public void setMather(Men mather) {
        this.mather = mather;
    }

    public Men getMather() {
        return mather;
    }

    public void setMembers(ArrayList<Men> members) {
        this.members = members;
    }

    public ArrayList<Men> getMembers() {
        return members;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public int getHight() {
        return hight;
    }

    public void setWindth(int windth) {
        this.windth = windth;
    }

    public int getWindth() {
        return windth;
    }

    public void addMember(Men m) {
        members.add(m);
    }
}
