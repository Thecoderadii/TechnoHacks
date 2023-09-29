import java.awt.*;
import java.awt.event.*;
class Calculator extends Frame implements FocusListener,ActionListener
{
 Button btnadd,btnsub,btnmul,btndiv,btnclear,btnexit;
 Label lhead,l1,l2,l3,lfoot;
 TextField t1,t2,t3;
 String msg;
    Calculator()
    {
       setSize(600,500);
       setTitle("Simple Calculator");
       setBackground(new Color(10,40,89));
       setLocation(250,100);
       addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});
       setLayout(null);
       msg="";
       lhead = new Label("Calculator",Label.CENTER);
       lhead.setBounds(0,40,600,30);
       lhead.setFont(new Font("Arial Black",Font.BOLD|Font.ITALIC,25));
       lhead.setForeground(Color.red);
       add(lhead);
      
       Font f = new Font("Times New Roman",Font.BOLD,20);
       setFont(f);
       
       l1 = new Label("First number :",Label.RIGHT);
       l1.setBounds(80,100,200,30);
       l1.setForeground(Color.white);
       add(l1); 
       t1 = new TextField();
       t1.setBounds(300,100,200,30);
       t1.setBackground(Color.black); 
       t1.setForeground(Color.white);
       add(t1);
       t1.addFocusListener(this);

       l2 = new Label("Second number :",Label.RIGHT);
       l2.setBounds(80,150,200,30);
       l2.setForeground(Color.white);
       add(l2); 
       t2 = new TextField();
       t2.setBounds(300,150,200,30);
       t2.setBackground(Color.black);
       t2.setForeground(Color.white);
       add(t2);
       t2.addFocusListener(this);
       
       l3 = new Label("Result :",Label.RIGHT);
       l3.setBounds(80,200,200,30);
       l3.setForeground(Color.white);
       add(l3); 
       t3 = new TextField();
       t3.setBounds(300,200,200,30);
      // t3.setBackground(Color.black);
       t3.setForeground(Color.black);
       t3.setEnabled(false);
       add(t3);
 
       btnadd = new Button("Add");
       btnadd.setBounds(25,300,100,30);
       add(btnadd);
       btnadd.addFocusListener(this);
       btnadd.addActionListener(this);

       btnsub = new Button("Subtract");
       btnsub.setBounds(175,300,100,30);
       add(btnsub);
       btnsub.addFocusListener(this);
       btnsub.addActionListener(this);
       
       btnmul = new Button("Multiply");
       btnmul.setBounds(325,300,100,30);
       add(btnmul);
       btnmul.addFocusListener(this);
       btnmul.addActionListener(this);

       btndiv = new Button("Divide");
       btndiv.setBounds(475,300,100,30);
       add(btndiv);
       btndiv.addFocusListener(this);
       btndiv.addActionListener(this);

       btnclear = new Button("Clear");
       btnclear.setBounds(25,360,250,30);
       add(btnclear);
       btnclear.addFocusListener(this);
       btnclear.addActionListener(this);

       btnexit = new Button("Exit");
       btnexit.setBounds(325,360,250,30);
       add(btnexit);
       btnexit.addFocusListener(this);
       btnexit.addActionListener(this);
        
       lfoot = new Label("Testing ");
       lfoot.setBounds(10,460,600,30);
       lfoot.setForeground(Color.red);
       add(lfoot);
    } 
    public void focusGained(FocusEvent fe)
    {
     if(fe.getSource()==t1)
      msg = "Enter first number";
     else if(fe.getSource()==t2)
      msg="Enter second number";
     else if(fe.getSource()==btnadd)
      msg="Perform addition";
        else if(fe.getSource()==btnsub)
      msg="Perform subtraction";
     else if(fe.getSource()==btnmul)
      msg="Perform multiplication";
     else if(fe.getSource()==btndiv)
      msg="Perform division";
     else if(fe.getSource()==btnclear)
      msg="Clears all values";
     else
      msg="Exit out of program";

     setFooterMessage();
    }
    public void focusLost(FocusEvent fe)
    {
     msg="";
     setFooterMessage();
    }
    void setFooterMessage()
    {
     lfoot.setText(msg);
    }
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==btnclear)
     {
      t1.setText("");
      t2.setText("");
      t3.setText("");
      //t1.setFocus(true);
     }
     else if(ae.getSource()==btnexit)
      System.exit(0);
     else
     {
      double n1=0,n2=0,r=0;
      try
      {
      n1 = Double.parseDouble(t1.getText());
      n2 = Double.parseDouble(t2.getText());
      }catch(NumberFormatException e)
      {
       msg = "Improper numbers";
       setFooterMessage();
      }

      if(ae.getSource()==btnadd)
       r = n1+n2;
      else if(ae.getSource()==btnsub)
       r = n1-n2;
      else if(ae.getSource()==btnmul)
       r=n1*n2;
      else if(ae.getSource()==btndiv)
                r=n1/n2;
            t3.setText(""+r);
     }
    }
 public static void main(String[] args)
 {
      (new Calculator()).setVisible(true); 
 }
}