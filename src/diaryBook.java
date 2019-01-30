import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class diaryBook{

	

	public static class diary extends JFrame{
		private imagePanel cover_PN=new imagePanel(cover);       
		private imagePanel cata_PN=new imagePanel(cover);     
		private imagePanel write_PN=new imagePanel(writeBG);     
		private imagePanel read_PN=new imagePanel(readBG);       
		private imagePanel field_PN=new imagePanel(readBG);    
		
		
		
		
		
		public void cover_x(){
			cover_PN.setLayout(null);
			sxw.setBounds(130,360,100,100);               
			exit1.setBounds(330,360,100,100);             
			sdf.setBounds(70,70,400,133);                 
			cover_PN.add(sxw);                           
			cover_PN.add(exit1);                         
			cover_PN.add(sdf);                           
			
			sxw.addMouseListener(new turnToCatalog());                   
			exit1.addMouseListener(                                     
					new MouseListener(){
				    	public void mouseClicked(MouseEvent e){
				    	}
				    	public void mousePressed(MouseEvent e){
				    	}
				    	public void mouseReleased(MouseEvent e){
				    		setCursor(Cursor.DEFAULT_CURSOR);            
				    		System.exit(0);
				    	}
				    	public void mouseEntered(MouseEvent e){          
				    		setCursor(Cursor.HAND_CURSOR);
				    	}
				    	public void mouseExited(MouseEvent e){         
				    		setCursor(Cursor.DEFAULT_CURSOR);
				    	}
				    });
		}/*coverIF()*/
		
		
		
		
		
		public void write_x(){
			write_PN.setLayout(null);
			
			GregorianCalendar currentTime=new GregorianCalendar();
			int year=currentTime.get(Calendar.YEAR);
			int month=currentTime.get(Calendar.MONTH)+1;            
			int day=currentTime.get(Calendar.DAY_OF_MONTH);
			int day1=currentTime.get(Calendar.DAY_OF_WEEK);
			Date date=currentTime.getTime();
			int hour=date.getHours();
			int minute=date.getMinutes();
			int second=date.getSeconds();
			
			
			String week="周一";                           
			switch(day1){
			case 1:week="周日";break;
			case 2:week="周一";break;
			case 3:week="周二";break;
			case 4:week="周三";break;
			case 5:week="周四";break;
			case 6:week="周五";break;
			case 7:week="周六";break;		
			}
			
			final String currentTimeString1=String.valueOf(year)
					+"/"+String.valueOf(month)+"/"+String.valueOf(day1)+"   "+week;
			final String currentTimeString2=String.valueOf(hour)
					+":"+String.valueOf(minute)+":"+String.valueOf(second);
			
			JLabel data_L=new JLabel(currentTimeString1);          
			data_L.setFont(TitleFont);
			
            wordField.setText("");                                  
			wordField.setLineWrap(true);
			wordField.setWrapStyleWord(true);
			wordField.setEditable(true);
			wordField.setOpaque(false);                             
			wordField.setFont(diaryFont);                          
			
			scroll_2.setBounds(0,120,450,310);
			scroll_2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
			scroll_2.setOpaque(false);                             
			scroll_2.getViewport().setOpaque(false);
			
			data_L.setBounds(125,15,300,100);                     
			btn2.setBounds(420,520,120,66);                         
			qw.setBounds(30,500,100,100);                             
    		qw.setToolTipText("save");                                

			
			write_PN.add(scroll_2);                              
			write_PN.add(data_L);                                
			write_PN.add(btn2);                                       
			write_PN.add(qw);                                   
			
			btn2.addMouseListener(					                 
			    new MouseListener(){
			    	public void mouseClicked(MouseEvent e){
			    	}
			    	public void mousePressed(MouseEvent e){
			    	}
			    	public void mouseReleased(MouseEvent e){
			    		setCursor(Cursor.DEFAULT_CURSOR);             
			    		cover_PN.setVisible(false);
			    		cata_PN.setVisible(true);
			    		write_PN.setVisible(false);
			    		read_PN.setVisible(false);
			            wordField.setText("");                      
			    	}
			    	public void mouseEntered(MouseEvent e){          
			    		setCursor(Cursor.HAND_CURSOR);
			    	}
			    	public void mouseExited(MouseEvent e){         
			    		setCursor(Cursor.DEFAULT_CURSOR);
			    	}
			    });
			
			qw.addMouseListener(
				new turnToCatalog(){
					public void mouseClicked(MouseEvent e){
			    	}
			    	public void mousePressed(MouseEvent e){
			    	}
			    	public void mouseReleased(MouseEvent e){
			    		setCursor(Cursor.DEFAULT_CURSOR);                
			    		cover_PN.setVisible(false);
			    		cata_PN.setVisible(true);
			    		write_PN.setVisible(false);
			    		read_PN.setVisible(false);
			    		
			    	
			    		try{
							FileWriter outputFile=new FileWriter("diaryRecord/diaryRecord.dat",true);
							outputFile.write(currentTimeString1+" "+currentTimeString2+"\r\n"+wordField.getText()+"\r\n"+"\r\n");
							outputFile.close();
							FileWriter outputTitleFile=new FileWriter("diaryRecord/diaryTitleRecord.dat",true);
							outputTitleFile.write(currentTimeString1+" "+currentTimeString2+"\r\n");
							outputTitleFile.close();
				        }
				    	catch(Exception e1){
				    		e1.printStackTrace();
				    	}

		                wordField.setText("");                        
		                
		                JOptionPane jop=new JOptionPane();
		                jop.showMessageDialog(null,"succeed","warming",JOptionPane.PLAIN_MESSAGE);
		                jop=null;
		                
			    	}
			    	public void mouseEntered(MouseEvent e){              
			    		setCursor(Cursor.HAND_CURSOR);
			    	}
			    	public void mouseExited(MouseEvent e){                
			    		setCursor(Cursor.DEFAULT_CURSOR);
			    	}
				});
		}/*writeIF()*/
		
		public void cata_x(){			
			cata_PN.setLayout(null);
    		wwe.setBounds(52,70,336,120);                 
    		wer.setBounds(52,230,336,120);                 
    		btn1.setBounds(420,520,90,90);                  
    		
    		cata_PN.add(wwe);                          
    		cata_PN.add(wer);                         
    		cata_PN.add(btn1);                       
    		
			wwe.addMouseListener(new turnToWrite());       
			wer.addMouseListener(new turnToRead());        
			btn1.addMouseListener(new turnToCover());      
		}/*catalogIF()*/
		


		public void readIF(){
			read_PN.setLayout(null);
			int i=0;
			
			try{
				BufferedReader inputDiaryTitle=new BufferedReader(
						new FileReader("diaryRecord/diaryTitleRecord.dat"));
				String diaryTitle;
				
				while((diaryTitle=inputDiaryTitle.readLine())!= null){
					JLabel diaryTitleLabel=new JLabel(diaryTitle);
					diaryTitleLabel.setBounds(20,20*(i+1),450,15);
			        read_PN.add(diaryTitleLabel);
			        diaryTitleLabel.addMouseListener(new showContent(diaryTitle));
				    i++;			        
			    }
				
			    inputDiaryTitle.close();			       
			}
			catch(EOFException e){
	    		e.printStackTrace();
	    	}
			catch(IOException e){
	    		e.printStackTrace();
	    	}
			
			btn3.setBounds(420,520,120,66);                                   
			read_PN.add(btn3);                                         
			btn3.addMouseListener(new turnToCatalog());                     
		}/*readIF()*/
		
		
		
		public void readContentIF(String title){
	    	field_PN.setLayout(null);
	    	field_PN.setBounds(0,0,450,550);
	    	
	    	diaryTitle_t.setText(title);
	    	diaryTitle_t.setFont(diaryFont);
	    	diaryTitle_t.setBounds(10,60,300,20);                   
	    	btn4.setBounds(325,450,120,66);                           
	    	
	    	contentArea.setLineWrap(true);
	    	contentArea.setWrapStyleWord(true);
	    	contentArea.setEditable(false);
	    	contentArea.setOpaque(false);                              
	    	contentArea.setFont(diaryFont);                           
	    	
			scroll.setBounds(0,120,450,310);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
			scroll.setOpaque(false);                              
			scroll.getViewport().setOpaque(false);
			
			field_PN.add(btn4);                                    
			field_PN.add(diaryTitle_t);                        
	    	field_PN.add(scroll);
			add(field_PN);
			
			btn4.addMouseListener(new turnToRead());                  
		}

	    class imagePanel extends JPanel{   
		  private Image cover1;
		  
		  public imagePanel(ImageIcon i1){                    
			  super();
			  cover1=i1.getImage();
		  }
		  
		  protected void paintComponent(Graphics g){
			  super.paintComponent(g);
			  if(cover1!=null)
				  g.drawImage(cover1,0,0,getWidth(),getHeight(),this);
		  }
	    }/*imagePanel*/
	   
	  	    
	    class turnToCatalog implements MouseListener{
	    	public void mouseClicked(MouseEvent e){
	    	}
	    	public void mousePressed(MouseEvent e){
	    	}
	    	public void mouseReleased(MouseEvent e){
	    		setCursor(Cursor.DEFAULT_CURSOR);            
	    		cover_PN.setVisible(false);
	    		cata_PN.setVisible(true);
	    		write_PN.setVisible(false);
	    		read_PN.setVisible(false);
		    	field_PN.setVisible(false);
	    	}
	    	public void mouseEntered(MouseEvent e){        
	    		setCursor(Cursor.HAND_CURSOR);
	    	}
	    	public void mouseExited(MouseEvent e){          
	    		setCursor(Cursor.DEFAULT_CURSOR);
	    	}
	    }/*turnToCatalog*/
	    
	    
	    class turnToWrite implements MouseListener{
	    	public void mouseClicked(MouseEvent e){
	    	}
	    	public void mousePressed(MouseEvent e){
	    	}
	    	public void mouseReleased(MouseEvent e){
	    		setCursor(Cursor.DEFAULT_CURSOR);            
	    		cover_PN.setVisible(false);
	    		cata_PN.setVisible(false);
	    		write_PN.setVisible(true);
	    		read_PN.setVisible(false);
		    	field_PN.setVisible(false);
	    	}
	    	public void mouseEntered(MouseEvent e){          
	    		setCursor(Cursor.HAND_CURSOR);
	    	}
	    	public void mouseExited(MouseEvent e){         
	    		setCursor(Cursor.DEFAULT_CURSOR);
	    	}
	    }/*turnToWrite*/
	    
	    
	    class turnToRead implements MouseListener{
	    	public void mouseClicked(MouseEvent e){
	    	}
	    	public void mousePressed(MouseEvent e){
	    	}
	    	public void mouseReleased(MouseEvent e){
	    		setCursor(Cursor.DEFAULT_CURSOR);             
	    		cover_PN.setVisible(false);
	    		cata_PN.setVisible(false);
	    		write_PN.setVisible(false);
	    		read_PN.setVisible(true);		    	
	    		field_PN.setVisible(false);
	    		
	    		readIF();
				read_PN.setBounds(0,0,450,550);
				add(read_PN);
	    	}
	    	public void mouseEntered(MouseEvent e){           
	    		setCursor(Cursor.HAND_CURSOR);
	    	}
	    	public void mouseExited(MouseEvent e){             
	    		setCursor(Cursor.DEFAULT_CURSOR);
	    	}
	    }
	    
	    
	    class turnToCover implements MouseListener{
	    	public void mouseClicked(MouseEvent e){
	    	}
	    	public void mousePressed(MouseEvent e){
	    	}
	    	public void mouseReleased(MouseEvent e){
	    		setCursor(Cursor.DEFAULT_CURSOR);             
	    		cover_PN.setVisible(true);
	    		cata_PN.setVisible(false);
	    		write_PN.setVisible(false);
	    		read_PN.setVisible(false);
		    	field_PN.setVisible(false);
	    	}
	    	public void mouseEntered(MouseEvent e){          
	    		setCursor(Cursor.HAND_CURSOR);
	    	}
	    	public void mouseExited(MouseEvent e){            
	    		setCursor(Cursor.DEFAULT_CURSOR);
	    	}
	    }
	    
	    class showContent implements MouseListener{

	    	private String s;             
	    	
	    	public showContent(String s1){ 
	    		super();	    	
	    		s=s1;
	    	}
	    	public void mouseClicked(MouseEvent e){
		    }
		    public void mousePressed(MouseEvent e){
		    }
		    public void mouseReleased(MouseEvent e){
		    	setCursor(Cursor.DEFAULT_CURSOR);           
		    	
		    	readContentIF(s);
		    	cover_PN.setVisible(false);
		    	cata_PN.setVisible(false);
		    	write_PN.setVisible(false);
		    	read_PN.setVisible(false);
		    	field_PN.setVisible(true);
		    	
		    	String title=s;    

		    	
		    	try{
		    		BufferedReader inputDiaryContent=new BufferedReader(
							new FileReader("diaryRecord/diaryRecord.dat"));
		    		String get="",temp="";                 
		    		
		    		do{
		    			temp=inputDiaryContent.readLine();
		    		    if(temp.equals(title)){
		    			    do{
		    			      temp=inputDiaryContent.readLine();
		    			      get+=" "+temp;
		    			    }while(!temp.equals(""));
		    			    break;
		    		    }
		    		}while(true);

		    		contentArea.setText(get);                      
		    		
		    		inputDiaryContent.close();
		    		repaint();
		    		
					readContentIF(s);
					field_PN.setBounds(0,0,450,550);
					add(field_PN);			    	
		    	}			    		    	
				catch(IOException e1){
		    		e1.printStackTrace();
		    	}			     	  
		    }
		    public void mouseEntered(MouseEvent e){          
		    	setCursor(Cursor.HAND_CURSOR);
		    }
		    public void mouseExited(MouseEvent e){           
		    	setCursor(Cursor.DEFAULT_CURSOR);
		    }
	    }
	    
	    public diary(){	
			write_x();
			write_PN.setBounds(0,0,600,700);
			add(write_PN);
			write_PN.setVisible(false);	
			
			cover_x();
			cover_PN.setBounds(0,0,600,700);
			add(cover_PN);       
			
			cata_x();
			cata_PN.setBounds(0,0,600,700);
			add(cata_PN);
			cata_PN.setVisible(false);
			
			
		}
	}
		
	
	public static void main(String[] args) {
		diary main=new diary();
		
		main.setUndecorated(true);
        main.setSize(600,700);
  		main.setTitle("Dear Diary");
  		main.setLocationRelativeTo(null)
  		;
  		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		main.setVisible(true);  
  		
  		main.setResizable(false);
 
	}/*main()*/
	

	static private ImageIcon start=new ImageIcon("image/begin.png");           
	static private ImageIcon exit=new ImageIcon("image/out.png");             
	static private ImageIcon cover=new ImageIcon("image/cover.png");              
	static private ImageIcon Title=new ImageIcon("image/Title.png");      
	static private ImageIcon write=new ImageIcon("image/write.png");      
	static private ImageIcon read=new ImageIcon("image/read.png");        
	static private ImageIcon back=new ImageIcon("image/back.png");     
	static private ImageIcon writeBG=new ImageIcon("image/cover2.png");           
	static private ImageIcon backToCatalog=new ImageIcon("image/back2.png");
	static private ImageIcon saveDiary=new ImageIcon("image/save.png");        
	static private ImageIcon readBG=new ImageIcon("image/cover2.png");              
	static private JTextArea wordField=new JTextArea();                
	static private JTextArea contentArea=new JTextArea();              
	static private JLabel sxw=new JLabel(start);                    
	static private JLabel exit1=new JLabel(exit);                 
	static private JLabel sdf=new JLabel(Title);                  
	static private JLabel wwe=new JLabel(write);                   
	static private JLabel wer=new JLabel(read);                   
	static private JLabel btn1=new JLabel(back);                  //返回主页label
	static private JLabel btn2=new JLabel(backToCatalog);              
	static private JLabel btn3=new JLabel(backToCatalog);            
	static private JLabel btn4=new JLabel(backToCatalog);             
	static private JLabel qw=new JLabel(saveDiary);                    
	static private JLabel diaryTitle_t=new JLabel("");              
	static private Font diaryFont=new Font("Serif",0,15);              
	static private Font TitleFont=new Font("Serif",1,20);        
	static private JScrollPane scroll=new JScrollPane(contentArea);
	static private JScrollPane scroll_2=new JScrollPane(wordField); 
}