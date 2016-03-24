package ca.uwo.csd.cs2212.team10;

import java.awt.event.*;
import java.awt.Color; 
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import org.json.JSONException; 

/**
 * This class allows the user to set their current location
 * @author Conor
 */
public class MapLocationSetWindow extends JFrame {

    private Map map;
    private JTextField locationName; 
    private JLabel info;
    private Location location = null;


    /**
     * Main constructor
     * @param map Map that is passed into frame
     */
    public MapLocationSetWindow(Map map) {
        this.map = map;
        this.initUI();
    }

    /**
     * Method initialises the UI
     */
    private void initUI() {
        this.setTitle("Set Current Location");
        this.setBackground(new Color(55,55,55));
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 

        this.setLayout(new BorderLayout());
        this.add(this.createForm(), BorderLayout.CENTER);
    }

    private JPanel createForm() {

        info = new JLabel(); 


        JPanel panel = new JPanel();
        JLabel name = new JLabel("Enter Location : ");

        locationName = new JTextField();
        locationName.setPreferredSize(new Dimension(25,25));

        JButton btnSearch = new JButton("Search");
        JButton btnSave = new JButton("Save");

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    location = map.getNewLocation(locationName.getText());
                    info.setIcon((new ImageIcon(location.getLocationImage())));
                } catch (Exception e) { 
                    String msg = "An error occured. Please try again later.";
                    info.setText(msg);
                }
            }
        });
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    if(location != null) {
                        map.setCurrentLocation(location);
                        System.exit(0);
                    }
                } catch (Exception e) {
                    String msg = "An error occured. Please try again later.";
                    info.setText(msg);
                    System.exit(0);
                }
                System.exit(0);
            }
        });

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(name)
                            .addComponent(new JLabel(" "))
                            )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(locationName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addComponent(btnSave)
                                )
                            )
                        )
                    .addComponent(info)
                    )
                );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(locationName)
                    )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnSave)
                    )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(info)
                    )
                );
        panel.setLayout(layout);

        return panel;
    }
}














