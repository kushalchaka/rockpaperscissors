package game;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*; 
import javax.swing.border.Border;

public class RPSPanel extends JPanel implements MouseListener
{
	private final int GAME_WIDTH = 450;
    private final int GAME_HEIGHT = 620;
    private Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    private int turn = 1;
    private ImageIcon rock = new ImageIcon("src/images/rock.png");
    private ImageIcon paper = new ImageIcon("src/images/paper.png");
    private ImageIcon scissors = new ImageIcon("src/images/scissors.png");
    private JLabel titleLabel = new JLabel("Rock Paper Scissors");
    private JLabel instructionsLabel = new JLabel("Click on a left tile to begin");
    private JLabel temp = new JLabel("Rock Beats Scissors");
    private JLabel temp1 = new JLabel("Scissors Beats Paper");
    private JLabel temp2 = new JLabel("Paper Beats Rock");
    private JLabel winner;
    private JLabel[] labels;
    private Border border;
    private Timer myTimer;
    private String str = "";
    
    public RPSPanel() 
    {
    	 setPreferredSize(size);
      	 setLayout(null);
      	 border = BorderFactory.createLineBorder(Color.BLUE, 5);
      	 myTimer = new Timer(1000, new TimeListener());
      	 setLabels();
	}
    
    private void setLabels() //sets up the screen
    {
    	Random r = new Random();
		 float a = r.nextFloat();
		 float b = r.nextFloat();
		 float c = r.nextFloat();
		 Color rgb = new Color(a,b,c);
   	 	titleLabel.setFont(new Font("Script MT Bold", Font.ITALIC, 45));
   	 	titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
   	 	titleLabel.setBounds(0, 0, 450, 50);
   	 	titleLabel.setForeground(rgb);
   	 	instructionsLabel.setFont(new Font("Times New Roman", Font.BOLD,20));
   	 	instructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
   	 	instructionsLabel.setBounds(0,510,430,50);
   	 	instructionsLabel.setForeground(rgb);
   	 	temp.setFont(new Font("Times New Roman", Font.BOLD,15));
	 	temp.setHorizontalAlignment(SwingConstants.CENTER);
	 	temp.setBounds(0,530,430,50);
	 	temp.setForeground(rgb);
	 	temp1.setFont(new Font("Times New Roman", Font.BOLD,15));
	 	temp1.setHorizontalAlignment(SwingConstants.CENTER);
	 	temp1.setBounds(0,550,430,50);
	 	temp1.setForeground(rgb);
	 	temp2.setFont(new Font("Times New Roman", Font.BOLD,15));
	 	temp2.setHorizontalAlignment(SwingConstants.CENTER);
	 	temp2.setBounds(0,570,430,50);
	 	temp2.setForeground(rgb);
   	 	winner = new JLabel();
   	    winner.setFont(new Font("Times New Roman", Font.BOLD,35));
	 	winner.setHorizontalAlignment(SwingConstants.CENTER);
	 	winner.setBounds(0,540,430,50);
	 	winner.setForeground(rgb);
   	 	add(instructionsLabel);
   	 	add(titleLabel);
   	 	add(winner);
   	 	add(temp);
   	 	add(temp1);
   	 	add(temp2);
   	 	labels = new JLabel[6];
   	 	for (int i = 0; i < 6; i++)
   	 	{
   	 		labels[i] = new JLabel();
   	 		if (i < 3)
   	 		{
   	 			labels[i].addMouseListener(this);
   	 		}
   	 		add(labels[i]);
   	 	}
   	 	labels[0].setBounds(40,50,150,150); //player rock
   	 	labels[1].setBounds(40,210,150,150); //player paper
   	 	labels[2].setBounds(40,370,150,115); //player scissors
   	 	labels[3].setBounds(250,50,150,150); //computer rock
   	 	labels[4].setBounds(250,210,150,150); //computer paper
   	 	labels[5].setBounds(250,370,150,115); //computer scissors
   		labels[0].setIcon(rock); //player
   		labels[1].setIcon(paper); //player
   		labels[2].setIcon(scissors); //player
   		labels[3].setIcon(rock); //computer
   		labels[4].setIcon(paper); //computer
   		labels[5].setIcon(scissors); //computer
    }
    
