import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovObj extends JFrame {
    private static int width = 30;
    private static int hight = 20;
    private JLabel countLabel;
    private JButton Obj;

    public MovObj() {
        super("Передвижение объекта");
        super.setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        /*Insets insets = getInsets();

        countLabel = new JLabel("Передвижение объекта");
        add(countLabel);
        Obj = new JButton("Объект");
        add(Obj);

        Dimension size = countLabel.getPreferredSize();
        countLabel.setBounds(15 + insets.left, 5 + insets.top, size.width, size.height);

        size = Obj.getPreferredSize();
        Obj.setBounds(15 + insets.left, 35 + insets.top, size.width, size.height);

        Obj.addActionListener(e -> {
            if(countLabel.getText().equals("Передвижение объекта")) {
                countLabel.setText("Передвижение_объекта");
            } else {
                countLabel.setText("Передвижение объекта");
            }
            countLabel.setBounds(countLabel.getX()+5, countLabel.getY(), countLabel.getWidth(), countLabel.getHeight());
        });
        */
    }

    public void show(Men m) {
        if(m != null) {
            JLabel labelName = new JLabel(m.getName());
            add(labelName);
            Dimension size = labelName.getPreferredSize();
            labelName.setText(labelName.getText()
                    + " x:" + ((size.width + 15) * m.countLevels() / 2)
                    + " y:" + 0);
            size = labelName.getPreferredSize();
            labelName.setBounds((size.width + 15) * m.countLevels() / 2, 0, size.width, size.height);
            if(m.hasChild()) {
                int cnt = 0;
                for (Men ch : m.getChildren().getMembers()) {
                    JLabel labelCh = new JLabel(ch.getName());
                    add(labelCh);
                    Dimension sizeCh = labelCh.getPreferredSize();
                    labelCh.setText(labelCh.getText()
                            + " x:" + ((sizeCh.width + 15) * ch.getLevel()  / m.getChildren().getMembers().size() * cnt++)
                            + " y:" + ((m.getLevel() - ch.getLevel()) * 25));
                    sizeCh = labelCh.getPreferredSize();
                    labelCh.setBounds((sizeCh.width + 15) * ch.getLevel()  / m.getChildren().getMembers().size() * cnt++,
                            (m.getLevel() - ch.getLevel()) * 25, sizeCh.width, sizeCh.height);
                }
            }
        }
    }

    public static void show_rec(Men m, int level) {}

    public static void drawTree(int level) {
        if (level == 0) {
            System.out.println("Пусто");
        } else {
            //int x = level % 2 == 0 ? level / 2 : level / 2 + 1;
            float x = level / 2;
            for (int i = 0; i < level; i++) {
                System.out.println("x:" + ((x-i)  * width) + "y:" + ((i+1) * hight));
            }
        }
    }

    public static void main(String[] args) {
        MovObj app = new MovObj();
        //app.pack(); //Эта команда подбирает оптимальный размер в зависимости от содержимого окна
        Men m = new Men("Батя");
        m.addChild("Сынко",true);
        m.addChild("Лапочка-дочка",true);
        Men doch = m.getChildren().getMembers().get(1);
        for(int i = 0; i < 10; i++) {
            doch.addChild("внучёчек_"+i,true);
            Men cnyk = doch.getChildren().getMembers().get(i);
            int k = (int) (Math.round(Math.random() * 100) % 3);
            for(int j = 0; j < k; j++) {
                cnyk.addChild("правнучёчек_"+j,true);

            }
        }
        m.fixLevels();
        app.show(m);

        /*System.out.println("lelvel of " + m.getName() + " is " + m.countLevels());
        for (Men ch : m.getChildren().getMembers()) {
            System.out.println("lelvel of " + ch.getName() + " is " + ch.countLevels());
            if(ch.hasChild()) {
                for (Men ch2 : ch.getChildren().getMembers()) {
                    System.out.println("lelvel of " + ch2.getName() + " is " + ch2.countLevels());
                    if(ch2.hasChild()) {
                        for (Men ch3 : ch2.getChildren().getMembers()) {
                            System.out.println("lelvel of " + ch3.getName() + " is " + ch3.countLevels());
                        }
                    }
                }
            }
        }*/
        app.setVisible(true);
    }
}