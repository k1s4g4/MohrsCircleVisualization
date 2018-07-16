import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;
import java.awt.image.BufferStrategy;
import java.awt.Toolkit;
public class MohrCanvas1 extends Canvas implements Runnable{
    public Graphics bufferGraphics1=null;
    public BufferStrategy bufferStrategy1=null;
    private Rectangle r;
    private boolean running;
    private Thread thread;
    private Mohr myMohr;
    private int xZero,yZero;
    private int xAxisX1,yAxisX1,xAxisY1,yAxisY1;
    private int xAxisX2,yAxisX2,xAxisY2,yAxisY2;
    private int xAxisLength,yAxisLength;
    private int arrowLength,labelSize;
    private double tMax,sMax;
    private double xRatio,yRatio;
    private int xOval,yOval,sizeOval;
    private double radius;
    private double minSigmaA,sigmaA,maxSigmaA,minSigmaB,sigmaB,maxSigmaB,minTauA,tauA,maxTauA,tauB,sigmaAA,sigmaBB,tauAA,tauBB,sigmaP,tauP,theta1,theta0,sigmaAve,cohesion,frictionAngle,sigma1,sigma3;
    private int xA,yA,xB,yB,xAA,yAA,xBB,yBB,xP,yP,xK,yK,xK1,yK1,xK2,yK2,xK3,yK3,xK23,yK23,xK4,yK4,xK5,yK5,xK6,yK6,xK56,yK56,xC,yC,xC1,yC1,xCC,yCC,xCC1,yCC1,xC2,yC2,xC3,yC3,xC23,xC4,yC4,xC5,yC5,xC6,yC6,yC23,x1,y1,x3,y3;
    private int dx,dy;
    private boolean failed,onFailure;
    public MohrCanvas1(Mohr myMohr){
        r=this.getBounds();
        this.thread=new Thread(this);
        running=true;
        this.myMohr=myMohr;
    }
    public void paint(Graphics g){
        if(bufferStrategy1==null){
            
            this.createBufferStrategy(2);
            bufferStrategy1=this.getBufferStrategy();
            bufferGraphics1=this.bufferStrategy1.getDrawGraphics();
            thread.start();
        }
    }
    @Override
    public void run(){
        while(running){
            //edw einai h epanalhptikh domh
            
            doLogic();
            
            Draw();
            
            DrawBackBufferToScreen();
            
            //=======================================================
            Thread.currentThread();
            try{
                  Thread.sleep(10);  
            }catch(Exception e){
                  e.printStackTrace();
            }
        }
    }
    public void doLogic(){
        //here we do the math
        r = getBounds();
        xZero=(r.width-1)/20;
        yZero=(r.height-1)/2;
        xAxisX1=0;
        xAxisY1=yZero;
        xAxisX2=(int)r.width/100*95;
        xAxisY2=yZero;
        yAxisX1=xZero;
        yAxisY1=(int)r.height/100*5;;
        yAxisX2=xZero;
        yAxisY2=(int)r.height/100*95;
        xAxisLength=xAxisX2-xZero;
        yAxisLength=-yAxisX1+yZero;
        //==================================================================================
        //=================================CALCULATE SCALING================================
        //==================================================================================
        minSigmaA=myMohr.getMinSigmaA();
        sigmaA=myMohr.getSigmaA();
        maxSigmaA=myMohr.getMaxSigmaA();
        minSigmaB=myMohr.getMinSigmaB();
        sigmaB=myMohr.getSigmaB();
        maxSigmaB=myMohr.getMaxSigmaB();
        minTauA=myMohr.getMinTauA();
        tauA=myMohr.getTauA();
        maxTauA=myMohr.getMaxTauA();
        tauB=myMohr.getTauB();
        sigmaAA=myMohr.getSigmaAA();
        sigmaBB=myMohr.getSigmaBB();
        tauAA=myMohr.getTauAA();
        tauBB=myMohr.getTauBB();
        sigmaP=myMohr.getSigmaP();
        tauP=myMohr.getTauP();
        theta1=myMohr.getTheta1();
        sigmaAve=myMohr.getSigmaAve();
        cohesion=myMohr.getCohesion();
        frictionAngle=myMohr.getFrictionAngle();
        failed=myMohr.getFailed();
        onFailure=myMohr.getOnFailure();
        sigma1=myMohr.getSigma1();
        double selectRangeSigma;
        double maxSigma;
        if((maxSigmaA-minSigmaB)>(maxSigmaB-minSigmaA)){
            selectRangeSigma=(maxSigmaA-minSigmaB);
            maxSigma=maxSigmaA;
        }else{
            selectRangeSigma=(maxSigmaB-minSigmaA);
            maxSigma=maxSigmaB;
        }
        double selectRangeTau;
        if(Math.abs(minTauA)>=Math.abs(maxTauA)){
             selectRangeTau=Math.abs(minTauA);
        }else{
            selectRangeTau=Math.abs(maxTauA);
        }
        selectRangeSigma=(selectRangeSigma/2)*(selectRangeSigma/2);
        selectRangeTau=selectRangeTau*selectRangeTau;
        tMax=Math.sqrt(selectRangeSigma+selectRangeTau);
        sMax=maxSigma*12/10;
        double dratio=yAxisLength/(xAxisLength*1.0d);
        if(sMax*dratio<tMax){
            tMax=tMax*12/10;
            sMax=(double)tMax/dratio;
        }else{
            sMax=sMax*12/10;
            tMax=(double)sMax*dratio;
        }
        
        //sMax=(double)tMax/dratio;
        xRatio=xAxisLength/sMax;
        yRatio=yAxisLength/tMax;
        //==================================================================================
        //=================================CALCULATE CIRCLE=================================
        //==================================================================================
        sigma3=myMohr.getSigma3();
        radius=myMohr.getRadius();
        xOval=(int)(sigma3*xRatio+xZero);
        yOval=(int)(-radius*yRatio+yZero);
        sizeOval=(int)(2*radius*yRatio);
        //==================================================================================
        //===========================CALCULATE A B P AA BB =================================
        //==================================================================================
        
        
        xA=(int)(xZero+xRatio*sigmaA);
        yA=(int)(yZero-yRatio*tauA);
        xB=(int)(xZero+xRatio*sigmaB);
        yB=(int)(yZero-yRatio*tauB);
        xAA=(int)(xZero+xRatio*sigmaAA);
        yAA=(int)(yZero-yRatio*tauAA);
        xBB=(int)(xZero+xRatio*sigmaBB);
        yBB=(int)(yZero-yRatio*tauBB);
        xP=(int)(xZero+xRatio*sigmaP);
        yP=(int)(yZero-yRatio*tauP);
        xK=(int)(xZero+xRatio*sigmaAve);
        yK=yZero;
        x1=(int)(xZero+xRatio*sigma1);
        y1=yZero;
        x3=(int)(xZero+xRatio*sigma3);
        y3=yZero;
        xK1=xK;
        yK1=(int)(yZero+yRatio*radius);
        xK2=xK1;
        yK2=yK1+30;
        xK3=xZero;
        yK3=yK2;
        xK23=(xK2+xK3)/2;
        yK23=(yK2+yK3)/2;
        xK4=x1;
        yK4=yK1;
        xK5=x1+70;
        yK5=yK1;
        xK6=xK5;
        yK6=yZero;
        xK56=(xK5+xK6)/2;
        yK56=(yK5+yK6)/2;
        xC=xZero;
        yC=(int)(yZero-yRatio*cohesion);
        xCC=xZero;
        yCC=(int)(yZero+yRatio*cohesion);
        xC1=(int)(xZero+xAxisLength);
        xCC1=xC1;
        xC2=xC+40;
        yC2=yC;
        xC3=xC+40;
        yC3=yZero;
        xC23=(xC2+xC3)/2;
        yC23=(yC2+yC3)/2;
        xC4=xC+80;
        yC4=yC;
        xC5=xC+120;
        yC5=yC;
        xC6=xC-80;
        yC6=yC-80;
        
        double angle=Math.tan(Math.toRadians(frictionAngle));
        
        yC1=(int)(yZero-(cohesion+angle*sMax)*yRatio);
        yCC1=(int)(yZero+(cohesion+angle*sMax)*yRatio);
        arrowLength=10;
        labelSize=30;
        
    }
    public void Draw(){
            bufferGraphics1=bufferStrategy1.getDrawGraphics();
            try{
                    //=====================================================================================================
                    //==========================================CLEARING BUFFER============================================
                    //=====================================================================================================                    
                    bufferGraphics1.clearRect(0,0,this.getSize().width,this.getSize().height);
                    
                    int alpha;
                    
                    //edw mpainei to paint\
                    Graphics2D bufferGraphics2D=(Graphics2D)bufferGraphics1;

                    //=====================================================================================================
                    //====================================PAINTING BUFFER==================================================
                    //=====================================================================================================                    
                    //bufferGraphics1
                    //bufferGraphics2D
                    int[] element1x={xP,xA,xB};
                    int[] element1y={yP,yA,yB};
                    int dxP=(xP-xK)/10-labelSize/4;
                    int dyP=(yP-yK)/10+labelSize/4;
                    bufferGraphics2D.setStroke(new BasicStroke(2));
                    bufferGraphics1.setColor(new Color(255,255,255,255));
                    bufferGraphics1.drawLine(xAxisX1,xAxisY1 , xAxisX2,xAxisY2 );
                    bufferGraphics1.drawLine(yAxisX1,yAxisY1 ,yAxisX2 ,yAxisY2 );
                    
                    bufferGraphics1.drawLine(xC,yC ,xC1,yC1 );
                    bufferGraphics1.drawLine(xCC,yCC ,xCC1,yCC1 );
                    
                    bufferGraphics2D.setStroke(new BasicStroke(3));
                    bufferGraphics1.drawLine(xAxisX2,xAxisY2 , xAxisX2-arrowLength,xAxisY2-arrowLength );
                    bufferGraphics1.drawLine(xAxisX2,xAxisY2 , xAxisX2-arrowLength,xAxisY2+arrowLength );
                    bufferGraphics1.drawLine(yAxisX1,yAxisY1 ,yAxisX1-arrowLength,yAxisY1+arrowLength);
                    bufferGraphics1.drawLine(yAxisX1,yAxisY1 ,yAxisX1+arrowLength,yAxisY1+arrowLength);
                    bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, labelSize));
                    bufferGraphics1.drawString("σ",xAxisX2+5,xAxisY2);
                    bufferGraphics1.drawString("τ",yAxisX1,yAxisY1-5);
                    
                    
                    if(failed){
                        bufferGraphics1.setColor(new Color(255,50,50,100));
                    }else{
                        if(onFailure){
                            bufferGraphics1.setColor(new Color(255,50,50,255));
                        }else{
                            bufferGraphics1.setColor(new Color(255,255,255,255));
                        }
                        
                    }
                    
                    
                    bufferGraphics1.drawOval(xOval,yOval,sizeOval,sizeOval);
                    bufferGraphics2D.setStroke(new BasicStroke(1));
                    bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 15));
                    bufferGraphics1.setColor(new Color(255,255,255,255));
                    bufferGraphics1.drawString("O(0,0)",xZero-40,yZero+20);
                    
                    bufferGraphics1.drawLine(xC2+5,yC2-5,xC2-5,yC2+5);
                    bufferGraphics1.drawLine(xC3+5,yC3-5,xC3-5,yC3+5);
                    bufferGraphics1.drawLine(xC2+10,yC2,xC2-10,yC2);
                    bufferGraphics1.drawLine(xC2,yC2,xC23,yC23-20);
                    bufferGraphics1.drawLine(xC3,yC3,xC23,yC23+20);
                    bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 17));
                    bufferGraphics1.drawLine(xC,yC,xC5,yC5);
                    
                    bufferGraphics1.drawArc(xC6,yC6,160,160,0,(int)frictionAngle);
                    if(frictionAngle<15){
                        bufferGraphics1.drawLine(xC4-5,yC4-5,xC5-17,yC5-45);
                        bufferGraphics1.drawString("φ = "+ myMohr.getRndFrictionAngle(),xC5-20,yC5-50);
                        bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 13));
                        bufferGraphics1.drawString("o",xC5-20+69,yC5-50-8);
                    }else{
                        bufferGraphics1.drawString("φ = "+ myMohr.getRndFrictionAngle(),xC5-20,yC5-20);
                        bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 13));
                        bufferGraphics1.drawString("o",xC5-20+69,yC5-20-8);
                    }
                    
                    bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 17));
                    if(Math.abs(yC2-yC3)<40){
                        bufferGraphics1.drawLine(xC23,yC23,xC23-20+5,yC23+5-55);
                        
                        bufferGraphics1.drawString("C = "+myMohr.getRndCohesion(),xC23-20,yC23+5-80);
                    }else{
                        bufferGraphics1.drawString("C = "+myMohr.getRndCohesion(),xC23-20,yC23+5);
                    }
                    if(!failed){
                        bufferGraphics1.setColor(new Color(255,255,255,255));
                        bufferGraphics2D.setStroke(new BasicStroke(1));
                        bufferGraphics1.drawPolygon(element1x,element1y,3);
                        bufferGraphics1.setColor(new Color(255,255,255,50));
                        bufferGraphics1.fillPolygon(element1x,element1y,3);
                        bufferGraphics1.setColor(new Color(255,255,255,255));
                        bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, labelSize/4*3));
                        dx=(xA-xB)/20-labelSize/4;
                        dy=(yA-yB)/20+labelSize/4;
                        bufferGraphics1.drawString("A",xA+dx,yA+dy);
                        
                        
                        
                        dx=(xB-xA)/20-labelSize/4;
                        dy=(yB-yA)/20+labelSize/4;
                        bufferGraphics1.drawString("B",xB+dx,yB+dy);
                        bufferGraphics1.setColor(new Color(27,170,255));
                        if(!((xP==xA && yP==yA)||(xP==xB && yP==yB))){
                            bufferGraphics1.drawString("P",xP+dxP,yP+dyP);
                        }
                        if(theta1!=0 && theta1!=-180 && theta1!=180){
                             
                         bufferGraphics1.setColor(Color.black);
                         int[] element2x={xP,xAA,xBB};
                         int[] element2y={yP,yAA,yBB};
                         bufferGraphics1.drawPolygon(element2x,element2y,3);
                         bufferGraphics1.setColor(new Color(0,0,0,50));
                         bufferGraphics1.fillPolygon(element2x,element2y,3);
                         //========draw labels===========
                         bufferGraphics1.setColor(new Color(0,0,0,255));
                         bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, labelSize/4*3));
                     
                         dx=(xAA-xBB)/20-labelSize/4;
                         dy=(yAA-yBB)/20+labelSize/4;
                         bufferGraphics1.drawString("AA",xAA+dx,yAA+dy);
                     
                     
                         dx=(xBB-xAA)/20-labelSize/4;
                         dy=(yBB-yAA)/20+labelSize/4;
                         bufferGraphics1.drawString("BB",xBB+dx,yBB+dy);
                        }
                        
                        
                        
                        
                        bufferGraphics2D.setStroke(new BasicStroke(1));
                        bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 22));
                        bufferGraphics1.setColor(new Color(0,0,0,255));
                        bufferGraphics1.drawLine(x1,y1,x1+40,y1-20);
                        bufferGraphics1.setColor(new Color(255,255,255,255));
                        bufferGraphics1.drawString("σ",x1+40,y1-20);
                        bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 11));
                        bufferGraphics1.drawString("1",x1+53,y1-18);
                        bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 17));
                        bufferGraphics1.drawString("="+myMohr.getRndSigma1(),x1+63,y1-20);
                    
                        bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 22));
                        bufferGraphics1.setColor(new Color(0,0,0,255));
                    
                        if(x3<130){
                            bufferGraphics1.drawLine(x3,y3,x3-133+140,y3+5);
                            bufferGraphics1.setColor(new Color(255,255,255,255));
                            bufferGraphics1.drawString("σ",x3-130+140,y3+20);
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 11));
                            bufferGraphics1.drawString("3",x3-117+140,y3+22);
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 17));
                            bufferGraphics1.drawString("= "+myMohr.getRndSigma3(),x3-105+140,y3+20);
                        }else{
                            bufferGraphics1.drawLine(x3,y3,x3-40,y3+30);
                            bufferGraphics1.setColor(new Color(255,255,255,255));
                            bufferGraphics1.drawString("σ",x3-130,y3+40);
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 11));
                            bufferGraphics1.drawString("3",x3-117,y3+42);
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 17));
                            bufferGraphics1.drawString("= "+myMohr.getRndSigma3(),x3-105,y3+40);
                        }
                    
                    
                    
                    
                    
                        bufferGraphics1.drawLine(xK3+5,yK3-5,xK3-5,yK3+5);
                        bufferGraphics1.drawLine(xK2+5,yK2-5,xK2-5,yK2+5);
                        bufferGraphics1.drawLine(xK2,yK2-10,xK2,yK2+10);
                    
                    
                        if(Math.abs(xK2-xK3)<120){
                            bufferGraphics1.drawLine(xK2,yK2,xK23+10,yK23);
                            bufferGraphics1.drawLine(xK3,yK3,xK23-10,yK23);
                            
                            bufferGraphics1.drawLine(xK23,yK23,xK23+25,yK23+25);
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 22));
                            bufferGraphics1.drawString("σ",xK23-40+30,yK23+5+30);
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 11));
                            bufferGraphics1.drawString("ave",xK23-27+30,yK23+5+30);
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 17));
                            bufferGraphics1.drawString("= "+myMohr.getRndSigmaAve(),xK23-10+30,yK23+5+30);
                        }else{
                            bufferGraphics1.drawLine(xK2,yK2,xK23+60,yK23);
                            bufferGraphics1.drawLine(xK3,yK3,xK23-60,yK23);
                        
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 22));
                            bufferGraphics1.drawString("σ",xK23-40,yK23+5);
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 11));
                            bufferGraphics1.drawString("ave",xK23-27,yK23+5);
                            bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 17));
                            bufferGraphics1.drawString("= "+myMohr.getRndSigmaAve(),xK23-10,yK23+5);
                        }
                    
                    
                    
                    
                    
                    
                        bufferGraphics1.drawLine(xK6+5,yK6-5,xK6-5,yK6+5);
                        bufferGraphics1.drawLine(xK5+5,yK5-5,xK5-5,yK5+5);
                        bufferGraphics1.drawLine(xK5+10,yK5,xK5-10,yK5);
                        bufferGraphics1.drawLine(xK6,yK6,xK56,yK56-20);
                        bufferGraphics1.drawLine(xK5,yK5,xK56,yK56+20);
                    
                        bufferGraphics1.setFont(new Font("Serif", Font.PLAIN, 17));
                        if(Math.abs(yK6-yK5)<60){
                            bufferGraphics1.drawLine(xK56,yK56,xK5+28,yK5+5);
                            bufferGraphics1.drawString("R= "+myMohr.getRndRadius(),xK5+30,yK5+20);
                        }else{
                            bufferGraphics1.drawString("R= "+myMohr.getRndRadius(),xK56-30,yK56+5);
                        }
                    }
                    
            }catch(Exception e){
                    e.printStackTrace();        
            }finally{
                    bufferGraphics1.dispose();
            }
    }
    public void DrawBackBufferToScreen(){
        bufferStrategy1.show();
        Toolkit.getDefaultToolkit().sync();
    }
    public void setRunning(boolean a){
        running=a;
    }
}
