package pt2020.tema1.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import pt2020.tema1.model.Monom;
import pt2020.tema1.model.Operatii;
import pt2020.tema1.model.Polinom;

public class PolynomialOpertaionTest {

	@Test
	public void test() {
		Polinom p = new Polinom();
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(4,1);
		Monom m3 = new Monom(5,0);
		Operatii op =new Operatii();
		p.addMonom(m1);
		p.addMonom(m2);
		p.addMonom(m3);
		 // p = 3x^2+4x+5
		Polinom q = new Polinom();
		Monom m4= new Monom(4,4);
		Monom m5= new Monom(3,2);
		Monom m6= new Monom(5,1);
		q.addMonom(m4);
		q.addMonom(m5);
		q.addMonom(m6);
		//q = 4x^4+3x^2+5x
	
		assertEquals("4x^4+6x^2+9x+5",op.addition(p, q).toString());
		assertEquals("-4x^4-x+5",op.substraction(p, q).toString());
		assertEquals(25,op.findValue(p, 2));
		assertEquals("16x^3+6x+5",op.derivate(q).toString());
		
	}

}
