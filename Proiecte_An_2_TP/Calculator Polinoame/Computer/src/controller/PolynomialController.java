package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Model.*;
import view.*;

public class PolynomialController {
	private PolynomFrame view;
	private Polinom polinomP = new Polinom();
	private Polinom polinomQ = new Polinom();
	private Operatii operatie = new Operatii();

	public PolynomialController() {
		view = new PolynomFrame();
		displayPolynomFrame();
	}

	private void displayPolynomFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.showPolynomFrame();
				addAdditionPanelButtonAction();
				addSubstractPanelButtonAction();
				addDerivativePanelButtonAction();
				addMutliplicationPanelButtonAction();
				addFindValuePanelButtonAction();
			}
		});
	}

	private void displayAdditionPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.showAdditionPanel();
				addAdditionPanelBackActionPanel();
				addAdditionAddButtonAction();
				addAdditionPanelResetActionPanel();

			}
		});
	}

	private void displaySubstractionFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.showSubstractionPanel();
				addSubstractionPanelBackActionPanel();
				addSubstractSubstractionButtonAction();
				addSubstractPanelResetActionPanel();
			}
		});
	}

	public void displayDerivativeFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.showDerivativePanel();
				addDerivativePanelBackActionPanel();
				addDerivativeButtonAction();
				addDerivativePanelResetActionPanel();
			}
		});
	}

	public void displayMultiplicationPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.showMultimplicationPanel();
				addMultiplicationPanelBackActionPanel();
				addMultiplyAddButtonAction();
				addMultiplicationPanelResetActionPanel();
			}
		});

	}

	public void displayFindValuePanel() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				view.showFindValuePanel();
				addFindValuePanelBackActionPanel();
				addFindValueAddButtonAction();
				addFindValuePanelResetActionPanel();
			}
		});

	}

	private void addAdditionPanelBackActionPanel() {
		view.getAdditionPanel().addBackButtonAction(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				displayPolynomFrame();
			}
		});
	}

	private void addAdditionPanelResetActionPanel() {
		view.getAdditionPanel().addResetButtonAction(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getAdditionPanel().setPolinom1TextField(null);
				view.getAdditionPanel().setPolinom2TextField(null);
				view.getAdditionPanel().setSumTextField(null);
				polinomP.reset();
				polinomQ.reset();
			}
		});
	}
	private void addSubstractPanelResetActionPanel() {
		view.getSubstractionPanel().addResetAction(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getSubstractionPanel().setPolinom1TextField(null);
				view.getSubstractionPanel().setPolinom2TextField(null);
				view.getSubstractionPanel().setSubTextField(null);
				polinomP.reset();
				polinomQ.reset();
			}
		});
	}
	private void addDerivativePanelResetActionPanel() {
		view.getDerivativePanel().addResetButtonAction(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getDerivativePanel().setPolinomTextField(null);
				view.getDerivativePanel().setDerivativeTextField(null);
				polinomP.reset();
				polinomQ.reset();
			}
		});
	}
	private void addMultiplicationPanelResetActionPanel() {
		view.getMultiplicationPanel().addResetButtonAction(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getMultiplicationPanel().setPolinom1TextField(null);
				view.getMultiplicationPanel().setPolinom2TextField(null);
				view.getMultiplicationPanel().setMulTextField(null);
				polinomP.reset();
				polinomQ.reset();
			}
		});
	}
	private void addFindValuePanelResetActionPanel() {
		view.getFindValuePanel().addResetButtonAction(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getFindValuePanel().setPolinom1TextField(null);
				view.getFindValuePanel().setFindValueTextField(0);
				polinomP.reset();
				polinomQ.reset();
			}
		});
	}

	private void addAdditionPanelButtonAction() {
		view.getPolynomFrame().addAdditionButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAdditionPanel();
			}
		});
	}

	private void addSubstractionPanelBackActionPanel() {
		view.getSubstractionPanel().addBackButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPolynomFrame();
			}
		});
	}

	private void addSubstractPanelButtonAction() {
		view.getPolynomFrame().addSubstractionButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaySubstractionFrame();
			}
		});
	}

	private void addDerivativePanelButtonAction() {
		view.getPolynomFrame().addDerivativeButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDerivativeFrame();
			}
		});
	}

	private void addDerivativePanelBackActionPanel() {
		view.getDerivativePanel().addBackButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPolynomFrame();
			}
		});
	}

	private void addMutliplicationPanelButtonAction() {
		view.getPolynomFrame().addMultiplicationButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayMultiplicationPanel();
			}
		});
	}

	private void addMultiplicationPanelBackActionPanel() {
		view.getMultiplicationPanel().addBackButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPolynomFrame();
			}
		});
	}

	private void addFindValuePanelBackActionPanel() {
		view.getFindValuePanel().addBackButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPolynomFrame();
			}
		});
	}

	private void addFindValuePanelButtonAction() {
		view.getPolynomFrame().addFindValueButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayFindValuePanel();
			}
		});
	}

	public Polinom readFromJTextField(String Polinom) {
		Polinom polinom = new Polinom();
		Monom m;
		int coeficient = 0;
		int power = 0;
		String[] numbersP = Polinom.replace("^", "").split("((?=\\+)|(?=\\-)|x)");
		int i = 0;
		do {
			coeficient = Integer.parseInt(numbersP[i]);
			power = Integer.parseInt(numbersP[i + 1]);
			m = new Monom(coeficient, power);
			polinom.addMonom(m);
			i += 2;

		} while (i < numbersP.length);
		return polinom;
	}

	private void addAdditionAddButtonAction() {
		view.getAdditionPanel().addSumButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					polinomP.reset();
					polinomQ.reset();
					String stringPolinomP = view.getAdditionPanel().getPolinom1TextField().getText().toString();
					String stringPolinomQ = view.getAdditionPanel().getPolinom2TextField().getText().toString();
					polinomP = readFromJTextField(stringPolinomP);
					polinomQ = readFromJTextField(stringPolinomQ);
					
					view.getAdditionPanel().setSumTextField(operatie.addition(polinomP, polinomQ).toString());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Polinoamele trebuie sa fiu de forma anx^bn+...+a1x^1+a0x^0 ");
				}
				;
			}
		});
	}
	private void addSubstractSubstractionButtonAction() {
		view.getSubstractionPanel().addSubstractAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					polinomP.reset();
					polinomQ.reset();
					String stringPolinomP = view.getSubstractionPanel().getPolinom1TextField().getText().toString();
					String stringPolinomQ = view.getSubstractionPanel().getPolinom2TextField().getText().toString();
					polinomP = readFromJTextField(stringPolinomP);
					polinomQ = readFromJTextField(stringPolinomQ);
					view.getSubstractionPanel().setSubTextField(operatie.substraction(polinomP, polinomQ).toString());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Polinoamele trebuie sa fiu de forma anx^bn+...+a1x^1+a0x^0 ");
				}
				;
			}
		});
	}
	private void addDerivativeButtonAction() {
		view.getDerivativePanel().addDerivativeButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					polinomP.reset();
				
					String stringPolinomP = view.getDerivativePanel().getPolinomTextField().getText().toString();
					polinomP = readFromJTextField(stringPolinomP);
					
					view.getDerivativePanel().setDerivativeTextField(operatie.derivate(polinomP).toString());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Polinoamele trebuie sa fiu de forma anx^bn+...+a1x^1+a0x^0 ");
				}
				;
			}
		});
	}
	private void addMultiplyAddButtonAction() {
		view.getMultiplicationPanel().addMulButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					polinomP.reset();
					polinomQ.reset();
					String stringPolinomP = view.getMultiplicationPanel().getPolinom1TextField().getText().toString();
					String stringPolinomQ = view.getMultiplicationPanel().getPolinom2TextField().getText().toString();
					polinomP = readFromJTextField(stringPolinomP);
					polinomQ = readFromJTextField(stringPolinomQ);
					
					view.getMultiplicationPanel().setMulTextField(operatie.multiplication(polinomP, polinomQ).toString());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Polinoamele trebuie sa fiu de forma anx^bn+...+a1x^1+a0x^0 ");
				}
				;
			}
		});
	}
	private void addFindValueAddButtonAction() {
		view.getFindValuePanel().addFindValueButtonAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					polinomP.reset();
					String stringPolinomP = view.getFindValuePanel().getPolinom1TextField().getText().toString();
					String stringValue = view.getFindValuePanel().getValueTextField().getText();
					int value = Integer.parseInt(stringValue);
					polinomP = readFromJTextField(stringPolinomP);
					
					view.getFindValuePanel().setFindValueTextField(operatie.findValue(polinomP, value));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Polinoamele trebuie sa fiu de forma anx^bn+...+a1x^1+a0x^0 ");
				}
				;
			}
		});
	}

}
