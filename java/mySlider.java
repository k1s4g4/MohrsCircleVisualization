
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class mySlider extends JSlider{
    private int min,value,max;
    private String name;
    public mySlider(int min,int value,int max){
        this.min=min;
        this.value=value;
        this.max=max;
        setOpaque(false);
        setMaximum(this.max);
        setMinimum(this.min);
        setValue(this.value);
        
    }
    public void changeSlider(int min,int value,int max){
        this.min=min;
        this.value=value;
        this.max=max;
        setMaximum(this.max);
        setMinimum(this.min);
        setValue(this.value);
        
    }
}