package Model;

import java.util.*;

public class Polinom {
	private List<Monom> polinom = new ArrayList<Monom>();
	private int numarMonoame;

	public void addMonom(Monom monom) {
		polinom.add(monom);
		this.numarMonoame++;

	}

	public Monom getMonom(int i) {
		return polinom.get(i);
	}

	public int getNrMonoame() {
		return this.numarMonoame;
	}

	public String toString() {
		String stringPolinom = "";
		for (Monom m : polinom) {
			if (polinom.get(polinom.size() - 1) == m)
				stringPolinom = stringPolinom + m.toString();
			else
				stringPolinom = stringPolinom + m.toString() + "+";
			stringPolinom = stringPolinom.replace("+-", "-");
		}
		return stringPolinom;
	}

	public void reset() {
		polinom.clear();
		numarMonoame = 0;
	}

	public boolean isEmpty() {
		if (polinom.isEmpty() == true)
			return true;
		else
			return false;
	}

}
