package pt2020.tema1.model;

public class Monom {
	private int coeficient;
	private int power;

	public Monom(int coeff, int power) {
		setCoeficient(coeff);
		setPutere(power);
	}

	public void setCoeficient(int coef) {
		this.coeficient = coef;
	}

	public void setPutere(int power) {
		this.power = power;
	}

	public int getCoeficient() {
		return this.coeficient;
	}

	public int getPutere() {
		return this.power;
	}

	public String toString() {
		String monomString = "";
		if (this.coeficient == 0) {
			monomString += "";
		} else if (this.coeficient == 1) {
			if (this.power == 0) {
				monomString += this.coeficient;
			} else if (this.power == 1) {
				monomString += "x";
			} else {
				monomString += "x^" + this.power;
			}
		} else if (this.coeficient == -1) {
			if (this.power == 0) {
				monomString += this.coeficient;
			} else if (this.power == 1) {
				monomString += "-x";
			} else {
				monomString += "-x^" + this.power;
			}
		} else if (this.power == 0) {
			monomString += this.coeficient;
		} else if (this.power == 1) {
			monomString += this.coeficient + "x";
		} else {
			monomString += this.coeficient + "x^" + this.power;
		}
		return monomString;
	}
}
