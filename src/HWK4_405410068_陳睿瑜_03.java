import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class HWK4_405410068_陳睿瑜_03 extends JFrame implements ActionListener {
    int y1=50;
    int y2=80;
    int y3=110;
    JTextField IDText = new JTextField(20);
    JTextField nameText = new JTextField(20);
    JTextField priceText = new JTextField(20);
    JButton query = new JButton("Query");
    JButton add = new JButton("Add");
    JButton remove = new JButton("Remove");
    static Map<Integer, Product> map = new LinkedHashMap<Integer, Product>();
    static int[] id = {1001, 1002, 1004, 1006} ;
    static String[] name = {"Apple", "Banana", "Peach", "Water Melon"} ;
    static double[] price = {9.8, 4.5, 12.3, 8.5} ;
    public static void main(String argv[]) {
        for (int i=0;i<id.length;i++){
            map.put(id[i],new Product(id[i],name[i],price[i]));
        }
        new HWK4_405410068_陳睿瑜_03("JFrame 1_1");

    }
    public HWK4_405410068_陳睿瑜_03(String title) {

        this.setBounds(0,0,400,200);
        this.setTitle(title);
        this.setVisible(true);
        JPanel panel = new JPanel();
        // 添加面板
        this.add(panel);

        placeComponents(panel);

        // 设置界面可见
        this.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel title = new JLabel("Product Management");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        title.setFont(new Font("Times New Roman",Font.ITALIC,18));
        title.setBounds(100,10,200,30);
        panel.add(title);
        // 创建 JLabel
        JLabel IDL = new JLabel("item ID:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        IDL.setBounds(10,y1,80,25);
        panel.add(IDL);

        JLabel nameL = new JLabel("Name:");
        nameL.setBounds(10,y2,80,25);
        panel.add(nameL);

        JLabel priceL = new JLabel("Price:");
        priceL.setBounds(10,y3,80,25);
        panel.add(priceL);
        /*
         * 创建文本域用于用户输入
         */

        IDText.setBounds(100,y1,165,25);
        panel.add(IDText);


        nameText.setBounds(100,y2,165,25);
        panel.add(nameText);


        priceText.setBounds(100,y3,165,25);
        panel.add(priceText);
        query.setBounds(260, y1, 80, 25);
        panel.add(query);
        add.setBounds(260, y2, 80, 25);
        panel.add(add);
        remove.setBounds(260, y3, 80, 25);
        panel.add(remove);
        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                if(IDText.getText()!=null){
                    Product p2=map.get(Integer.valueOf(IDText.getText()));
                    if(p2!=null) {
                        nameText.setText(p2.name);
                        priceText.setText(String.valueOf(p2.price));
                    }
                }
            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 进行逻辑处理即可
                if(IDText.getText()!=null) map.remove(Integer.valueOf(IDText.getText()));
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(IDText.getText()!=null&&nameText.getText()!=null&&priceText.getText()!=null){
                    Product p1 = new Product(Integer.valueOf(IDText.getText()),nameText.getText(),Double.valueOf(priceText.getText()));
                    map.put(Integer.valueOf(IDText.getText()),p1);
                }

            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==query)IDText.setText("dfds");

    }
}
