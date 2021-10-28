package com.company;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.SpinnerModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import javax.swing.JLabel;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class Main{

    public static void main(String[] args) {
        JFrame f = new JFrame("Basic Map Generator");
        f.setSize(250, 250);
        f.setLocation(300,200);

        final JLabel title = new JLabel("Basic Map Generator");
        f.getContentPane().add(BorderLayout.NORTH, title);

        final JPanel mainPanel = new JPanel(new GridLayout(4, 1));
        f.getContentPane().add(BorderLayout.CENTER, mainPanel);

        final JLabel houseNumberText = new JLabel("Number of Houses:");
        mainPanel.add(BorderLayout.NORTH, houseNumberText);
        final SpinnerModel modelHouseNumber = new SpinnerNumberModel(10, 0, 50, 1);
        final JSpinner spinnerHousesNumber = new JSpinner(modelHouseNumber);
        mainPanel.add(BorderLayout.CENTER, spinnerHousesNumber);

        final JLabel treeNumberText = new JLabel("Number of Trees:");
        mainPanel.add(BorderLayout.NORTH, treeNumberText);
        final SpinnerModel modelTreeNumber = new SpinnerNumberModel(30, 0, 300, 1);
        final JSpinner spinnerTreesNumber = new JSpinner(modelTreeNumber);
        mainPanel.add(BorderLayout.CENTER, spinnerTreesNumber);

        final JLabel houseSizeText = new JLabel("House Size:");
        mainPanel.add(BorderLayout.NORTH, houseSizeText);
        final SpinnerModel modelHouseSize = new SpinnerNumberModel(100, 1, 200, 1);
        final JSpinner spinnerHouseSize = new JSpinner(modelHouseSize);
        mainPanel.add(BorderLayout.CENTER, spinnerHouseSize);

        final JLabel treeSizeText = new JLabel("Tree Size:");
        mainPanel.add(BorderLayout.NORTH, treeSizeText);
        final SpinnerModel modelTreeSize = new SpinnerNumberModel(50, 1, 100, 1);
        final JSpinner spinnerTreeSize = new JSpinner(modelTreeSize);
        mainPanel.add(BorderLayout.CENTER, spinnerTreeSize);

        final JButton button = new JButton("Generate");
        f.getContentPane().add(BorderLayout.SOUTH, button);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Map map = new Map();
                    map.setNumberOfHouses(9);
                    map.setNumberOfTrees(42);

                    map.setHouseSize(450);
                    map.setTreeSize(125);
                    map.setFilename("map.png");

                    map.generateMap();
                } catch (IOException exception) {
                    title.setText("Map unable to generate.");
                }
            }
        });

        f.setVisible(true);
    }
}
