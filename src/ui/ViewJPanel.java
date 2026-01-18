package src.ui;

import src.model.Product;
import javax.swing.*;
import java.awt.*;

// 产品展示面板
public class ViewJPanel extends JPanel {
    private JTextArea taDisplay = new JTextArea(20, 30);
    
    public ViewJPanel() {
        initializeComponents();
    }
    
    private void initializeComponents() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Product Details"));
        
        taDisplay.setEditable(false); // 不可编辑
        add(new JScrollPane(taDisplay), BorderLayout.CENTER);
    }
    
    // 显示产品信息
    public void displayProduct(Product product) {
        if (product != null) {
            taDisplay.setText(product.toString());
        } else {
            taDisplay.setText("");
        }
    }
}