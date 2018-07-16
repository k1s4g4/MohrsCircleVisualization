import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
public class MohrUI extends JFrame {
    public Mohr myMohr;
    private MohrCanvasContainer myCanvasContainer;
    private ElementCanvasContainer myElementCanvasContainer;
    private MohrCanvas1 myCanvas1;
    private JButton closeBtn;
    private bottomPanel myBottom;
    private LineEndPanel myEnd;
    private myButton fullScreen;
    private boolean isFullScreen;
    public MohrUI(double sigmaA,double sigmaB,double tau){
        this.myMohr=new Mohr(sigmaA,sigmaB,tau);
        myCanvasContainer=new MohrCanvasContainer(myMohr);
        
        this.requestFocus();
       
        //================visual choices===========
        setUndecorated(true);
        
        setSize(1280,720);
        setLocationRelativeTo(null);
        isFullScreen=false;
        //=============container properties===========
        Container cp=getContentPane();
        cp.setBackground(new Color(7,100,171));
        cp.setLayout(new BorderLayout(10,10));
        
        
        //==========Bottom   Bottom================= 
        
        myBottom=new bottomPanel();
        cp.add(myBottom,BorderLayout.PAGE_END);
        BtnListener listener = new BtnListener();
        myButton exit=myBottom.getExitBtn();
        myButton reset=myBottom.getResetBtn();
        myButton fullScreen=myBottom.getFullScreenBtn();
        myButton credits=myBottom.getCreditsBtn();
        exit.addActionListener(listener);
        reset.addActionListener(listener);
        fullScreen.addActionListener(listener);
        credits.addActionListener(listener);
        
        //==========lineEnd lineEnd==============
        myEnd=new LineEndPanel(myMohr);
        myElementCanvasContainer=myEnd.getElementCanvasContainer();
        cp.add(myEnd,BorderLayout.LINE_END);
        cp.add(myCanvasContainer,BorderLayout.CENTER);
        //JButton addBtn=new JButton("add data");
        //cp.add("South",addBtn);
        
        setVisible(true);
    }
    
   public class BtnListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         String btnLabel = evt.getActionCommand();
         JButton source=(JButton)evt.getSource();
         if (btnLabel.equals("Exit")) {
            myCanvasContainer.setRunning(false);
            myElementCanvasContainer.setRunning(false);
            dispose();
            System.exit(0);
         } else if (btnLabel.equals("Full Screen")) {
                
                    
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
                    isFullScreen=true;
                    source.setText("Window Mode");
               
             
         }else if(btnLabel.equals("Minimize")) {
             setState(JFrame.ICONIFIED);
         }else if(btnLabel.equals("Reset")){
             myCanvasContainer.setRunning(false);
             myElementCanvasContainer.setRunning(false);
             dispose();
             new InputUI();
         }else{
             
             setSize(1280,720);
             setLocationRelativeTo(null);
             isFullScreen=false;
             source.setText("Full Screen");
         }
      }
   }
}