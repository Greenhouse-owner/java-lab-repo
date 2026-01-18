package src.ui;

import javax.swing.*;
import java.awt.*;

// 主窗口类
public class MainJFrame extends JFrame {
    private CreateJPanel createJPanel;
    private ViewJPanel viewJPanel;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton createBtn;
    private JButton viewBtn;
    
    public MainJFrame() {
        initializeComponents();
    }
    
    private void initializeComponents() {
        // 设置窗口基本属性
        setTitle("Product Manager - MVC Version");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示
        
        // 创建左侧按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        createBtn = new JButton("Create");
        viewBtn = new JButton("View");
        
        createBtn.addActionListener(e -> cardLayout.show(mainPanel, "CREATE"));
        viewBtn.addActionListener(e -> cardLayout.show(mainPanel, "VIEW"));
        
        buttonPanel.add(createBtn);
        buttonPanel.add(viewBtn);
        
        // 创建卡片布局的主面板
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // 初始化面板
        createJPanel = new CreateJPanel();
        viewJPanel = new ViewJPanel();
        
        // 将面板添加到卡片布局中
        mainPanel.add(createJPanel, "CREATE");
        mainPanel.add(viewJPanel, "VIEW");
        
        // 默认显示创建面板
        cardLayout.show(mainPanel, "CREATE");
        
        // 添加监听器，当创建面板提交产品时更新展示面板
        createJPanel.setProductCreationListener(viewJPanel::displayProduct);
        
        // 设置整体布局为左右分割
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, mainPanel);
        splitPane.setDividerLocation(100); // 设置分隔条初始位置
        splitPane.setDividerSize(5);
        add(splitPane);
    }
    
    public static void main(String[] args) {
        // Swing组件要在事件调度线程中运行
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            MainJFrame app = new MainJFrame();
            app.setVisible(true);
        });
    }
}