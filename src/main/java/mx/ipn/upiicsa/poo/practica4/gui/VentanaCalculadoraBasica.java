package mx.ipn.upiicsa.poo.practica4.gui;


import mx.ipn.upiicsa.poo.practica4.bs.Calculadora;
import mx.ipn.upiicsa.poo.practica4.exception.DivZeroException;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaCalculadoraBasica extends JPanel {
	
	private static final long serialVersionUID = 1L;
	protected JTextField display;
	protected JButton button0;
	protected JButton button1;
	protected JButton button2;
	protected JButton button3;
	protected JButton button4;
	protected JButton button5;
	protected JButton button6;
	protected JButton button7;
	protected JButton button8;
	protected JButton button9;
	protected JButton buttonPunto;
	protected JButton buttonLimpiar;
	protected JButton buttonPorcentaje;
	protected JButton buttonDivision;
	protected JButton buttonProducto;
	protected JButton buttonSuma;
	protected JButton buttonResta;
	protected JButton buttonIgual;

	protected static final Integer CERO = 0;
	protected static final Integer UNO = 1;
	protected static final Integer DOS = 2;
	protected static final Integer TRES = 3;
	protected static final Integer CUATRO = 4;
	protected static final Integer CINCO = 5;
	protected static final Integer SEIS = 6;
	protected static final Integer SIETE = 7;
	protected static final Integer OCHO = 8;
	protected static final Integer NUEVE = 9;
	protected static final String PUNTO = ".";
	protected static final String EMPTY_STRING = "";
	private static final String M_ERROR = "MATH ERROR";
	private static final String S_ERROR = "SINTAX ERROR";
	protected static final int STATE_INITIAL = 0;
	protected static final int STATE_CAPTURE = 1;
	protected static final int STATE_OPERATOR = 2;
	protected static final int STATE_CALCULATE = 3;

	protected static final int ACTION_NUMBER = 0;
	protected static final int ACTION_OPERATOR = 1;
	protected static final int ACTION_EQUAL = 2;
	protected static final int ACTION_CLEAN = 3;

	protected int state;
	protected Double valor1;
	protected Double valor2;
	protected Double resultado;
	protected Calculadora calculadora;
	protected int operator;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Double getValor1() {
		return valor1;
	}

	public void setValor1(Double valor1) {
		this.valor1 = valor1;
	}

	public Double getValor2() {
		return valor2;
	}

	public void setValor2(Double valor2) {
		this.valor2 = valor2;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public VentanaCalculadoraBasica() {
		state = STATE_INITIAL;
		calculadora = new Calculadora();
		initComponents();

	}

	public void initComponents() {
		instantiateComponents();
		buildGrid();
		initializeListener();
	}

	protected void initializeListener() {

		button0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(CERO.toString());

			}
		});

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(UNO.toString());

			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(DOS.toString());

			}
		});

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(TRES.toString());

			}
		});

		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(CUATRO.toString());

			}
		});

		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(CINCO.toString());

			}
		});

		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(SEIS.toString());

			}
		});

		button7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(SIETE.toString());

			}
		});

		button8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(OCHO.toString());

			}
		});

		button9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(NUEVE.toString());

			}
		});

		buttonPunto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarNumero(PUNTO);

			}
		});

		buttonLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarDisplay();
				actualizarEstado(ACTION_CLEAN);

			}
		});

		buttonSuma.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_SUMA);

			}
		});

		buttonResta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_RESTA);

			}
		});

		buttonProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_PRODUCTO);

			}
		});

		buttonDivision.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_DIVISION);

			}
		});

		buttonPorcentaje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_PORCENTAJE);

			}
		});

		buttonIgual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarEstado(ACTION_EQUAL);
				actualizarDisplay("");
			}
		});

	}

	protected void limpiarDisplay() {
		display.setText(EMPTY_STRING);

	}

	protected void buildGrid() {

		GridBagLayout calculadoraGrid = new GridBagLayout();
		GridBagConstraints calculadoraGridContraints = new GridBagConstraints();
		setLayout(calculadoraGrid);
		calculadoraGridContraints.fill = GridBagConstraints.HORIZONTAL;
		calculadoraGridContraints.weightx = 0.5;
		calculadoraGridContraints.ipady = 42;
		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 0;
		calculadoraGridContraints.gridwidth = 4;
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		add(display, calculadoraGridContraints);
		calculadoraGridContraints.gridwidth = 1;

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 1;
		add(buttonLimpiar, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 1;
		add(buttonPorcentaje, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 1;
		add(buttonDivision, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 3;
		calculadoraGridContraints.gridy = 1;
		add(buttonProducto, calculadoraGridContraints);

		//
		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 2;
		add(button7, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 2;
		add(button8, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 2;
		add(button9, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 3;
		calculadoraGridContraints.gridy = 2;
		add(buttonSuma, calculadoraGridContraints);

		//

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 3;
		add(button4, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 3;
		add(button5, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 3;
		add(button6, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 3;
		calculadoraGridContraints.gridy = 3;
		add(buttonResta, calculadoraGridContraints);

		//

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 4;
		add(button1, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 4;
		add(button2, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 4;
		add(button3, calculadoraGridContraints);

		//

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 5;
		calculadoraGridContraints.gridwidth = 2;
		add(button0, calculadoraGridContraints);
		calculadoraGridContraints.gridwidth = 1;

		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 5;
		add(buttonPunto, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 3;
		calculadoraGridContraints.gridy = 4;
		calculadoraGridContraints.gridheight = 2;
		calculadoraGridContraints.ipady = 109;

		add(buttonIgual, calculadoraGridContraints);
		calculadoraGridContraints.ipady = 42;
		calculadoraGridContraints.gridheight = 1;

		setVisible(true);

	}

	protected void instantiateComponents() {
		display = new JTextField("");
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonPunto = new JButton(".");
		buttonLimpiar = new JButton("AC");
		buttonPorcentaje = new JButton("%");
		buttonDivision = new JButton("/");
		buttonProducto = new JButton("x");
		buttonSuma = new JButton("+");
		buttonResta = new JButton("-");
		buttonIgual = new JButton("=");

	}

	protected void capturarNumero(String numero) {

		actualizarDisplay(numero);
		actualizarEstado(ACTION_NUMBER);

	}

	public void capturarOperador(int operator) {

		setOperator(operator);
		actualizarEstado(ACTION_OPERATOR);

	}

	protected void actualizarDisplay(String valor) {
		
		if (state == STATE_INITIAL) {
			display.setText(valor);
		} else if (state == STATE_CAPTURE) {
			String valorActual = display.getText();
			display.setText(valorActual + valor);
		} else if (state == STATE_OPERATOR) {
			String valorString = display.getText();
			display.setText(valor);
			try {
				valor1 = Double.parseDouble(valorString);
			} catch (NumberFormatException e) {
				display.setText(S_ERROR);
				JOptionPane.showMessageDialog(this, S_ERROR);
				actualizarEstado(ACTION_CLEAN);
			}
		} else if (state == STATE_CALCULATE) {
			String resultadoString = null;
			String valorString = display.getText();
			try {
				valor2 = Double.parseDouble(valorString);
				try {
					resultado = calculadora.calculate(operator, valor1, valor2);
					resultadoString = resultado.toString();
				} catch (DivZeroException e) {
					resultadoString = M_ERROR;
					JOptionPane.showMessageDialog(this, "División entre 0");
					actualizarEstado(ACTION_CLEAN);
				} finally {
					display.setText(resultadoString);
					
					actualizarEstado(ACTION_CLEAN);
					valor1 = resultado;
				}
			} catch (NumberFormatException e) {
				display.setText(S_ERROR);
				JOptionPane.showMessageDialog(this, S_ERROR);
				actualizarEstado(ACTION_CLEAN);
			} catch (NullPointerException e) {
				resultadoString = S_ERROR;
				JOptionPane.showMessageDialog(this, "NO");
				actualizarEstado(ACTION_CLEAN);
			}

			display.setText(resultadoString);
		}

	}

	protected void actualizarEstado(int action) {
		if (action == ACTION_CLEAN) {
			state = STATE_INITIAL;
		} else if (state == STATE_INITIAL && action == ACTION_NUMBER || state == STATE_OPERATOR && action == ACTION_NUMBER
				|| state == STATE_CALCULATE && action == ACTION_NUMBER) {
			state = STATE_CAPTURE;
		} else if (state == STATE_CAPTURE && action == ACTION_OPERATOR
				|| state == STATE_CALCULATE && action == ACTION_OPERATOR) {
			state = STATE_OPERATOR;
		} else if (state == STATE_CAPTURE && action == ACTION_EQUAL) {
			state = STATE_CALCULATE;
		}
	}
	

}
