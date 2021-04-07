package com.assignment4.presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.assignment4.business.MenuItem;
import com.assignment4.business.Order;
import com.assignment4.business.Restaurant;
import com.assignment4.data.FileWriter;

public class WaiterGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	public JTable tabel1;
	public JTable tabelCopie;

	public DefaultTableModel tableModel1 = new DefaultTableModel();
	int i = 0;
	private JLabel l1 = new JLabel("  Nr. Order:");
	private JLabel l2 = new JLabel("  Data:");
	private JLabel l3 = new JLabel("  Nr. masa:");
	private JLabel l4 = new JLabel("Alege produsele pentru Order:");
	private JButton b1 = new JButton("Incarca Order");
	private JButton b2 = new JButton("Generare bon fiscal");
	private JTextField t1 = new JTextField();
	private JTextField t2 = new JTextField();
	private JTextField t3 = new JTextField();
	private AdministratorGUI administrator;
	FileWriter f = new FileWriter();
	JPanel panel2 = new JPanel();
	public Restaurant restaurant = new Restaurant();

	Order forBON = new Order();

	public WaiterGUI(Restaurant restaurant) {
		this.restaurant = restaurant;
		administrator = new AdministratorGUI(restaurant);
		JPanel panelM = new JPanel();
		panelM.setLayout(new GridLayout(3, 1));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(8, 2));
		panel1.add(l1);
		panel1.add(t1);
		panel1.add(l2);
		panel1.add(t2);
		panel1.add(l3);
		panel1.add(t3);
		panel1.add(new JLabel());
		panel1.add(b1);
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		panel1.add(b2);
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		panel1.add(l4);

		panel2.setLayout(new GridLayout(1, 1));
		tabelCopie = new JTable(administrator.tableModel);
		panel2.add(new JScrollPane(tabelCopie));
		tabelCopie.setBackground(Color.decode("#a3caff"));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 1));
		tabel1 = new JTable(tableModel1);
		panel3.add(new JScrollPane(tabel1));
		incarcaOrder(" , , , , , , , , , , , , , , , , , , , , , , , , , , ");
		tabel1.setBackground(Color.decode("#BDCAF9"));
		tabel1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabel1.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabel1.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabel1.getColumnModel().getColumn(2).setPreferredWidth(30);
		tabel1.getColumnModel().getColumn(3).setPreferredWidth(328);

		l1.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 20));
		l2.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 20));
		l3.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 20));
		t1.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t2.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t3.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		t1.setBackground(Color.decode("#C6E0F7"));
		t2.setBackground(Color.decode("#C6E0F7"));
		t3.setBackground(Color.decode("#C6E0F7"));

		panelM.add(panel1);
		panelM.add(panel2);
		panelM.add(panel3);
		this.setContentPane(panelM);
		this.setTitle("Ospatar");
		this.setSize(500, 650);
		this.setLocation(490, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addOrderListener();
		addListenerBill();
		revalidate();
	}

	public void incarcaOrder(String s) {
		Vector<String> numeColoana = new Vector<String>();
		numeColoana.add("id");
		numeColoana.add("data");
		numeColoana.add("nr.masa");
		numeColoana.add("Order");
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		this.tableModel1.setDataVector(data, numeColoana);

		for (String val : s.split(",")) {
			Vector<String> row = new Vector<String>();
			row.add(val);
			tableModel1.addRow(row);
		}
	}

	public void ActualizareTabel() {

	}

	public String getId() {
		return t1.getText();
	}

	public String getData() {
		return t2.getText();
	}

	public String getTable() {
		return t3.getText();
	}

	public void computeOrder() {
		tabelCopie.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent event) {
				int selectedRow = tabelCopie.getSelectedRow();
				String next = (String) tabel1.getValueAt(i - 1, 3);
				if (next == null) {
					next = "";
				}
				String products = new String(tabelCopie.getValueAt(selectedRow, 1).toString());
				tabel1.setValueAt(next + products + ", ", i - 1, 3);
				int idOrder = Integer.valueOf(getId());
				int table = Integer.valueOf(getTable());
				String data = getData();
				Order order = new Order();
				order.orderID = idOrder;
				order.data = data;
				order.table = table;
				forBON = order;

				MenuItem item = new MenuItem(products,
						Integer.parseInt(tabelCopie.getValueAt(selectedRow, 2).toString()));

				restaurant.productsOrder.add(item);
				restaurant.createOrder(idOrder, data, table, restaurant.productsOrder);
				restaurant.actualizare();
				restaurant.noteChef= new String();
			}

		});

	}

	public void setOrder() {
		int j = 0;
		tabel1.setValueAt(getId(), i, j);
		j++;
		tabel1.setValueAt(getData(), i, j);
		j++;
		tabel1.setValueAt(getTable(), i, j);
		i++;
	}

	public void addOrderListener() {
		computeOrder();
		b1.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				setOrder();
			}

		});

	}

	public void addListenerBill() {
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				restaurant.generateBill(forBON);

			}

		});
	}
}