package src.ui;

import src.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 产品创建面板
public class CreateJPanel extends JPanel {
    // 产品基本信息组件
    private JTextField tfName = new JTextField(15);
    private JTextArea taDescription = new JTextArea(3, 15);
    private JTextField tfAvailNum = new JTextField(15);
    private JTextField tfPrice = new JTextField(15);

    // 生产地址组件
    private JTextField tfManuStreet = new JTextField(15);
    private JTextField tfManuUnit = new JTextField(15);
    private JTextField tfManuCity = new JTextField(15);
    private JTextField tfManuZip = new JTextField(15);

    // 发货地址组件
    private JTextField tfShipStreet = new JTextField(15);
    private JTextField tfShipUnit = new JTextField(15);
    private JTextField tfShipCity = new JTextField(15);
    private JTextField tfShipZip = new JTextField(15);
    
    // 产品创建监听器
    private ProductCreationListener listener;
    
    public CreateJPanel() {
        initializeComponents();
    }
    
    private void initializeComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Enter Product Information"));

        // 产品基本信息面板
        JPanel productPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        productPanel.add(new JLabel("Product Name:"));
        productPanel.add(tfName);
        productPanel.add(new JLabel("Description:"));
        productPanel.add(new JScrollPane(taDescription)); // 滚动面板包裹文本域
        productPanel.add(new JLabel("Available Quantity:"));
        productPanel.add(tfAvailNum);
        productPanel.add(new JLabel("Price ($):"));
        productPanel.add(tfPrice);

        // 生产地址面板
        JPanel manuAddrPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        manuAddrPanel.setBorder(BorderFactory.createTitledBorder("Manufacture Address"));
        manuAddrPanel.add(new JLabel("Street Name:"));
        manuAddrPanel.add(tfManuStreet);
        manuAddrPanel.add(new JLabel("Unit Number:"));
        manuAddrPanel.add(tfManuUnit);
        manuAddrPanel.add(new JLabel("City:"));
        manuAddrPanel.add(tfManuCity);
        manuAddrPanel.add(new JLabel("ZIP Code:"));
        manuAddrPanel.add(tfManuZip);

        // 发货地址面板
        JPanel shipAddrPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        shipAddrPanel.setBorder(BorderFactory.createTitledBorder("Shipping Address"));
        shipAddrPanel.add(new JLabel("Street Name:"));
        shipAddrPanel.add(tfShipStreet);
        shipAddrPanel.add(new JLabel("Unit Number:"));
        shipAddrPanel.add(tfShipUnit);
        shipAddrPanel.add(new JLabel("City:"));
        shipAddrPanel.add(tfShipCity);
        shipAddrPanel.add(new JLabel("ZIP Code:"));
        shipAddrPanel.add(tfShipZip);

        // 保存按钮
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new SaveButtonListener());

        // 将所有组件添加到面板
        add(productPanel);
        add(Box.createVerticalStrut(10)); // 间距
        add(manuAddrPanel);
        add(Box.createVerticalStrut(10));
        add(shipAddrPanel);
        add(Box.createVerticalStrut(10));
        add(btnSave);
    }

    // 提交按钮的事件监听器
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            submitProduct();
        }
    }
    
    // 提交产品的方法
    private void submitProduct() {
        try {
            // 1. 收集表单数据
            String name = tfName.getText().trim();
            String description = taDescription.getText().trim();
            int availNum = Integer.parseInt(tfAvailNum.getText().trim());
            double price = Double.parseDouble(tfPrice.getText().trim());

            // 2. 收集生产地址数据
            Address manuAddr = new Address(
                    tfManuStreet.getText().trim(),
                    tfManuUnit.getText().trim(),
                    tfManuCity.getText().trim(),
                    tfManuZip.getText().trim()
            );

            // 3. 收集发货地址数据
            Address shipAddr = new Address(
                    tfShipStreet.getText().trim(),
                    tfShipUnit.getText().trim(),
                    tfShipCity.getText().trim(),
                    tfShipZip.getText().trim()
            );

            // 4. 创建Product实例
            Product product = new Product(name, description, availNum, price, manuAddr, shipAddr);

            // 5. 调用监听器传递产品信息
            if (listener != null) {
                listener.onProductCreated(product);
            }

        } catch (NumberFormatException ex) {
            // 处理数字格式错误
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for Quantity and Price!",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            // 其他异常
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // 设置产品创建监听器
    public void setProductCreationListener(ProductCreationListener listener) {
        this.listener = listener;
    }
    
    // 产品创建监听器接口
    public interface ProductCreationListener {
        void onProductCreated(Product product);
    }
}