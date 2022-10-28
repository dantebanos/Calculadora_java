package mx.ipn.upiicsa.poo.practica4.gui;

import mx.ipn.upiicsa.poo.practica4.bs.Calculadora;
import mx.ipn.upiicsa.poo.practica4.exception.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class VentanaCalculadoraCientifica extends VentanaCalculadoraBasica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buttonPi;
	private JButton buttonAlCuadrado;
	private JButton buttonAlCubo;
	private JButton buttonPotencia;
	private JButton buttonNumE;
	private JButton buttonLogaritmoNatural;
	private JButton buttonLogaritmo10;
	private JButton buttonSeno;
	private JButton buttonCoseno;
	private JButton buttonTangente;
	private JButton buttonExponencial;
	private JButton buttonRaiz2;
	private JButton buttonRaiz3;
	private JButton buttonExp10;
	private JButton buttonFracion;
	private JButton buttonEulerExp;
	private JButton buttonRaizN;
	private int function;

	private static final String M_ERROR = "MATH ERROR";
	private static final String S_ERROR = "SINTAX ERROR";

	private static final int STATE_FUNCTION = 4;

	private static final int ACTION_FUNCTION = 4;

	public VentanaCalculadoraCientifica() {

	}

	public int getFunction() {
		return function;
	}

	public void setFunction(int function) {
		this.function = function;
	}

	private void capturarFuncion(int function) {
		setFunction(function);
		actualizarEstado(ACTION_FUNCTION);
		actualizarDisplay(display.getText());
	}

	@Override
	protected void initializeListener() {
		super.initializeListener();
		buttonSeno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCION_SENO);
			}
		});
		buttonCoseno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCION_COSENO);
			}
		});
		buttonTangente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCION_TANGENTE);
			}
		});
		buttonNumE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarDisplay();
				capturarNumero(Calculadora.E_CONSTANT.toString());
			}
		});
		buttonPi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarDisplay();
				capturarNumero(Calculadora.PI_CONSTANT.toString());
			}
		});

		buttonRaiz3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_RAIZ3);

			}
		});

		buttonRaiz2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_RAIZ2);

			}
		});

		buttonEulerExp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCION_EULER);

			}
		});

		buttonLogaritmoNatural.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCION_LOG_NAT);
			}
		});

		buttonLogaritmo10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCION_LOG_10);

			}
		});

		buttonFracion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCION_FRACCION);

			}
		});

		buttonExponencial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCION_FACTORIAL);

			}
		});

		buttonAlCuadrado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_ALCUADRADO);

			}
		});

		buttonAlCubo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_ALCUBO);

			}
		});

		buttonExp10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarFuncion(Calculadora.FUNCTION_10);

			}
		});

		buttonRaizN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_N_RAIZ);
			}
		});

		buttonPotencia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				capturarOperador(Calculadora.OPERATOR_RAISED_POWER_N);

			}
		});

	}

	@Override
	protected void buildGrid() {
		GridBagLayout calculadoraGrid = new GridBagLayout();
		GridBagConstraints calculadoraGridContraints = new GridBagConstraints();
		setLayout(calculadoraGrid);
		calculadoraGridContraints.fill = GridBagConstraints.HORIZONTAL;
		calculadoraGridContraints.weightx = 0.5;
		calculadoraGridContraints.ipady = 42;
		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 0;
		calculadoraGridContraints.gridwidth = 7;
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);

		add(display, calculadoraGridContraints);
		calculadoraGridContraints.gridwidth = 1;

		calculadoraGridContraints.gridx = 4;
		calculadoraGridContraints.gridy = 1;
		add(buttonLimpiar, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 5;
		calculadoraGridContraints.gridy = 1;
		add(buttonPorcentaje, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 6;
		calculadoraGridContraints.gridy = 1;
		add(buttonDivision, calculadoraGridContraints);
//
		calculadoraGridContraints.gridx = 6;
		calculadoraGridContraints.gridy = 2;
		add(buttonProducto, calculadoraGridContraints);
//
//		//
		calculadoraGridContraints.gridx = 3;
		calculadoraGridContraints.gridy = 2;
		add(button7, calculadoraGridContraints);
//
		calculadoraGridContraints.gridx = 4;
		calculadoraGridContraints.gridy = 2;
		add(button8, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 5;
		calculadoraGridContraints.gridy = 2;
		add(button9, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 6;
		calculadoraGridContraints.gridy = 4;
		add(buttonSuma, calculadoraGridContraints);
//
//		//
//
		calculadoraGridContraints.gridx = 3;
		calculadoraGridContraints.gridy = 3;
		add(button4, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 4;
		calculadoraGridContraints.gridy = 3;
		add(button5, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 5;
		calculadoraGridContraints.gridy = 3;
		add(button6, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 6;
		calculadoraGridContraints.gridy = 3;
		add(buttonResta, calculadoraGridContraints);
//
//		//
//
		calculadoraGridContraints.gridx = 3;
		calculadoraGridContraints.gridy = 4;
		add(button1, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 4;
		calculadoraGridContraints.gridy = 4;
		add(button2, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 5;
		calculadoraGridContraints.gridy = 4;
		add(button3, calculadoraGridContraints);
//
//		//
//
		calculadoraGridContraints.gridx = 4;
		calculadoraGridContraints.gridy = 5;

		add(button0, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 5;
		calculadoraGridContraints.gridy = 5;

		add(buttonPunto, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 6;
		calculadoraGridContraints.gridy = 5;

		add(buttonIgual, calculadoraGridContraints);

//
//		// cientifica
		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 5;
		add(buttonPi, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 5;
		add(buttonAlCuadrado, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 1;
		add(buttonAlCubo, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 1;
		add(buttonPotencia, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 2;
		add(buttonRaiz2, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 3;
		add(buttonNumE, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 3;
		calculadoraGridContraints.gridy = 5;
		add(buttonLogaritmoNatural, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 4;
		add(buttonLogaritmo10, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 4;
		add(buttonSeno, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 3;
		add(buttonCoseno, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 3;
		add(buttonTangente, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 4;
		add(buttonExponencial, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 2;
		add(buttonRaiz3, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 5;
		add(buttonAlCuadrado, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 5;
		add(buttonFracion, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 5;
		add(buttonFracion, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 0;
		calculadoraGridContraints.gridy = 2;
		add(buttonRaiz3, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 1;
		calculadoraGridContraints.gridy = 2;
		add(buttonRaizN, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 2;
		calculadoraGridContraints.gridy = 1;
		add(buttonEulerExp, calculadoraGridContraints);

		calculadoraGridContraints.gridx = 3;
		calculadoraGridContraints.gridy = 1;
		add(buttonExp10, calculadoraGridContraints);

		setVisible(true);

	}

	@Override
	protected void instantiateComponents() {
		super.instantiateComponents();

		buttonPi = new JButton("π");
		buttonAlCuadrado = new JButton("x²");
		buttonAlCubo = new JButton("x³");
		buttonPotencia = new JButton("x^");
		buttonNumE = new JButton("e");
		buttonLogaritmoNatural = new JButton("ln");
		buttonLogaritmo10 = new JButton("log10");
		buttonSeno = new JButton("Sin");
		buttonCoseno = new JButton("Cos");
		buttonTangente = new JButton("Tan");
		buttonExponencial = new JButton("x!");
		buttonRaiz2 = new JButton("2√x");
		buttonRaiz3 = new JButton("3√x");
		buttonExp10 = new JButton("10^");
		buttonFracion = new JButton("1/x");
		buttonEulerExp = new JButton("e^");
		buttonRaizN = new JButton("n√x");

	}

	@Override
	protected void actualizarEstado(int action) {
		if (action == ACTION_CLEAN) {
			state = STATE_INITIAL;
		} else if (state == STATE_FUNCTION && action == ACTION_NUMBER
				|| state == STATE_INITIAL && action == ACTION_NUMBER
				|| state == STATE_OPERATOR && action == ACTION_NUMBER
				|| state == STATE_CALCULATE && action == ACTION_NUMBER) {
			state = STATE_CAPTURE;
		} else if (state == STATE_FUNCTION && action == ACTION_OPERATOR
				|| state == STATE_CAPTURE && action == ACTION_OPERATOR
				|| state == STATE_CALCULATE && action == ACTION_OPERATOR) {
			state = STATE_OPERATOR;
		} else if (state == STATE_CAPTURE && action == ACTION_EQUAL) {
			state = STATE_CALCULATE;
		} else if (state == STATE_INITIAL && action == ACTION_FUNCTION
				|| state == STATE_CALCULATE && action == ACTION_FUNCTION
				|| state == STATE_CAPTURE && action == ACTION_FUNCTION) {
			state = STATE_FUNCTION;
		}
	}

	@Override
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
					resultadoString = S_ERROR;
					JOptionPane.showMessageDialog(this, "División entre 0");
					actualizarEstado(ACTION_CLEAN);
				} catch (NullPointerException e) {
					resultadoString = S_ERROR;
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
				JOptionPane.showMessageDialog(this, "División entre 0");
				actualizarEstado(ACTION_CLEAN);
			}
			display.setText(resultadoString);
		} else if (state == STATE_FUNCTION) {
			String valorString = display.getText();
			String resultadoString = null;
			try {
				valor1 = Double.parseDouble(valorString);
				try {
					resultado = calculadora.calculateFunction(function, valor1);
					resultadoString = resultado.toString();
				} catch (NegativeLogException e) {
					resultadoString = M_ERROR;
					JOptionPane.showMessageDialog(this, "EL Log de un número es cero o negativo");
					actualizarEstado(ACTION_CLEAN);
				} catch (NegativeRaizException e) {
					resultadoString = M_ERROR;
					JOptionPane.showMessageDialog(this, "Raiz de un número negativo");
					actualizarEstado(ACTION_CLEAN);
				} catch (FactorialException e) {
					resultadoString = M_ERROR;
					JOptionPane.showMessageDialog(this, "Factorial de una fracción");
					actualizarEstado(ACTION_CLEAN);
				} finally {
					display.setText(resultadoString);
					actualizarEstado(ACTION_CLEAN);
					valor1 = resultado;
				}
			} catch (NumberFormatException e) {
				if (e.getCause() == null) {
					System.out.println("No se ingreso ningun numero");
					actualizarEstado(ACTION_CLEAN);
				} else {
					resultadoString = S_ERROR;
					actualizarEstado(ACTION_CLEAN);
				}
			} catch (NullPointerException e) {
				resultadoString = S_ERROR;
				actualizarEstado(ACTION_CLEAN);
			}
			display.setText(resultadoString);
		}
	}

}

