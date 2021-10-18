/**  
* @Title: AwtBtnListenerLambdaDemo.java
* @Package com.osxm.je.base.lambda
* @Description: TODO
* @author XM
* @date 2021年9月13日 下午10:09:49
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.je.base.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

/**
 * @ClassName AwtBtnListenerLambdaDemo
 * @Description TODO
 * @author XM 
 * @date 2021年9月13日
 * 
 */
public class AwtBtnListenerLambdaDemo extends JFrame{

	public AwtBtnListenerLambdaDemo(String str) {
		super(str);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AwtBtnListenerLambdaDemo frame = new AwtBtnListenerLambdaDemo("Hello");
		JPanel panel = new JPanel();
		panel.setSize(200, 200);
		//1. 传统写法
		JButton btn1 = new JButton("My Button");		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btnListener: without lambda expression");
			}
		});
		
		//2. Lambda 写法
		JButton btn2 = new JButton("Button Listener use Lambda");		
		btn2.addActionListener((e) -> {System.out.println("btnListener: use lambda expression");});
		
		panel.add(btn1);	
		panel.add(btn2);	
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

}
