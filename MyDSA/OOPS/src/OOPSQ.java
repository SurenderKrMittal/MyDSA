public class OOPSQ {
    public static void main(String[] args) {
        Complex c = new Complex(4 ,5);
        Complex d = new Complex(7 , 9);

        Complex e = Complex.addComplex(c , d);
        Complex f = Complex.diffComplex(c , d);
        Complex g = Complex.product(c , d);

        Complex.printComplex(e);
        Complex.printComplex(f);
        Complex.printComplex(g);
    }
}

class Complex {
    int real;
    int img;

    public Complex(int real,  int img) {
        this.real = real;
        this.img = img;
    }

    public static Complex addComplex(Complex a , Complex b) {
        return new Complex((a.real + b.real), (a.img + b.img));
    }

    public static Complex diffComplex(Complex a , Complex b) {
        return new Complex((a.real - b.real) , (a.img - b.img));
    } 

    public static Complex product(Complex a , Complex b) {
        return new Complex(((a.real * b.real) - (a.img * b.img)) , ((a.real * b.img) - (a.img * b.real)));
    }

    public static void printComplex(Complex a) {
        if(a.real == 0 && a.img != 0) {
            System.out.println(a.img);
        } else if (a.real != 0 && a.img == 0) {
            System.out.println(a.real);
        } else {
            System.out.println("( " + a.real + " , " + a.img + " )");
        }
    }
}

// b

