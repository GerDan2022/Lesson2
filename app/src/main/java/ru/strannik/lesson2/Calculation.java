package ru.strannik.lesson2;

import android.app.Activity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculation extends AppCompatActivity {
    private float Slagaemoe1;
    private float Slagaemoe2;
    private float Umenshaemoe;
    private float Vychitaemoe;
    private float Mnogitel1;
    private float Mnogitel2;
    private float Delimoe;
    private float Delitel;
    private float Persent;

    private String result;

// метод расчета итоговых значений
    public String Calc(String text) {
        int myPos = 0;
        int curResult = 0;
        //найдем номер позиции соответсвующего арифм.знака
        int summ = (text.indexOf('+'));
        int deduction = (text.lastIndexOf('-'));
        int mult = (text.indexOf('x'));
        int division = (text.indexOf('/'));
        int percent = (text.indexOf('%'));


        result = text;

        //если существует +
        if (summ > 0 && percent < 0) {
            //найдем его позицию в строке
            myPos = (int) text.indexOf('+');
            //попробуем преобразовать в числа до + и после него
            //если получиться сложим и вернём результат
            try {
                Slagaemoe1 = Float.parseFloat(text.substring(0, myPos));
                Slagaemoe2 = Float.parseFloat(text.substring(myPos + 1, text.length()));
                //посчитаем целую часть от сложения
                int celoe = (int) (Slagaemoe1 + Slagaemoe2);
                //посчитаем дробную часть от сложения
                float ostatok = (Slagaemoe1 + Slagaemoe2) - celoe;
                //если остаток 0 тогда в результате выведем только целую часть без 0
                if (ostatok == 0)
                    result = Integer.toString((int) (Slagaemoe1 + Slagaemoe2));
                else // инчае если есть дробная часть выведем все полностью
                    result = Float.toString(Slagaemoe1 + Slagaemoe2);
            } catch (NumberFormatException e) {
                //если преобразование не удалось вернём изначальный текст
                result = text;
            }
        }

        //если существует "-"
        if (deduction > 0 && percent < 0) {
            //найдем его позицию в строке
            myPos = (int) text.lastIndexOf('-');
            //попробуем преобразовать в числа до "-" и после него
            //если получиться вычтем и вернём результат
            try {
                Umenshaemoe = Float.parseFloat(text.substring(0, myPos));
                Vychitaemoe = Float.parseFloat(text.substring(myPos + 1, text.length()));
                /*
                BigDecimal umenshaemoeBD = new BigDecimal(Umenshaemoe);
                BigDecimal vychitaemoeBD = new BigDecimal(Vychitaemoe);
                BigDecimal resultBD = new BigDecimal(0);
                MathContext returnRules = new MathContext(2, RoundingMode.HALF_DOWN);

                 */

                //посчитаем целую часть от вычитания
                int celoe = (int) (Umenshaemoe - Vychitaemoe);
                //посчитаем дробную часть от вычитания
                float ostatok = (Umenshaemoe - Vychitaemoe) - celoe;
                //если остаток 0 тогда в результате выведем только целую часть без 0
                if (ostatok == 0)
                    result = Integer.toString((int) (Umenshaemoe - Vychitaemoe));
                else { // инчае если есть дробная часть выведем все полностью
                    result = Float.toString(Umenshaemoe - Vychitaemoe);
                    // resultBD = umenshaemoeBD.subtract(vychitaemoeBD, returnRules);
                    // result = resultBD.toString();
                }
            } catch (NumberFormatException e) {
                //если преобразование не удалось вернём изначальный текст
                result = text;
            }
        }

        //если существует "x"
        if (mult > 0 && percent < 0) {
            //найдем его позицию в строке
            myPos = (int) text.indexOf('x');
            //попробуем преобразовать в числа до "x" и после него
            //если получиться вычтем и вернём результат
            try {
                Mnogitel1 = Float.parseFloat(text.substring(0, myPos));
                Mnogitel2 = Float.parseFloat(text.substring(myPos + 1, text.length()));
                //посчитаем целую часть от умножения
                int celoe = (int) (Mnogitel1 * Mnogitel2);
                //посчитаем дробную часть от умножения
                float ostatok = (Mnogitel1 * Mnogitel2) - celoe;
                //если остаток 0 тогда в результате выведем только целую часть без 0
                if (ostatok == 0)
                    result = Integer.toString((int) (Mnogitel1 * Mnogitel2));
                else // инчае если есть дробная часть выведем все полностью
                    result = Float.toString(Mnogitel1 * Mnogitel2);
            } catch (NumberFormatException e) {
                //если преобразование не удалось вернём изначальный текст
                result = text;
            }
        }

        //если существует "/"
        if (division > 0 && percent < 0) {

            //найдем его позицию в строке
            myPos = (int) text.indexOf('/');
            //попробуем преобразовать в числа до "/" и после него
            //если получиться вычтем и вернём результат
            try {
                Delimoe = Float.parseFloat(text.substring(0, myPos));
                Delitel = Float.parseFloat(text.substring(myPos + 1, text.length()));
                //посчитаем целую часть от деления
                int celoe = (int) (Delimoe / Delitel);
                //посчитаем дробную часть от деления
                float ostatok = (Delimoe / Delitel) - celoe;
                //если остаток 0 тогда в результате выведем только целую часть без 0
                if (ostatok == 0)
                    result = Integer.toString((int) (Delimoe / Delitel));
                else // инчае если есть дробная часть выведем все полностью
                    result = Float.toString(Delimoe / Delitel);
            } catch (NumberFormatException e) {
                //если преобразование не удалось вернём изначальный текст
                result = text;
            }
        }

        //если существует только "%"
        if (percent > 0 && division < 0 && mult < 0 && deduction < 0 && summ < 0) {
            //найдем его позицию в строке
            myPos = (int) text.indexOf('%');
            //попробуем преобразовать в число до "%"
            //если получиться посчитаем процент и вернём результат
            try {
                Persent = Float.parseFloat(text.substring(0, myPos));
                result = Float.toString(Persent / 100);
            } catch (NumberFormatException e) {
                //если преобразование не удалось вернём изначальный текст
                result = text;
            }
        }

        //если существует НЕ только "%", а и ариф. действие
        if (percent > 0 && (division > 0 || mult > 0 || deduction > 0 || summ > 0)) {
            //найдем число, знак и величину %
            String[] values = chislo_Sign(text);
            try {
                //число до ариф.знака
                float chislo = Float.parseFloat(values[0]);
                //ариф.знак
                String sign = values[1];
                //величина процента
                float percentValue = Float.parseFloat(values[2]);
                //переведём процент в число
                float curPercent = percentValue / 100;
                //посчитаем процент от числа
                float rezPercent = chislo * curPercent;
                //посчитаем общий итог
                switch (sign) {
                    case "+":
                        result = Float.toString(chislo + rezPercent);
                        break;
                    case "-":
                        result = Float.toString(chislo - rezPercent);
                        break;
                    case "x":
                        result = Float.toString(rezPercent);
                        break;
                    case "/":
                        result = Float.toString(chislo / rezPercent);
                        return result;

                }
                return result;


            } catch (NumberFormatException e) {
                //если преобразование не удалось вернём изначальный текст
                result = text;
            }
        }
        return result;
    }

    //Определение числа, знака и процента
    public String[] chislo_Sign(String text) {
        if (text.charAt(0) == '-') {
            for (int i = 1; i < text.length() - 1; i++) {
                if ((text.charAt(i) == '+') || (text.charAt(i) == '-') || (text.charAt(i) == 'x') || (text.charAt(i) == '/')) {
                    int myPosSign = i;
                    String mySign = text.substring(myPosSign, myPosSign + 1);
                    String chislo = text.substring(0, myPosSign);
                    String percent = text.substring(myPosSign + 1, text.length() - 1);
                    return new String[]{chislo, mySign, percent};
                }
            }
        } else {
            for (int i = 0; i < text.length() - 1; i++) {
                if ((text.charAt(i) == '+') || (text.charAt(i) == '-') || (text.charAt(i) == 'x') || (text.charAt(i) == '/')) {
                    int myPosSign = i;
                    String mySign = text.substring(myPosSign, myPosSign + 1);
                    String chislo = text.substring(0, myPosSign);
                    String percent = text.substring(myPosSign + 1, text.length() - 1);
                    return new String[]{chislo, mySign, percent};

                }

            }
        }
        return new String[]{"-1", "-1", "-1"};
    }
}