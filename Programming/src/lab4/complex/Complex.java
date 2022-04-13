package lab4.complex;

public class Complex {

    private int m_real_part;
    private int m_imaginary_part;

    public int GetRealPart() { return m_real_part; }
    public int GetImaginaryPart() { return m_imaginary_part; }

    public Complex(int real_part,int imaginary_part)
    {
        m_real_part = real_part;
        m_imaginary_part = imaginary_part;
    }

    public Complex Add(Complex number)
    {
        int r_part = m_real_part + number.GetRealPart();
        int imag_part = m_imaginary_part + number.GetImaginaryPart();
        Complex res = new Complex(r_part,imag_part);

        return res;
    }

    public Complex Sub(Complex number)
    { return new Complex(m_real_part - number.GetRealPart(),m_imaginary_part - number.GetImaginaryPart());}

    public void PrintAlgebraForm()
    {
        if (m_imaginary_part >= 0)
        { System.out.println(m_real_part + " + "+ m_imaginary_part + "i"); }
        else
        { System.out.println(m_real_part + "" + m_imaginary_part + "i"); }
    }



    public static void main(String[] args) {
        Complex num1 = new Complex(2,5);
        Complex num2 = new Complex(-3,8);

        Complex sum_numbers = num1.Add(num2);
        sum_numbers.PrintAlgebraForm();

        Complex sub_numbers = num1.Sub(num2);
        sub_numbers.PrintAlgebraForm();
    }

    }
