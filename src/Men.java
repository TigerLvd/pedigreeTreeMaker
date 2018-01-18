import java.util.ArrayList;
import java.util.Date;

public class Men {
    private Integer id;
    private String name;
    private Integer level;
    private Men father;
    private Men mother;
    private Date birsday;
    private Date deadday;
    private String shortInfo;
    private ArrayList<Men> children;
    private Boolean sex; // пол: 1 - men, 0 - women
    private Integer width; //ширина потомков

    public Men (String name) {
        id = null;
        this.name = name;
        level = null;
        father = null;
        mother = null;
        birsday = null;
        deadday = null;
        shortInfo = null;
        children = null;
        sex = null;
        width = null;
    }

    /*public Men (Integer id, String name, Integer level, Men father, Men mother, Date birsday, Date deadday,
                String shortInfo, Generation children, Boolean sex, Integer width) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.father = father;
        this.mother = mother;
        this.birsday = birsday;
        this.deadday = deadday;
        this.shortInfo = shortInfo;
        this.children = children;
        this.sex = sex;
        this.width = width;
    }*/

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public void setFather(Men father) {
        this.father = father ;
    }

    public Men getFather() {
        return father;
    }

    public void setMother(Men mother) {
        this.mother = mother;
    }

    public Men getMother() {
        return mother;
    }

    public void setBirsday(Date birsday) {
        this.birsday = birsday;
    }

    public Date getBirsday() {
        return birsday;
    }

    public void setDeadday(Date deadday) {
        this.deadday = deadday;
    }

    public Date getDeadday() {
        return deadday;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setChildren(ArrayList<Men> children) {
        this.children = children;
    }

    public ArrayList<Men> getChildren() {
        return children;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getSex() {
        return sex;
    }

    public void addChild(Men m, boolean father) {
        if(father) {
            m.setFather(m);
        } else {
            m.setMother(m);
        }
        if(this.getChildren() == null) {
            ArrayList<Men> newChildren = new ArrayList<Men>();
            newChildren.add(m);
            this.setChildren(newChildren);
        } else {
            this.getChildren().add(m);
        }
    }

    public void addChild (String name, Boolean father) {
        Men child = new Men(name);
        this.addChild(child, father);
    }

    public Boolean hasChild() {
        if(children == null || children.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public int countLevels () {
        int res;
        if(this.name == null || this.name.equals("")) {
            res = 0;
        } else if(this.hasChild()) {
            res = 1;
        } else {
            int max = 0;
            for (Men ch : this.getChildren()) {
                if(max < ch.countLevels()) {
                    max = ch.countLevels();
                }
            }
            //this.setLevel(max + 1);
            res =  max + 1;
        }
        return res;
    }

    public void fixLevels() {
        fixLevels_rec(this, this.countLevels());
    }

    private void fixLevels_rec(Men m, int lev) {
        m.setLevel(lev);
        if(m.hasChild()) {
            for (Men ch : m.getChildren()) {
                fixLevels_rec(ch, lev-1);
            }
        }
    }

    private void setWidths() {

    }
}