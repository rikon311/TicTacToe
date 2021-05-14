import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class TicTacToeFrame extends JFrame
{

   public TicTacToeFrame()
   {
         setLayout(new GridLayout(3,3));
         createButtons();
         for(int i=0;i<9;i++)
         add(buttons[i]);
         setSize(400,400);
         setResizable(false);
      
   }

public void createButtons()
{
  buttons=new JButton[9];
  for(int i=0;i<9;i++)
  {
  buttons[i]=new JButton();
  buttons[i].setBackground(Color.WHITE);
  }

   ActionListener listener=new ActionListener(){

    public void actionPerformed(ActionEvent e)
    {
      for(int i=0;i<9;i++)
      {
          if(e.getSource()==buttons[i])
          { 
           if(player.equals("X")&&buttons[i].getText().equals(""))
           {
              buttons[i].setFont(new Font("ComicSans",Font.ITALIC,50));
              buttons[i].setForeground(Color.BLUE);
              buttons[i].setText(player);
              displayVictorOrDraw();
              player="O";
           }
           else if(player.equals("O")&&buttons[i].getText().equals(""))
           {
             buttons[i].setFont(new Font("ComicSans",Font.ITALIC,50));
             buttons[i].setForeground(Color.RED);
             buttons[i].setText(player);
             displayVictorOrDraw();
             player="X";
           }
          }
    }
   }
  };

     for(int i=0;i<9;i++)
     buttons[i].addActionListener(listener);

}


    public boolean checkRows()
    {
        boolean victory=false;
        if(buttons[0].getText().equals(player)&&buttons[1].getText().equals(player)&&buttons[2].getText().equals(player)) victory=true;
        if(buttons[3].getText().equals(player)&&buttons[4].getText().equals(player)&&buttons[5].getText().equals(player)) victory=true;
        if(buttons[6].getText().equals(player)&&buttons[7].getText().equals(player)&&buttons[8].getText().equals(player)) victory=true;
        
         return victory;
    }

    
    public boolean checkColumns()
    {
      boolean victory=false;
      if(buttons[0].getText().equals(player)&&buttons[3].getText().equals(player)&&buttons[6].getText().equals(player)) victory=true;
      if(buttons[1].getText().equals(player)&&buttons[4].getText().equals(player)&&buttons[7].getText().equals(player)) victory=true;
      if(buttons[2].getText().equals(player)&&buttons[5].getText().equals(player)&&buttons[8].getText().equals(player)) victory=true;
      
       return victory;
    }


    public boolean checkDiagonals()
    {
      boolean victory=false;
      if(buttons[0].getText().equals(player)&&buttons[4].getText().equals(player)&&buttons[8].getText().equals(player)) victory=true;
      if(buttons[2].getText().equals(player)&&buttons[4].getText().equals(player)&&buttons[6].getText().equals(player)) victory=true;
     
      
       return victory;


    }

     public boolean checkDraw()
     {
       boolean draw=false;
      if(!buttons[0].getText().equals("")&&!buttons[1].getText().equals("")&&!buttons[2].getText().equals("")) 
      if(!buttons[3].getText().equals("")&&!buttons[4].getText().equals("")&&!buttons[5].getText().equals("")) 
      if(!buttons[6].getText().equals("")&&!buttons[7].getText().equals("")&&!buttons[8].getText().equals(""))
        draw=true;
       return draw;
     }



     public void displayVictorOrDraw()
     {
       boolean victory=checkRows()||checkColumns()||checkDiagonals();
       if(victory)
       {
       int option=JOptionPane.showConfirmDialog(this,"Player "+player+" has won! Do you want to play again?","Victory",JOptionPane.YES_NO_OPTION);
       if(option==JOptionPane.YES_OPTION)
       {
         for(int i=0;i<9;i++)
         buttons[i].setText("");
       }
       if(option==JOptionPane.NO_OPTION)
       {
         this.dispose();
       }
      }
       boolean draw=checkDraw();
       if(draw)
       {
       int option=JOptionPane.showConfirmDialog(this,"The game ended with a draw! Do you want to play again?","Draw",JOptionPane.YES_NO_OPTION);
       if(option==JOptionPane.YES_OPTION)
       {
         for(int i=0;i<9;i++)
         buttons[i].setText("");
       }
       if(option==JOptionPane.NO_OPTION)
       {
         this.dispose();
       }
      }


       }
    





private JButton buttons[];
private String player="X";

}