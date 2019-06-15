package mian;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumaTest {

	@Test
	void test() {
		Suma s = new Suma(2, 3);
		int res = s.getNum1() + s.getNum2();
		assertEquals(res, s.sumar(2, 3));
	}

}
