/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jay
 */
public class Update implements ActionListener{	
         
        @Override
		public void actionPerformed(ActionEvent arg0) {
                    main.accounts.removeAll();
                    Connect con=new Connect();
                    int [] idAry=con.allIds();
                    
                    int noOfAccounts=idAry.length;
        
                    main.accounts.setLayout(new GridLayout(15, 1));//setlayout
        
                    Account_panel []a=new Account_panel[noOfAccounts];
        
                    for(int j=0;j<noOfAccounts;j++){
                        a[j]=new Account_panel("facebook",idAry[j]);
                        
                        main.accounts.add(a[j]);
                    }
                    main.accounts.revalidate();
                 }
     }
