
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
class Calc extends JFrame implements ActionListener {
    JTextField opn1=new JTextField(5);
    JTextField opr=new JTextField(2);
    JTextField opn2=new JTextField(5);
    JTextField ans = new JTextField(6);
    JButton calc = new JButton("=") ;
    int w=400, h= 100 ; // Calc視窗大小
    public Calc() {
        Container cp = this.getContentPane() ;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel() ;
        panel.setLayout(new FlowLayout());
        panel.add(opn1); panel.add(opr) ;   panel.add(opn2) ;
        panel.add(calc); panel.add(ans) ;
        cp.add(panel, BorderLayout.CENTER) ;
        calc.addActionListener(this);

        setBounds(100,100,w,h); // 視窗左上角座標(100,100) 寬、高:(w,h)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(
                (screenSize.width - this.getWidth()) / 2,
                (screenSize.height - this.getHeight()) / 2);
        System.out.println(screenSize.width);
        System.out.println( screenSize.height);
        // 此處加入程式碼，取得螢幕的大小(width, height)，將Calc畫面置中

        setVisible(true) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calc) {
            // 如果是按鈕[=]被按下，執行以下動作
            Double opn1D,opn2D;
                opn1D = Double.parseDouble(opn1.getText());
                opn2D = Double.parseDouble(opn2.getText());
            switch (opr.getText()){
                case "+":
                    ans.setText(String.valueOf(opn1D+opn2D));
                    break;
                case "-":
                    ans.setText(String.valueOf(opn1D-opn2D));
                    break;
                case "*":
                    ans.setText(String.valueOf(opn1D*opn2D));
                    break;
                case "/":
                    ans.setText(String.valueOf(opn1D/opn2D));
                    break;
                default:
                    ans.setText("error");
            }

        }
    }
}
public class HWK2_405410068_陳睿瑜_01{
    public static void main(String[] args) {
        new Calc() ;
    }
}

