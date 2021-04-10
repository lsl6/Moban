package src.ch7.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;

import ch7.data.musicStuff;
import ch7.view.HandleMove;
import ch7.view.PuzzlePad;
public class AppWindow extends JFrame implements ActionListener{
PuzzlePad puzzlePad;
JMenuBar bar;
JMenu gradeMenu, choiceImage;
JMenuItem oneGrade,twoGrade,threeGrade,fourGrade,fiveGrade,sixGrade,newImage,defaultImage;
JRadioButton digitPlay,imagePlay;
ButtonGroup group = null;
JButton startButton;
Image image;
Toolkit tool;

public AppWindow() {

	tool = getToolkit();
	bar = new JMenuBar();
	gradeMenu = new JMenu("选择级别:");
	choiceImage = new JMenu("选择图像");
	oneGrade = new JMenuItem("初级");
	twoGrade = new JMenuItem("中级");
	threeGrade = new JMenuItem("高级");
	fourGrade = new JMenuItem("究级");
	fiveGrade = new JMenuItem("地狱级");
	sixGrade = new JMenuItem("林紫曦级");
	newImage = new JMenuItem("选择一幅新图像");
	defaultImage = new JMenuItem("ʹ使用默认图像");
	gradeMenu.add(oneGrade);
	gradeMenu.add(twoGrade);
	gradeMenu.add(threeGrade);
	gradeMenu.add(fourGrade);
	gradeMenu.add(fiveGrade);
	gradeMenu.add(sixGrade);
	choiceImage.add(newImage);
	choiceImage.add(defaultImage);
	bar.add(gradeMenu);
	bar.add(choiceImage);
	setJMenuBar(bar);
	oneGrade.addActionListener(this);
	twoGrade.addActionListener(this);
	threeGrade.addActionListener(this);
	fourGrade.addActionListener(this);
	fiveGrade.addActionListener(this);
	sixGrade.addActionListener(this);
	newImage.addActionListener(this);
	defaultImage.addActionListener(this);
	startButton = new JButton("开始");
	startButton.addActionListener(this);
	group = new ButtonGroup();
	digitPlay = new JRadioButton("数字玩法",true);
	imagePlay = new JRadioButton("图像玩法",false);
	group.add(digitPlay);
	group.add(imagePlay);
	puzzlePad= new PuzzlePad();
	puzzlePad.setGrade(1);
	puzzlePad.setIsDigitPlay();
	add(puzzlePad,BorderLayout.CENTER);
	JPanel pNorth = new JPanel();
	pNorth.add(digitPlay);
	pNorth.add(imagePlay);
	pNorth.add(startButton);
	pNorth.add(new JLabel("如果图像不能立刻显示，请再单击一次按钮"));
	add(pNorth,BorderLayout.NORTH);
	add(puzzlePad.getHandleMove(),BorderLayout.SOUTH);
	validate();
	setVisible(true);
	HandleMove.play();
	setBounds(100,50,550,380);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	try {
		image = tool.createImage("C:\\Users\\林紫曦\\Pictures\\Saved Pictures/abc.png");
		puzzlePad.setImage(image);
	}
	catch(Exception exp) {}	
}

public void actionPerformed(ActionEvent e) {  
	if(e.getSource() == startButton) {
		
		
		if(digitPlay.isSelected()) {
			puzzlePad.setIsDigitPlay();
		}else if(imagePlay.isSelected()) {
			puzzlePad.setImage(image);
			puzzlePad.setIsImagePlay();
		}
	}
	else if(e.getSource() == oneGrade) {
		puzzlePad.setGrade(1);
	}
	else if(e.getSource() == twoGrade) {
     	puzzlePad.setGrade(2); 
	}
	else if(e.getSource() == threeGrade) {
		puzzlePad.setGrade(3);
	}
	else if(e.getSource() == fourGrade) {
		puzzlePad.setGrade(4);
	}
	else if(e.getSource() == fiveGrade) {
		puzzlePad.setGrade(5);
	}
	else if(e.getSource() == sixGrade) {
		puzzlePad.setGrade(6);
	}
	else if(e.getSource() == newImage) {

		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images","jpg","gif");
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(filter);
		int state = chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		if(file!=null && state == JFileChooser.APPROVE_OPTION) {
			try {
				image = tool.createImage(file.toURL());
				puzzlePad.setImage(image);
			}
			catch(Exception exp) {}
		}
	}
	else if(e.getSource()==defaultImage) {

		try {
			image = tool.createImage("C:\\Users\\林紫曦\\Pictures\\Saved Pictures/abc.png");
			puzzlePad.setImage(image);
		}
		catch(Exception exp) {}
	}
}
public static void main(String args[]) {

	String filepath = "C:\\Users\\林紫曦\\Music/demo.wav";
	musicStuff musicObject = new musicStuff();
	musicObject.playMusic(filepath);

	new AppWindow(); }

}
