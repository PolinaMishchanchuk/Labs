package com.company;




/**
 *Страхование. Определить иерархию страховых обязательств. Собрать из обязательств дериватив.
 * Подсчитать стоимость. Провести сортировку обязательств в деривативе на основе уменьшения степени риска.
 * Найти обязательство в деривативе, соответствующее заданному диапазону параметров.
 * @author Polina Mishchanchuk
 * @since JDK 11.0 LTS
 * @serialData
 * @version
 */


public class Main {

    public static void main(String[] args) {
	Deritatiw deritatiw = new Deritatiw(5);

	Strachowka avto = new Avto();
	Strachowka gruz = new Gryz();
	Strachowka jizni = new Jizni();
	Strachowka nesthastnieSluthai = new NesthastnieSluthai();
	Strachowka medizina = new Medizina();
	Strachowka[] strachowkas = {avto,gruz,jizni,medizina,nesthastnieSluthai};

	deritatiw.addStrachowka(medizina);
	deritatiw.addStrachowka(gruz);
	deritatiw.addStrachowka(avto);
	deritatiw.addStrachowka(jizni);
	deritatiw.addStrachowka(nesthastnieSluthai);

	Printer.printDeritatiw(deritatiw.getStrachowkas());
	Printer.PrintPrice(deritatiw.GetStrachowkaCost());


	deritatiw.diapason(deritatiw, 27, 17,3,1);
	System.out.println("\n");
	deritatiw.summa(strachowkas);
    }
}
