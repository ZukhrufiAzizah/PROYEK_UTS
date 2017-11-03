package bresenham;

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
public class Garis implements ActionListener{
   JFrame f= new JFrame("Garis Bresenham");
   Kanvas k=new Kanvas();
   JLabel lx1=new JLabel("x1");
   JLabel ly1=new JLabel("y1");
   JLabel lx2=new JLabel("x2");
   JLabel ly2=new JLabel("y2");
   JTextField tx1=new JTextField("0");
   JTextField ty1=new JTextField("0");
   JTextField tx2=new JTextField("0");
   JTextField ty2=new JTextField("0");
   JButton bres=new JButton("BRESENHAM");
   
   int x1,x2,y1,y2,p,pusatx,pusaty,tmp,dx,dy; 
   
   public Garis(){
      f.setLocation(300,100);
      f.setSize(500,455);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLayout(null);
      f.add(k);
      k.setBounds(0,0,500,360);
      pusatx=k.getWidth()-(k.getWidth()/2);
      pusaty=k.getHeight()-(k.getHeight()/2);
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
      f.add(bres);  bres.setBounds(220,370,150,40);
      bres.addActionListener(this);
      tx1.setHorizontalAlignment(tx1.CENTER);
      ty1.setHorizontalAlignment(ty1.CENTER);
      tx2.setHorizontalAlignment(tx2.CENTER);
      ty2.setHorizontalAlignment(ty2.CENTER);
  
      f.show();
   }
   
    public void actionPerformed(ActionEvent e) {
        Object objek=e.getSource();
        if(objek==bres){   
            k.repaint();   
      }
    }

    private class Kanvas extends Canvas{

        public Kanvas() {
            setBackground(Color.BLACK);
        }
        public void paint(Graphics g){
         g.setColor(Color.WHITE);
         g.drawLine(0,pusaty,k.getWidth(),pusaty);
         g.drawLine(pusatx,0,pusatx,k.getWidth());   
         Bresenham(g);
      }
    }

        public void Bresenham(Graphics g) {
            x1=pusatx+Integer.parseInt(tx1.getText());
            x2=pusatx+Integer.parseInt(tx2.getText());
            y1=pusaty-Integer.parseInt(ty1.getText());
            y2=pusaty-Integer.parseInt(ty2.getText());

//            if(x1>x2)
//            {
//                tmp=x1;
//                x1=x2;
//                x2=tmp;
//                
//                tmp=y1;
//                y1=y2;
//                y2=tmp;
//            }
//            dx=x2-x1;
//      dy=y2-y1;
//   
//      p=(2*dy)-dx;
//      if(p!=0)
//      {
//          do
//          {     
//              if((y2<y1&&x2<x1)||(x2>x1&&y2>y1))
//              {
//       
//                  if(p<0)
//                  {
//                      if(dx>dy)
//                      {
//                          x1=x1+1;
//                          p=p+(2*dy);
//                      }
//                      else
//                      {
//                          y1=y1+1;
//                          p=p+(2*dx);
//                      }
//                  }
//                  else
//                  {
//                      x1=x1+1;
//                      y1=y1+1;
//                      if(dx>dy)
//                      {
//                           p=p+((2*dy)-(2*dx));
//                      }
//                      else
//                      {
//                           p=p+(2*dx-2*dy);
//                      }
//                  }
//             }
//             else
//             {      
//                 if(p>0)
//                 {
//                     if(dx<dy)
//                     {
//                         x1=x1+1;
//                         p=p-(2*dy);
//                     }
//                     else
//                     {
//                         y1=y1-1;
//                         p=p-(2*dx);        
//                     }
//                }
//                else
//                {
//                    x1=x1+1;
//                    y1=y1-1;
//                    if(dx<(dy*(-1)))
//                    {
//                         p=p-((2*dy)+(2*dx));  //bener
//                    }
//                    else
//                    {
//                        p=p-((2*dx)+(2*dy*(-1)));
//                    }
//                }
//           }
//     
//           g.fillRect(x1, y1, 1, 1);
//        }
//        while((x1!=x2)&&(y1!=y2));
//     }
        int x,y,xend;
        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2-y1);
        int p = 2*dy-dx;
        int duady = 2*dy;
        int duadydx = 2*(dy-dx);
        if (x1>x2) {
            x = x2;
            y = y2;
            xend = x1;
        } else {
            x = x1;
            y = y1;
            xend = x2;
        }
        
       
        g.drawRect(x, y, 1, 1);
        while(x<xend) {
            x++;
            if(p<0) {
                p+=duady;
            } else {
                if (y1>y2) {
                    y--; } else y++;
                p+=duadydx;
            }
            g.drawRect(x, y, 1, 1);
        }
   }
            
            
        }
    
