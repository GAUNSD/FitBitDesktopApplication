package ca.uwo.csd.cs2212.team10;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout;
import java.awt.BorderLayout; 

public class MapLocationSetWindow extends JFrame {

    private JTextField locationName;
    private JLabel info;
    private JButton btnSearch;
    private JButton btnSave;
    private Map map;
    private Location location;  

    public MapLocationSetWindow(Map map) {
        this.map = map;
        this.initUI();
    }

    private void initUI () {
        this.setTitle("Set Current Location");
        this.setSize(400, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.add(this.createForm(), BorderLayout.CENTER);
    }

    private JPanel createForm() {

        JPanel panel = new JPanel();
        JLabel lblName = new JLabel("Location:");

        locationName = new JTextField();
        locationName.setPreferredSize(new Dimension(75,25));

        btnSearch = new JButton("Search");
        btnSave  = new JButton("Save");

        info = new JLabel(); 

        //ButtonGroup buttons = new ButtonGroup();
        //buttons.add(this.btnSearch);

        btnSearch.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent event) {
                try {
                    location = map.getNewLocation(locationName.getText());
                    info.setIcon(new ImageIcon(location.getLocationImage()));
                } catch (Exception e) {
                    String msg = "An error occured. Please try again later.";
                    info.setText(msg);
                }
            }
        });
        btnSave.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent event) {
                try {
                    if(locationName.getText().equals("")) map.setCurrentLocation(map.getCurrentLocation());
                    else map.setCurrentLocation(location);
                    MapLocationSetWindow.super.setVisible(false);
                    MapLocationSetWindow.super.dispose();
                } catch (Exception e) {
                    String msg = "An error occured. Please try again later.";
                    info.setText(msg);
                    MapLocationSetWindow.super.setVisible(false);
                    MapLocationSetWindow.super.dispose(); 
                }
            }
        });

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup( layout.createSequentialGroup()
                .addGroup( layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            )
                        .addGroup( layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(locationName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                )
                            )
                        )
                    .addComponent(info)
                    )
                .addComponent(btnSave) );
        layout.setVerticalGroup( layout.createSequentialGroup()
                .addGroup( layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(locationName)
                    )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(info)
                    .addComponent(btnSave)
                    )
                );

        panel.setLayout(layout);

        return panel;
    }


}