    public int getRandomNumber(int min, int max) //gets random number for computer choice
    {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    private boolean playerWinner() //checks to see if player won
     {
    	
    	if (labels[0].getBorder() != null && labels[5].getBorder() != null)
    	{
    		System.out.println("rock beats scissors");
    		str = "rock beats scissors";
    		winner.setText(str);
    		
    		return true;
    		
    	}
    	if (labels[1].getBorder() != null && labels[3].getBorder() != null)
    	{
    		System.out.println("paper beats rock");
    		str = "paper beats rock";
    		winner.setText(str);
    		return true;
    	}
    	if (labels[2].getBorder() != null && labels[4].getBorder() != null)
    	{
    		System.out.println("scissors beats paper");
    		str = "scissors beats paper";
    		winner.setText(str);
    		return true;
    	}
    	return false;
     }
    
     private boolean computerWinner() //checks to see if computer won
     {
    	
    	 if (labels[0].getBorder() != null && labels[4].getBorder() != null)
    	 {
    		 System.out.println("paper beats rock");
    		 str = "paper beats rock";
     		winner.setText(str);
    		 return true;
    	 }
    	 if (labels[1].getBorder() != null && labels[5].getBorder() != null)
    	 {
    		 System.out.println("scissors beats paper");
    		 str = "scissors beats paper";
     		winner.setText(str);
    		 return true;
    	 }
    	 if (labels[2].getBorder() != null && labels[3].getBorder() != null)
    	 {
    		 System.out.println("rock beats scissors");
    		 str = "rock beats scissors";
     		winner.setText(str);
    		 return true;
    	 }
    	 return false;
     }
     
     private boolean checkTie() //checks for a tie
     {
    	 if (labels[0].getBorder() != null && labels[3].getBorder() != null)
    	 {
    		 System.out.println("tie");
    		 str = "rock cannot beat rock";
     		winner.setText(str);
    		 return true;
    	 }
    	 if (labels[1].getBorder() != null && labels[4].getBorder() != null)
    	 {
    		 System.out.println("tie");
    		 str = "paper cannot beat paper";
     		winner.setText(str);
    		 return true;
    	 }
    	 if (labels[2].getBorder() != null && labels[5].getBorder() != null)
    	 {
    		 System.out.println("tie");
    		 str = "scissors cannot beat scissors";
     		winner.setText(str);
    		 return true;
    	 }
    	 return false;
     }
     
     private void startOver() //resets the screen
    {
    	 labels[3].setBorder(null);
		 labels[4].setBorder(null);
		 labels[5].setBorder(null);
		 winner.setText("");
		 instructionsLabel.setBounds(0,510,430,50);
		 temp.setBounds(0,530,430,50);
		 temp1.setBounds(0,550,430,50);
		 temp2.setBounds(0,570,430,50);
		 Random r = new Random();
		 float a = r.nextFloat();
	 	 float b = r.nextFloat();
	 	 float c = r.nextFloat();
		 Color rgb = new Color(a,b,c);
		 titleLabel.setForeground(rgb);
		 instructionsLabel.setForeground(rgb);
    	 for(int i = 0; i < 5; i++)
       	 {
       		 
       		 if (i < 3)
       		 {
       			labels[i].setBorder(null);
       		 labels[i].removeMouseListener(this);
       		 labels[i].addMouseListener(this); 
       		 }
       		 else
       		 {
       			 labels[i].setBorder(null);
       		 }
       	 }
	}
     
    @Override
    public void mouseClicked(MouseEvent e)
    {
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
    	 Object src = e.getSource();
      	 int idx = -1;
      	 for (int i = 0; i < 3; i++)
      	 {
      		 if(src == labels[i])
      		 {
      			 idx = i;
      			 myTimer.start();
      		 }
      	 }
      	 
      	 if(turn % 2 == 1)
      	 {
      		 labels[idx].removeMouseListener(this);
      		instructionsLabel.setBounds(0,0,0,0);
      		temp.setBounds(0,0,0,0);
      		temp1.setBounds(0,0,0,0);
      		temp2.setBounds(0,0,0,0);
      		
      		
      	 }
      	 else
      	 {
      		 labels[idx].removeMouseListener(this);
      		instructionsLabel.setBounds(0,0,0,0);
      		temp.setBounds(0,0,0,0);
      		temp1.setBounds(0,0,0,0);
      		temp2.setBounds(0,0,0,0);
      		
      	 }
      	 turn++;
    }

	@Override
    public void mouseReleased(MouseEvent e)
    {
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
    	if (myTimer.isRunning()) 
    	{
    		return;
    	}
    	Object src = e.getSource();
       	 for(int x = 0; x < 3; x++)
       	 {
       		 if(labels[x].equals(src))
       		 {
       			Random r = new Random();
      			 float a = r.nextFloat();
      			 float b = r.nextFloat();
      			 float c = r.nextFloat();
      			 border = BorderFactory.createLineBorder(Color.getHSBColor(a,b,c), 5);
      			 labels[x].setBorder(border);
       			 
       			 
       		 }
       	 }
       	 
    }
    
    @Override
    public void mouseExited(MouseEvent e)
    {
    	Object src = e.getSource();
      	 for(int x = 0; x < 3; x++)
      	 {
      		 if(labels[x].equals(src))
      		 {
      			 labels[x].setBorder(null); 
      			 
      		 }
      	 }
    }
    
    public class TimeListener implements ActionListener
    {
   	 @Override
   	 public void actionPerformed(ActionEvent e)
   	 {
   		 int number = getRandomNumber(3,6);
   		Random r = new Random();
		 float a = r.nextFloat();
		 float b = r.nextFloat();
		 float c = r.nextFloat();
   		 border = BorderFactory.createLineBorder(Color.getHSBColor(a,b,c), 5);
   		 labels[number].setBorder(border);
   		 
   		 if (playerWinner())
     	 {
     		 int winner = JOptionPane.showConfirmDialog(null, "You Won!. Play Again?", "Game Over",JOptionPane.YES_NO_OPTION);
     		 if (winner == 0)
     		 {
     			 startOver();
     		 }
     		 else
     		 {
     			System.exit(0);
     		}
     	 }
     	 if (computerWinner())
     	 {
     		 int loser = JOptionPane.showConfirmDialog(null, "You Lost. Play Again?", "Game Over",JOptionPane.YES_NO_OPTION);
    		 if (loser == 0)
    		 {
    			 startOver();
    		 }
    		 else
    		 {
    			System.exit(0);
    		}
     	 }
     	 if (checkTie())
     	 {
     		 int tie = JOptionPane.showConfirmDialog(null, "Tie. Play Again?", "Game Over",JOptionPane.YES_NO_OPTION);
    		 if (tie == 0)
    		 {
    			 startOver();
    		 }
    		 else
    		 {
    			System.exit(0);
    		}
     	 }
   		 myTimer.stop();
   	 }
    }
}



