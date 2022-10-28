package mx.ipn.upiicsa.poo.practica4.bs;

import mx.ipn.upiicsa.poo.practica4.exception.*;


public class Calculadora {
	public static final int OPERATOR_SUMA = 1;
	public static final int OPERATOR_RESTA = 2;
	public static final int OPERATOR_PRODUCTO = 3;
	public static final int OPERATOR_DIVISION = 4;
	public static final int OPERATOR_PORCENTAJE = 5;
	
	public static final int FUNCION_SENO = 6;
	public static final int FUNCION_COSENO = 7;
	public static final int FUNCION_TANGENTE = 8;

	public static final int FUNCTION_RAIZ2 = 9;
	public static final int FUNCTION_RAIZ3 = 10;

	public static final int FUNCION_EULER = 11;

	public static final int FUNCION_LOG_NAT = 12;
	public static final int FUNCION_LOG_10 = 13;

	public static final int FUNCION_FRACCION = 14;

	public static final int FUNCION_FACTORIAL = 15;

	public static final int FUNCTION_ALCUADRADO = 16;
	public static final int FUNCTION_ALCUBO = 17;
	public static final int FUNCTION_10 = 18;

	public static final int OPERATOR_N_RAIZ = 19;
	public static final int OPERATOR_RAISED_POWER_N = 20;
	
	private static final int DOS = 2;
	private static final int TRES = 3;
	private static final int TEN = 10;

	public static final Double PI_CONSTANT = Math.PI;
	public static final Double E_CONSTANT = Math.E;

	public Double calculate(int operator, Double valor1, Double valor2) throws DivZeroException {

		Double resultado;
		switch (operator) {

		case OPERATOR_SUMA:
			resultado = suma(valor1, valor2);
			break;

		case OPERATOR_RESTA:
			resultado = resta(valor1, valor2);
			break;

		case OPERATOR_PRODUCTO:
			resultado = producto(valor1, valor2);
			break;

		case OPERATOR_DIVISION:

			resultado = division(valor1, valor2);
			break;

		case OPERATOR_PORCENTAJE:
			resultado = porcentaje(valor1, valor2);
			break;
			
		case OPERATOR_N_RAIZ:
			resultado = raizN(valor1, valor2);
			break;
		case OPERATOR_RAISED_POWER_N:
			resultado = alaN(valor1, valor2);
			break;

		default:
			resultado = -1.0;
			break;

		}
		return resultado;
	}

	public Double suma(Double sumando1, Double sumando2) {

		return sumando1 + sumando2;

	}

	public Double resta(Double minuendo, Double sustraendo) {

		return minuendo - sustraendo;
	}

	public Double producto(Double factor1, Double factor2) {

		return factor1 * factor2;
	}

	public Double division(Double dividendo, Double divisor) throws DivZeroException {

		if (divisor == 0) {

			throw new DivZeroException();
		}

		return dividendo / divisor;
	}

	public Double porcentaje(Double cantidad, Double porcentaje) {

		return (cantidad * porcentaje) / 100;
	}
	public Double sin(Double ang) {
		return Math.sin(Math.toRadians(ang));
	}

	public Double cos(Double ang) {
		return Math.cos(Math.toRadians(ang));
	}

	public Double tan(Double ang) {
		return Math.tan(Math.toRadians(ang));
	}

	private Double raiz3(Double valor) {
		return Math.cbrt(valor);
	}

	private Double raiz2(Double valor) throws NegativeRaizException {
		if (valor < 0) {
			throw new NegativeRaizException();
		}
		return Math.sqrt(valor);
	}

	public Double eulerExp(Double valor) {
		return Math.exp(valor);
	}

	public Double logNat(Double valor) throws NegativeLogException {
		if (valor <= 0) {
			throw new NegativeLogException();
		}
		return Math.log(valor); // Returns the natural logarithm (base e) of a double value.
	}

	public Double log10(Double valor) throws NegativeLogException {
		if (valor <= 0) {
			throw new NegativeLogException();
		}
		return Math.log10(valor);
	}

	public Double fraction(Double valor) {
		return 1 / valor;
	}

	public Double factorial(Double valor) throws FactorialException {
		if (valor != valor.intValue()) {
			throw new FactorialException();
		}
		Double res = 1.0;
		while (valor != 0) {
			res = res * valor;
			valor--;
		}
		return res;
	}

	public Double alCuadrado(Double valor) {
		return Math.pow(valor, DOS);
	}

	public Double alCubo(Double valor) {
		return Math.pow(valor, TRES);
	}

	public Double raised10(Double valor) {
		return Math.pow(TEN, valor);
	}

	public Double raizN(Double valor1, Double valor2) {
		return Math.pow(valor1,(double)1/valor2);
	}

	public Double alaN(Double valor1, Double valor2) {
		return Math.pow(valor1, valor2);
	}
	
	public Double calculateFunction(int operator, Double valor)
			throws NegativeLogException, NegativeRaizException, FactorialException {
		Double resultado = null;
		switch (operator) {
		case FUNCION_SENO:
			resultado = sin(valor);
			break;
		case FUNCION_COSENO:
			resultado = cos(valor);
			break;
		case FUNCION_TANGENTE:
			resultado = tan(valor);
			break;
		case FUNCTION_RAIZ2:
			resultado = raiz2(valor);
			break;
		case FUNCTION_RAIZ3:
			resultado = raiz3(valor);
			break;
		case FUNCION_EULER:
			resultado = eulerExp(valor);
			break;
		case FUNCION_LOG_NAT:
			resultado = logNat(valor);
			break;
		case FUNCION_LOG_10:
			resultado = log10(valor);
			break;
		case FUNCION_FRACCION:
			resultado = fraction(valor);
			break;
		case FUNCION_FACTORIAL:
			resultado = factorial(valor);
			break;
		case FUNCTION_ALCUADRADO:
			resultado = alCuadrado(valor);
			break;
		case FUNCTION_ALCUBO:
			resultado = alCubo(valor);
			break;
		case FUNCTION_10:
			resultado = raised10(valor);
			break;
		default:
			resultado = -1.0;
			break;
		}
		return resultado;
	}

	
}
