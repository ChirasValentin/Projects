package Model;

public class Operatii {
	public Polinom derivate(Polinom p) {
		Polinom derivative = new Polinom();
		int i = 0;
		try {
			while (i < p.getNrMonoame()) {

				if (p.getMonom(i).getPutere() != 0) {
					Monom m = new Monom(p.getMonom(i).getCoeficient() * p.getMonom(i).getPutere(),
							p.getMonom(i).getPutere() - 1);
					derivative.addMonom(m);
				}
				i++;
			}
		} catch (Exception e) {
		}
		;
		return derivative;
	}

	public Polinom addition(Polinom p, Polinom q) {
		Polinom sum = new Polinom();
		int i = 0, j = 0;
		Monom m;
		try {
			while (i < p.getNrMonoame() && j < q.getNrMonoame()) {
				if (p.getMonom(i).getPutere() == q.getMonom(j).getPutere()) {
					m = new Monom(p.getMonom(i).getCoeficient() + q.getMonom(j).getCoeficient(),
							p.getMonom(i).getPutere());
					i++;
					j++;
				} else if (p.getMonom(i).getPutere() > q.getMonom(j).getPutere()) {
					m = new Monom(p.getMonom(i).getCoeficient(), p.getMonom(i).getPutere());
					i++;
				} else {
					m = new Monom(q.getMonom(j).getCoeficient(), q.getMonom(j).getPutere());
					j++;
				}
				sum.addMonom(m);
			}
			while (i < p.getNrMonoame()) {
				m = new Monom(p.getMonom(i).getCoeficient(), p.getMonom(i).getPutere());
				i++;
				sum.addMonom(m);
			}
			while (j < q.getNrMonoame()) {
				m = new Monom(q.getMonom(j).getCoeficient(), q.getMonom(j).getPutere());
				j++;
				sum.addMonom(m);
			}

		} catch (Exception e) {
		}
		;

		return sum;
	}

	public Polinom substraction(Polinom p, Polinom q) {
		Polinom substraction = new Polinom();
		int i = 0, j = 0;
		Monom m;
		try {
			while (i < p.getNrMonoame() && j < q.getNrMonoame()) {
				if (p.getMonom(i).getPutere() == q.getMonom(j).getPutere()) {
					m = new Monom(p.getMonom(i).getCoeficient() - q.getMonom(j).getCoeficient(),
							p.getMonom(i).getPutere());
					i++;
					j++;
				} else if (p.getMonom(i).getPutere() > q.getMonom(j).getPutere()) {
					m = new Monom(p.getMonom(i).getCoeficient(), p.getMonom(i).getPutere());
					i++;
				} else {
					m = new Monom(-q.getMonom(j).getCoeficient(), q.getMonom(j).getPutere());
					j++;
				}
				substraction.addMonom(m);
			}
			while (i < p.getNrMonoame()) {
				m = new Monom(p.getMonom(i).getCoeficient(), p.getMonom(i).getPutere());
				i++;
				substraction.addMonom(m);
			}
			while (j < q.getNrMonoame()) {
				m = new Monom(-q.getMonom(j).getCoeficient(), q.getMonom(j).getPutere());
				j++;
				substraction.addMonom(m);
			}

		} catch (Exception e) {
		}
		;

		return substraction;
	}

	public Polinom multiplication(Polinom p, Polinom q) {
		Polinom mul = new Polinom();

		int i = 0, j = 0;
		Monom m;
		try {
			while (i < p.getNrMonoame()) {
				while (j < q.getNrMonoame()) {
					m = new Monom(p.getMonom(i).getCoeficient() * q.getMonom(j).getCoeficient(),
							p.getMonom(i).getPutere() + q.getMonom(j).getPutere());
					mul.addMonom(m);

					j++;
				}
				j = 0;
				i++;
			}
		} catch (Exception e) {
		}
		;

		return mul;
	}

	public int findValue(Polinom p, int valueOfx) {
		int i = 0;
		int value = 0;
		try {
			while (i < p.getNrMonoame()) {
				value += p.getMonom(i).getCoeficient() * Math.pow(valueOfx, p.getMonom(i).getPutere());
				i++;
			}
		} catch (Exception e) {
		}
		;
		return value;
	}
}
