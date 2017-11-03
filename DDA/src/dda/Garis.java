package dda;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author WINDOWS
 */
public class Garis implements ActionListener {
    JFrame f= new JFrame("Garis DDA");
    Kanvas k=new Kanvas();
    JLabel lx1=new JLabel("x1");
    JLabel ly1=new JLabel("y1");
    JLabel lx2=new JLabel("x2");
    JLabel ly2=new JLabel("y2");
    JTextField tx1=new JTextField("0");
    JTextField ty1=new JTextField("0");
    JTextField tx2=new JTextField("0");
    JTextField ty2=new JTextField("0");
    JButton dda=new JButton("DDA");
 
    int x1,x2,y1,y2,tmp,dy=0,dx=0,p,r,x,y,tmp1,pusatx,pusaty; 
    float a,b,xinc,yinc,dy1,dx1,step;
    
     public Garis(){
       f.setLocation(300,100); //untuk mengubah ukuran window
       f.setSize(500,455); //untuk mengubah ukuran window
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setLayout(null);
       f.add(k);
       k.setBounds(0,0,500,360);
       pusatx=k.getWidth()-(k.getWidth()/2); //garis vertikal
       pusaty=k.getHeight()-(k.getHeight()/2); //garis horizontal
       //Label
       f.add(lx1);   lx1.setBounds(30,365,30,20);
       f.add(ly1);   ly1.setBounds(80,365,30,20);
       f.add(lx2);   lx2.setBounds(130,365,30,20);
       f.add(ly2);   ly2.setBounds(180,365,30,20);
       //Textfield
       f.add(tx1);   tx1.setBounds(20,390,40,20);
       f.add(ty1);   ty1.setBounds(70,390,40,20);
       f.add(tx2);   tx2.setBounds(120,390,40,20);
       f.add(ty2);   ty2.setBounds(170,390,40,20);
       //Button
       f.add(dda);   dda.setBounds(220,370,150,40);
       dda.addActionListener(this);
       tx1.setHorizontalAlignment(tx1.CENTER);
       ty1.setHorizontalAlignment(ty1.CENTER);
       tx2.setHorizontalAlignment(tx2.CENTER);
       ty2.setHorizontalAlignment(ty2.CENTER);
  
       f.show();
    }
    
    public void actionPerformed(ActionEvent e) {
        Object objek=e.getSource();
        if(objek==dda){ 
            k.repaint();
        }
    }

    private class Kanvas extends Canvas{

        public Kanvas() {
            setBackground(Color.BLACK);
        }
        public void paint(Graphics g){
           g.setColor(Color.WHITE);
          g.drawLine(0,pusaty,k.getWidth(),pusaty); //membuat garis horizontal
          g.drawLine(pusatx,0,pusatx,k.getWidth()); //membuat garis vertical  
           Garis(g);
        }

        private void Garis(Graphics g) {
            x1=pusatx+Integer.parseInt(tx1.getText());
            x2=pusatx+Integer.parseInt(tx2.getText());
            y1=pusaty-Integer.parseInt(ty1.getText());
            y2=pusaty-Integer.parseInt(ty2.getText());

//       if(x1>x2)
//       {
//           tmp=x1;
//           x1=x2;
//           x2=tmp;
//           tmp=y1;
//           y1=y2;
//           y2=tmp;
//       }
//       
//        a=(float)(x1);
//        b=(float)(y1);
//        dx=(x2-x1);
//        dy=(y2-y1);
//        if(dx>dy)
//            step=dx;
//        else
//            step=dy;
//            xinc=dx/step;
//            yinc=dy/step;   
//       
//        do
//        { 
//
//             x=Math.round(a);
//             y=Math.round(b);
//
//             //g.fillRect(x, y, 1, 1);
//             g.drawRect(x, y, 1, 1);
//
//             a=a+xinc;
//             b=b+yinc;
//        }
//        while(x!=x2&&y!=y2);

           int dx = x2-x1;
        int dy = y2-y1;
        int steps,k; 

        float x=x1;
        float y=y1;
        float x_inc,y_inc;
        

//        super.paint(g);
//        this.setBackground(Color.BLACK);
//        g.setColor(Color.RED);

        if(Math.abs(dx)>Math.abs(dy)) steps = Math.abs(dx);
        else steps = Math.abs(dy);

        x_inc = dx/(float)steps;
        y_inc = dy/(float)steps;

        g.drawRect(Math.round(x), Math.round(y), 1, 1);
        for(k=0;k<steps;k++) {
            x+=x_inc;
            y+=y_inc;
            g.drawRect(Math.round(x), Math.round(y), 1, 1);
        }


         }
    }
    
}
