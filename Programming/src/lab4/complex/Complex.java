package lab4.complex;

public class Complex {

    final private double m_real_part;
    final private double m_imaginary_part;

    public double GetRealPart() {
        return m_real_part;
    }

    public double GetImaginaryPart() {
        return m_imaginary_part;
    }

    public Complex(double real_part, double imaginary_part) {
        m_real_part = real_part;
        m_imaginary_part = imaginary_part;
    }

    public Complex Add(Complex number) {
        double r_part = m_real_part + number.GetRealPart();
        double imag_part = m_imaginary_part + number.GetImaginaryPart();
        Complex res = new Complex(r_part, imag_part);

        return res;
    }

    public Complex Add(double number) {
        double r_part = (m_real_part + number);
        Complex res = new Complex(r_part, m_imaginary_part);

        return res;
    }

    public Complex Sub(Complex number) {
        return new Complex(m_real_part - number.GetRealPart(), m_imaginary_part - number.GetImaginaryPart());
    }

    public Complex Sub(double number) {
        return new Complex(m_real_part - number, m_imaginary_part);
    }

    public Complex Mult(Complex number) {
        Complex res = new Complex(m_real_part * number.GetRealPart() - m_imaginary_part * number.GetImaginaryPart(), m_real_part * number.m_imaginary_part + number.GetRealPart() * m_imaginary_part);

        return res;
    }

    public Complex Mult(double number)  //0 - это результат умножения на мнимую часть number
    {
        Complex res = new Complex(m_real_part * number - 0, 0 + number * m_imaginary_part);

        return res;
    }

    public Complex Divide(Complex number) {
        double r_part = (m_real_part * number.GetRealPart() + m_imaginary_part * number.GetImaginaryPart()) / (number.GetRealPart() * number.GetRealPart() + number.GetImaginaryPart() * number.GetImaginaryPart());
        double imag_part = (number.GetRealPart() * m_imaginary_part - m_real_part * number.GetImaginaryPart()) / (number.GetRealPart() * number.GetRealPart() + number.GetImaginaryPart() * number.GetImaginaryPart());
        Complex res = new Complex(r_part, imag_part);

        return res;
    }

    public Complex Divide(double number) {
        double r_part = (m_real_part * number + 0) / (number * number + 0);
        double imag_part = (number * m_imaginary_part - 0) / (number * number + 0);
        Complex res = new Complex(r_part, imag_part);

        return res;
    }

    public void PrintAlgebraForm() {
        if (m_imaginary_part >= 0) {
            System.out.println(m_real_part + " + " + m_imaginary_part + "i");
        } else {
            System.out.println(m_real_part + "" + m_imaginary_part + "i");
        }
    }

    public Complex Conjugate()          //комплексное сопряжение
    {
        Complex res = new Complex(m_real_part, m_imaginary_part * (-1));

        return res;
    }

    //#3______________________________________________________________
    public static Complex Exp(Complex number) {
        double r_part = Math.exp(number.GetRealPart()) * Math.cos(number.GetImaginaryPart());
        double imag_part = Math.exp(number.GetRealPart()) * Math.sin(number.GetImaginaryPart());

        return new Complex(r_part, imag_part);
    }

    public static Complex Sin(Complex number)
    {
        double r_part = Math.sin(number.GetRealPart()) * Ch(number.GetImaginaryPart());
        double imag_part = Math.cos(number.GetRealPart()) * Sh(number.GetImaginaryPart());

        return new Complex(r_part,imag_part);
    }
    public static Complex Cos(Complex number)
    {
        double r_part = Math.cos(number.GetRealPart()) * Ch(number.GetImaginaryPart());
        double imag_part = Math.sin(number.GetRealPart()) * Sh(number.GetImaginaryPart());

        return new Complex(r_part,imag_part);
    }

    public static Complex Sh(Complex number)
    {
        //calculate exp(number)
        Complex exp_number = Exp(number);
        double r_part2 = 1/Math.cos(number.GetImaginaryPart());
        double imag_part2 = 1/Math.sin(number.GetImaginaryPart());

        double r_part3 = (exp_number.GetRealPart() - r_part2)/2;
        double imag_part3 = (exp_number.GetImaginaryPart() - imag_part2)/2;

        return new Complex(r_part3,imag_part3);
    }

    public static Complex Ch(Complex number)
    {

        Complex exp_number = Exp(number);
        double r_part2 = 1/Math.cos(number.GetImaginaryPart());
        double imag_part2 = 1/Math.sin(number.GetImaginaryPart());

        double r_part3 = (exp_number.GetRealPart() + r_part2)/2;
        double imag_part3 = (exp_number.GetImaginaryPart() + imag_part2)/2;

        return new Complex(r_part3,imag_part3);
    }

    private static double Sh(double number)
    {
        return (Math.exp(number) - Math.exp(-number))/2;
    }

    private static double Ch(double number)
    {
        return (Math.exp(number) + Math.exp(-number))/2;
    }

    public static Complex Th(Complex number)
    {
        return Sh(number).Divide(Ch(number));       //sh(number)/ch(number)
    }

    public static Complex Cth(Complex number)
    {
        return Sh(number).Divide(Ch(number));       //ch(number)/sh(number)
    }


    public static void main(String[] args) {
        Complex num1 = new Complex(1,5);
        Complex num2 = new Complex(2,4);

        //test operations
        /*
        Complex sum_numbers = num1.Add(num2);
        sum_numbers.PrintAlgebraForm();

        Complex sub_numbers = num1.Sub(num2);
        sub_numbers.PrintAlgebraForm();

        Complex mult_numbers = num1.Mult(num2);
        mult_numbers.PrintAlgebraForm();

        Complex dev_numbers = num1.Divide(num2);
        dev_numbers.PrintAlgebraForm();

        Complex conjugated_number = dev_numbers.Conjugate();
        conjugated_number.PrintAlgebraForm();*/

        Complex Sh_number = Sh(num2);
        Sh_number.PrintAlgebraForm();
    }

    }
