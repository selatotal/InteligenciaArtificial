public class Neuronio {
	// Neuronio para 2 entradas

	private double w0; // pesos
	private double w1;
	private double w2;

	public double getW0() {
		return w0;
	}

	public double getW1() {
		return w1;
	}

	public double getW2() {
		return w2;
	}

	public double calculaV(int x1, int x2) {
		return w0 + w1 * x1 + w2 * x2;
	} // calcula o campo local induzido

	public int calculaY(int x1, int x2) { // aplica a funcao
		double v = calculaV(x1, x2);

		if (v >= 0)
			return 1;
		return 0;
	}

	public void setW0(double w0) {
		this.w0 = w0;
	}

	public void setW1(double w1) {
		this.w1 = w1;
	}

	public void setW2(double w2) {
		this.w2 = w2;
	}

	public String toString() {
		return "w0 = " + w0 + " w1= " + w1 + " w2= " + w2;
	}
}
