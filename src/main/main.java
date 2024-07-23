
package main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.UIManager;
import view.FrmAcceso;
import temp.FrmLogin;

public class main {

    public static void main(String[] args) {
        try {
            FlatLaf.registerCustomDefaultsSource( "Icons" );
            FlatLightLaf.setup();
            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
        } catch (Exception e) {
            System.out.println(e);
        } 
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
             new FrmAcceso().setVisible(true);
            }
        });
    }
    
}
