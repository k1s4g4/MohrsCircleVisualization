import java.awt.*;
import java.math.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.geom.Line2D;

public class StartCanvas extends Canvas{
    private int nPoints,i;
    private Graphics g1;
    private Graphics2D gr1;
    private int[] xPoints;
    private Rectangle r;
    private int[] xPointsOut;
    private int[] yPoints;
    private int[] yPointsOut;
    private double[] angle;
    private String[] name,subName1;
    private int textSize;
    private double radius;
    private int[] size;
    private double theta0;
    private double quantity;
    private int intQuantity;
    public void paint(Graphics g1){
        setSize(400,300);
        nPoints=4;
        setBackground(new Color(7,100,171));
        Graphics2D gr1 = (Graphics2D) g1;
        gr1.setStroke(new BasicStroke(3));
        xPoints=new int[4];
        yPoints=new int[4];
        xPointsOut=new int[4];
        yPointsOut=new int[4];
        name=new String[4];
        subName1=new String[4];
        name[0]="σ";
        name[1]="σ";
        name[2]="σ";
        name[3]="σ";
        angle=new double[4];
        subName1[0]="A";
        subName1[1]="B";
        subName1[2]="A";
        subName1[3]="B";
        size=new int[4];
        r = getBounds();
        radius=0.25*r.height;
        textSize=(int)(radius/10*4);
        theta0=0;
         for(i=0;i<=3;i++){
            angle[i]=-(45+theta0+i*90)*3.141592/180;
            size[i]=(int)(0.25*r.height);
            quantity=radius*Math.cos(angle[i])+r.width/2;
            intQuantity=(int)quantity;
            this.xPoints[i]=intQuantity;
            quantity=(radius+size[i])*Math.cos(angle[i])+r.width/2;
            intQuantity=(int)quantity;
            this.xPointsOut[i]=intQuantity;
            quantity=radius*Math.sin(angle[i])+r.height/2;
            intQuantity=(int)quantity;
            this.yPoints[i]=intQuantity;
            quantity=(radius+size[i])*Math.sin(angle[i])+r.height/2;
            intQuantity=(int)quantity;
            this.yPointsOut[i]=intQuantity;
        }
        g1.setColor(Color.white);
        //================================================
        //================================================
        g1.drawPolygon(xPoints,yPoints,nPoints);
        g1.setColor(new Color(255,255,255,50));
        g1.fillPolygon(xPoints,yPoints,nPoints);
        g1.setColor(Color.white);
        
         gr1.setStroke(new BasicStroke(2));
        for(int j=0;j<=3;j++){
                     //drawVector(xPoints[j]+xPoints[j+1],yPoints[j]+yPoints[j+1],angle[j],size[j]);
                     int x1,x2,x3,x33,x333,x4,x44,x444,x5,x6,x7,x8,x88,x9,x10,x11,x12,x13,x14,x15,x16,x17,x18;
                     int y1,y2,y3,y33,y333,y4,y44,y444,y5,y6,y7,y8,y88,y9,y10,y11,y12,y13,y14,y15,y16,y17,y18;
                     int dx,dy;
                     if(j<3){
                          x1=(xPoints[j]+xPoints[j+1])/2;
                          y1=(yPoints[j]+yPoints[j+1])/2;
                          x2=(xPointsOut[j]+xPointsOut[j+1])/2;
                          y2=(yPointsOut[j]+yPointsOut[j+1])/2;
                          g1.drawLine(x1,y1,x2,y2);
                          x3=(8*xPoints[j]+2*xPointsOut[j])/10;
                          y3=(8*yPoints[j]+2*yPointsOut[j])/10;
                          x4=(8*xPoints[j+1]+2*xPointsOut[j+1])/10;
                          y4=(8*yPoints[j+1]+2*yPointsOut[j+1])/10;
                          x33=(7*xPoints[j]+3*xPointsOut[j])/10;
                          y33=(7*yPoints[j]+3*yPointsOut[j])/10;
                          x44=(7*xPoints[j+1]+3*xPointsOut[j+1])/10;
                          y44=(7*yPoints[j+1]+3*yPointsOut[j+1])/10;
                          x333=(6*xPoints[j]+4*xPointsOut[j])/10;
                          y333=(6*yPoints[j]+4*yPointsOut[j])/10;
                          x444=(6*xPoints[j+1]+4*xPointsOut[j+1])/10;
                          y444=(6*yPoints[j+1]+4*yPointsOut[j+1])/10;
                          x5=(x3+x4)/2;
                          y5=(y3+y4)/2;
                          x6=(9*x5+x3)/10;
                          y6=(9*y5+y3)/10;
                          x7=(9*x5+x4)/10;
                          y7=(9*y5+y4)/10;
                          x8=(x33+x44)/2;
                          y8=(y33+y44)/2;
                          x88=(x333+x444)/2;
                          y88=(y333+y444)/2;
                          x9=(2*x8+3*x33)/5;
                          y9=(2*y8+3*y33)/5;
                          x10=(2*x8+3*x44)/5;
                          y10=(2*y8+3*y44)/5;
                          
                          x11=(3*x8+2*x33)/5;
                          y11=(3*y8+2*y33)/5;
                          x12=(3*x8+2*x44)/5;;
                          y12=(3*y8+2*y44)/5;
                          
                          dx=x11-x8;
                          dy=y11-y8;
                          x13=x5+dx;
                          y13=y5+dy;
                          x15=x88+dx;
                          y15=y88+dy;
                          dx=x12-x8;
                          dy=y12-y8;
                          x14=x5+dx;
                          y14=y5+dy;
                          x16=x88+dx;
                          y16=y88+dy;
                          
                          dx=x7-x5;
                          dy=y7-y5;
                          x17=x8+dx;
                          y17=y8+dy;
                          
                          dx=x6-x5;
                          dy=y6-y5;
                          x18=x8+dx;
                          y18=y8+dy;
                          
                          
                          int[] xArrow={x1,x6,x7};
                          int[] yArrow={y1,y6,y7};
                          g1.fillPolygon(xArrow,yArrow,3);
                          g1.setFont(new Font("Serif", Font.PLAIN, textSize)); 
                          dx=x8-x1-(textSize-2)/2;
                          dy=y8-y1+(textSize-2)/2;
                          g1.drawString(name[j],x2+dx,y2+dy);
                          g1.setFont(new Font("Serif", Font.PLAIN, textSize*5/10));
                          g1.drawString(subName1[j],x2+dx+textSize*6/10,y2+dy);
                    }else{
                          x1=(xPoints[j]+xPoints[0])/2;
                          y1=(yPoints[j]+yPoints[0])/2;
                          x2=(xPointsOut[j]+xPointsOut[0])/2;
                          y2=(yPointsOut[j]+yPointsOut[0])/2;
                          g1.drawLine(x1,y1,x2,y2);
                          x3=(8*xPoints[j]+2*xPointsOut[j])/10;
                          y3=(8*yPoints[j]+2*yPointsOut[j])/10;
                          x4=(8*xPoints[0]+2*xPointsOut[0])/10;
                          y4=(8*yPoints[0]+2*yPointsOut[0])/10;
                          x33=(7*xPoints[j]+3*xPointsOut[j])/10;
                          y33=(7*yPoints[j]+3*yPointsOut[j])/10;
                          x44=(7*xPoints[0]+3*xPointsOut[0])/10;
                          y44=(7*yPoints[0]+3*yPointsOut[0])/10;
                          x333=(6*xPoints[j]+4*xPointsOut[j])/10;
                          y333=(6*yPoints[j]+4*yPointsOut[j])/10;
                          x444=(6*xPoints[0]+4*xPointsOut[0])/10;
                          y444=(6*yPoints[0]+4*yPointsOut[0])/10;
                          x5=(x3+x4)/2;
                          y5=(y3+y4)/2;
                          x6=(9*x5+x3)/10;
                          y6=(9*y5+y3)/10;
                          x7=(9*x5+x4)/10;
                          y7=(9*y5+y4)/10;
                          x8=(x33+x44)/2;
                          y8=(y33+y44)/2;
                          x88=(x333+x444)/2;
                          y88=(y333+y444)/2;
                          x9=(2*x8+3*x33)/5;
                          y9=(2*y8+3*y33)/5;
                          x10=(2*x8+3*x44)/5;
                          y10=(2*y8+3*y44)/5;
                                                   
                          x11=(3*x8+2*x33)/5;
                          y11=(3*y8+2*y33)/5;
                          x12=(3*x8+2*x44)/5;;
                          y12=(3*y8+2*y44)/5;
                          
                          dx=x11-x8;
                          dy=y11-y8;
                          x13=x5+dx;
                          y13=y5+dy;
                          x15=x88+dx;
                          y15=y88+dy;
                          dx=x12-x8;
                          dy=y12-y8;
                          x14=x5+dx;
                          y14=y5+dy;
                          x16=x88+dx;
                          y16=y88+dy;
                          
                          dx=x7-x5;
                          dy=y7-y5;
                          x17=x8+dx;
                          y17=y8+dy;
                          
                          dx=x6-x5;
                          dy=y6-y5;
                          x18=x8+dx;
                          y18=y8+dy;
                          
                          int[] xArrow={x1,x6,x7};
                          int[] yArrow={y1,y6,y7};
                          g1.fillPolygon(xArrow,yArrow,3);
                          g1.setFont(new Font("Serif", Font.PLAIN, textSize)); 
                          dx=x8-x1-(textSize-2)/2;
                          dy=y8-y1+(textSize-2)/2;
                          g1.drawString(name[j],x2+dx,y2+dy);
                          g1.setFont(new Font("Serif", Font.PLAIN, textSize*5/10));
                          g1.drawString(subName1[j],x2+dx+textSize*6/10,y2+dy);
                    }
                    if(j==0 || j==2){
                        g1.drawLine(x18,y18,x11,y11);
                        int[] xArrow1={x9,x15,x13};
                        int[] yArrow1={y9,y15,y13};
                        g1.fillPolygon(xArrow1,yArrow1,3);
                        
                    }else{
                        g1.setFont(new Font("Serif", Font.PLAIN, textSize)); 
                        g1.drawString("τ",x44-21/4,y44+21/4);
                        g1.drawLine(x17,y17,x12,y12);
                        int[] xArrow1={x10,x16,x14};
                        int[] yArrow1={y10,y16,y14};
                        g1.fillPolygon(xArrow1,yArrow1,3);
                    }
        }
    }
}
