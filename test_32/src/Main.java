import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    private MyPanal mp = null;
    public static void main(String[] args) {
        new Main();
    }
    public Main() {
        mp = new MyPanal();
        this.add(mp);
        this.setSize(1080, 960);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanal extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(0, 0, 520, 520);
        g.drawRect(0, 0, 520, 520);
        //g.fillRect(0,0,520,550);
        System.out.println("看什么看！！！");
    }
}