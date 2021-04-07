package com.assignment4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.assignment4.business.BaseProduct;
import com.assignment4.business.MenuItem;
import com.assignment4.business.Restaurant;
import com.assignment4.data.FileWriter;

public class AdministratorGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	public JTable menuTable;
	public DefaultTableModel tableModel = new DefaultTableModel();
	private JButton editButton = new JButton("Salvare editare");
	private JButton deleteButton = new JButton("Stergere produs");
	private JButton addProductButton = new JButton("Base Product");
	private JButton addCompositeProductButton = new JButton("Composite Product");

	private JLabel nameLabel = new JLabel("Denumire:");
	private JLabel priceLabel = new JLabel("Price:");
	private JLabel ingredientsLabel = new JLabel("Ingredients");
	private JTextField addIngredientsTextField = new JTextField();
	private JTextField addTextField = new JTextField();
	private JTextField addPriceTextField = new JTextField();
	public Restaurant restaurant;
	private FileWriter file;

	public AdministratorGUI(Restaurant restaurant) {
		this.file = new FileWriter();

		this.restaurant = restaurant;
		JPanel panelMenu = new JPanel();
		JPanel panelActions = new JPanel();
		panelMenu.setLayout(new GridLayout(1, 1));
		panelActions.setLayout(new GridLayout(1, 1));
		menuTable = new JTable(tableModel);
		panelActions.add(new JScrollPane(menuTable));
		menuTable.setBackground(Color.decode("#ABEEB5"));
		tableModel.addColumn("ID");
		tableModel.addColumn("Products");
		tableModel.addColumn("Price: USD");
		tableModel.addColumn("Ingredients");

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(20, 10));
		panel2.add(editButton);
		panel2.add(deleteButton);

		panel2.add(new JLabel());

		panel2.add(nameLabel);
		panel2.add(addTextField);

		panel2.add(new JLabel());
		panel2.add(ingredientsLabel);
		panel2.add(addIngredientsTextField);
		panel2.add(new JLabel());
		panel2.add(priceLabel);

		panel2.add(addPriceTextField);
		panel2.add(addProductButton);
		panel2.add(addCompositeProductButton);

		nameLabel.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		priceLabel.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));

		addTextField.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		addIngredientsTextField.setFont(new Font("Sitka Banner", Font.PLAIN, 15));
		addTextField.setBackground(Color.decode("#C6F7CE"));
		addPriceTextField.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		addPriceTextField.setBackground(Color.decode("#C6F7CE"));
		panelMenu.add(panelActions);
		panelMenu.add(panel2);
		this.setContentPane(panelMenu);
		this.setTitle("Administrator");
		this.setSize(900, 600);
		this.setLocation(100, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		restaurant.meniu = file.citesteItem();
		addProducts(restaurant.meniu);
		addBaseProductButtonListener();
		addCompositeProductButtonListener();
		addDeleteButtonListener();
		addEditButtonListener();
		revalidate();
	}

	public void addProducts(List<MenuItem> item) {
		for (MenuItem i : item) {
			tableModel.addRow(new Object[] { tableModel.getRowCount(), i.getName(), i.getPrice(), '-' });
		}
	}

	public void showError(String mesajEroare) {
		JOptionPane.showMessageDialog(this, mesajEroare);
	}

	public void addBaseProductButtonListener() {
		addProductButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				restaurant.addBaseProduct(addTextField.getText(), Integer.parseInt(addPriceTextField.getText()));
				tableModel.addRow(new Object[] { tableModel.getRowCount(), addTextField.getText(),
						Integer.parseInt(addPriceTextField.getText()) , "-" });
				file.scrieItem(restaurant.meniu);
			}
			
		});

	}

	public void addCompositeProductButtonListener() {
		addCompositeProductButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> ingredients = new ArrayList<String>();
				ArrayList<BaseProduct> loadIngredients = new ArrayList<BaseProduct>();
				for (String ing : addIngredientsTextField.getText().split(", ")) {
					BaseProduct product = new BaseProduct(ing);
					ingredients.add(ing);
					loadIngredients.add(product);
				}
				restaurant.addCompositeProduct(addTextField.getText(), loadIngredients,
						Integer.parseInt(addPriceTextField.getText()));
				tableModel.addRow(new Object[] { tableModel.getRowCount(), addTextField.getText(),
						Integer.parseInt(addPriceTextField.getText()), ingredients.toString() });
				file.scrieItem(restaurant.meniu);
			}

		});
	}
	public void addEditButtonListener() {
		menuTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int selectedRow = menuTable.getSelectedRow();
				String name = new String(tableModel.getValueAt(selectedRow, 1).toString());
				int priceFromRow = Integer.parseInt(tableModel.getValueAt(selectedRow, 2).toString());
				editButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						restaurant.editProduct(new MenuItem(name, priceFromRow), name, priceFromRow);
						file.scrieItem(restaurant.meniu);
					}

				});
			}
		});

	}

	public void addDeleteButtonListener() {
		menuTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int selectedRow = menuTable.getSelectedRow();
				deleteButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						MenuItem deletedProduct = new MenuItem(tableModel.getValueAt(selectedRow, 1).toString(),
								Integer.parseInt(tableModel.getValueAt(selectedRow, 2).toString()));

						restaurant.deleteProduct(deletedProduct);
						tableModel.removeRow(selectedRow);
						file.scrieItem(restaurant.meniu);
					}

				});
			}
		});
	}
}