
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ThetaSlider extends JSlider{
    public ThetaSlider(int min,int value1,int max){
        setOpaque(false);
        setMaximum(max);
        setMinimum(min);
        setValue(value1);
    }
    public void changeSlider(int min,int value,int max){
        setMaximum(max);
        setMinimum(min);
        setValue(value);
    }
}